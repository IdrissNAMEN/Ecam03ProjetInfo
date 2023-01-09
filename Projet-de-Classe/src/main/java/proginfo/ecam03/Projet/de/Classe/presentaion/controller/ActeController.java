package proginfo.ecam03.Projet.de.Classe.presentaion.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;
import proginfo.ecam03.Projet.de.Classe.model.entity.User;
import proginfo.ecam03.Projet.de.Classe.service.IActe;
import proginfo.ecam03.Projet.de.Classe.service.UserService;

import java.util.List;

@Controller
@Slf4j
public class ActeController {


    @Autowired
    IActe iActe;
    @Autowired
    UserService userService;


    private void setAuthUserName(Model model) {
        final Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        final User user=userService.findUserByEmail(auth.getName());
        if (user!=null)
            model.addAttribute("userName", user.getName()+ " "+user.getLastName());
        else model.addAttribute("");
    }

    @GetMapping("/")
    public String pageAccueil(Model model) {
        setAuthUserName(model);
        return "index";
    }


    @GetMapping("/listedesactes")
    public String pageListDesActes(Model model){
        setAuthUserName(model);
        List<ActeDto> acteDtos = iActe.listActes();
        model.addAttribute("actes", acteDtos);
        return "liste";
    }


    @GetMapping("/details")
    public String pageDetail(@RequestParam(name = "numero") String numero,Model model){
        setAuthUserName(model);
        ActeDto acteDto = iActe.searchActeByNumero(numero);
        model.addAttribute("acteDto", acteDto);
        return "details";
    }



    @GetMapping("/supprimer")
    public String pageSupprimer(@RequestParam(name = "numero") String numero, Model model){
        setAuthUserName(model);
        iActe.deleteActe(numero);
        return "redirect:listedesactes";
    }



    //affichage du formulaire

    @GetMapping("/enregistreracteform")
    public String enregistrerActeForm(Model model){

        setAuthUserName(model);
        ActeDto acteDto = new ActeDto();
        acteDto.setNumero("Fr");
        acteDto.setNom("dibanda");
        acteDto.setPrenom("alfred");
        acteDto.setDateNaissance("02/04/1996");
        acteDto.setLieuNaissance("Douala");
        acteDto.setNomPrenomPere("dibanda emmanuel");
        acteDto.setNomPrenomMere("yoba mispa");
        model.addAttribute("acteDto", acteDto);
        return "enregistrer";
    }


    //affichage du formulaire d'édition d'une acte
    @GetMapping("/editerform")
    public String editerActeForm(@RequestParam(name = "numero") String numero, Model model){
        setAuthUserName(model);
        ActeDto acteDto = iActe.searchActeByNumero(numero);

        model.addAttribute("acteDto", acteDto);
        return "editer";
    }


    @PostMapping("/editerate")
    public String editerActe(@ModelAttribute ActeDto acteDto, Model model){
        setAuthUserName(model);
        ActeController.log.info("editer-acte");

        iActe.updateActe(acteDto);

        return "redirect:/Listactes";
    }



    @PostMapping("/enregistreracte")
    public String enregistrerActe(@ModelAttribute ActeDto acteDto, Model model){
        setAuthUserName(model);
        ActeController.log.info("enregister-acte");
        model.addAttribute("acteDto", acteDto);
        //appel de la couche service ou metier injetée pour enregister un materiel
        iActe.saveActe(acteDto);
        return "redirect:listedesactes";
    }




    @GetMapping("/Rechercherform")
    public String pageRechercher(Model model){
        setAuthUserName(model);
        List<ActeDto> acteDtos = iActe.listActes();
        acteDtos.forEach(acteDto -> System.out.println(acteDto));
        model.addAttribute("acteDtos", acteDtos);
        return "rechercher";
    }


    @GetMapping("/rechercher")
    public String recherche(@RequestParam(name = "motCles") String motCles, Model model){
        setAuthUserName(model);
        List<ActeDto> acteDtos = iActe.searchActesByKeyword(motCles);
        model.addAttribute("acteDtos", acteDtos);
        return "rechercher";
    }


}
