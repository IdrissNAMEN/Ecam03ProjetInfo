package proginfo.ecam03.Projet.de.Classe.service;


import org.springframework.stereotype.Service;
import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;



import java.util.List;

public interface IActe {


    int saveActe(ActeDto acteDto);
    ActeDto searchActeByNumero(String numero);
    List<ActeDto> listActes();
    int deleteActe(String numero);

    List<ActeDto> searchActesByKeyword(String keyword);

    ActeDto updateActe(ActeDto acteDto);

    //byte[] exportReport(ActeDto acteDto) throws FileNotFoundException, JRExcepton, JRException;


}
