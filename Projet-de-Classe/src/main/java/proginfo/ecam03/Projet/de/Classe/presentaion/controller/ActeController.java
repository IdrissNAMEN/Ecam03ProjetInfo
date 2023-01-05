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
import proginfo.ecam03.Projet.de.Classe.model.endity.User;
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



    @GetMapping("/")
    public String pageAccueil(Model model) {
        final Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        final User user=userService.findUserByEmail(auth.getName());
        if (user!=null)
            model.addAttribute("userName", user.getName()+ " "+user.getLastName());
        else model.addAttribute("");
        return "index";
    }


    @GetMapping("/listedesactes")
    public String pageListDesActes(Model model){
        List<ActeDto> acteDtos = iActe.listActes();
        model.addAttribute("acteDtos", acteDtos);
        return "liste";
    }


    @GetMapping("/detail")
    public String pageDetail(@RequestParam(name = "numero") String numero,Model model){
        ActeDto acteDto = iActe.searchActeByNumero(numero);
        model.addAttribute("acteDto", acteDto);
        return "details";
    }



    @GetMapping("/supprimer")
    public String pageSupprimer(@RequestParam(name = "numero") String numero, Model model){
        iActe.deleteActe(numero);
        return "redirect:listedesactes";
    }



    //affichage du formulaire
    @GetMapping("/enregistreracteform")
    public String enregistrerActeForm(Model model){
        ActeDto acteDto = new ActeDto();
        acteDto.setNumero("Fr");
        model.addAttribute("acteDto", acteDto);
        return "enregistrer";
    }


    //affichage du formulaire d'édition d'une acte
    @GetMapping("/editerform")
    public String editerActeForm(@RequestParam(name = "numero") String numero, Model model){

        ActeDto acteDto = iActe.searchActeByNumero(numero);

        model.addAttribute("acteDto", acteDto);
        return "editer";
    }


    @PostMapping("/editerate")
    public String editerActe(@ModelAttribute ActeDto acteDto, Model model){
        ActeController.log.info("editer-acte");

        iActe.updateActe(acteDto);

        return "redirect:/Listactes";
    }



    @PostMapping("/enregistreracte")
    public String enregistrerActe(@ModelAttribute ActeDto acteDto){
        ActeController.log.info("enregister-acte");
        //appel de la couche service ou metier injetée pour enregister un materiel
        iActe.saveActe(acteDto);
        return "redirect:listedesactes";
    }




    @GetMapping("/Rechercherform")
    public String pageRechercher(Model model){
        List<ActeDto> acteDtos = iActe.listActes();
        acteDtos.forEach(acteDto -> System.out.println(acteDto));
        model.addAttribute("acteDtos", acteDtos);
        return "rechercher";
    }


    @PostMapping("/rechercher")
    public String recherche(@RequestParam(name = "motCles") String motCles, Model model){
        List<ActeDto> acteDtos = iActe.searchActesByKeyword(motCles);
        model.addAttribute("acteDtos", acteDtos);
        return "rechercher";
    }


}
