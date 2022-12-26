package proginfo.ecam03.Projet.de.Classe.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;
import proginfo.ecam03.Projet.de.Classe.model.endity.Acte;

@Mapper
public interface ActeMapper {

    Acte toEntity (ActeDto acteDto);

    ActeDto toDto(Acte acte);

    void copy(ActeDto acteDto, @MappingTarget Acte acte);


}
