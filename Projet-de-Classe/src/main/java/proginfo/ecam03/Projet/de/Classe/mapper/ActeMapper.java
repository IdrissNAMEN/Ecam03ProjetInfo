package proginfo.ecam03.Projet.de.Classe.mapper;

import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;
import proginfo.ecam03.Projet.de.Classe.model.entity.Acte;


public interface ActeMapper {

    Acte toEntity (ActeDto acteDto);

    ActeDto toDto(Acte acte);

    void copy(ActeDto acteDto, Acte acte);


}
