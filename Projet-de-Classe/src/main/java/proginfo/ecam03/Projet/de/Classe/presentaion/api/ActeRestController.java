package proginfo.ecam03.Projet.de.Classe.presentaion.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;
import proginfo.ecam03.Projet.de.Classe.service.IActe;

import java.util.List;

@RestController
@RequestMapping("/api/acte")
@Slf4j
public class ActeRestController {


    @Autowired
    private IActe iActe;


    @PostMapping(value="/save")
    public void enregistrer(@RequestBody ActeDto create) {
        ActeRestController.log.info("enregistrer-acte");
        iActe.saveActe(create);
    }


    @GetMapping("/{numero}/data")
    public ResponseEntity<ActeDto> getActeByNumero(@PathVariable String numero) {
        return ResponseEntity.ok(iActe.searchActeByNumero(numero));
    }


    @GetMapping("/all")
    public ResponseEntity<List<ActeDto>> getAllActes() {
        return ResponseEntity.ok(iActe.listActes());
    }


    @GetMapping("/{numero}/delete")
    public void deleteActe(@PathVariable String numero) {
        iActe.deleteActe(numero);
    }
}
