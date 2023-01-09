package proginfo.ecam03.Projet.de.Classe.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proginfo.ecam03.Projet.de.Classe.mapper.ActeMapper;
import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;
import proginfo.ecam03.Projet.de.Classe.model.entity.Acte;
import proginfo.ecam03.Projet.de.Classe.repository.ActeRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActeServiceImpl implements IActe {

    @Autowired
    ActeRepository acteRepository;

    ActeMapper acteMapper = Mappers.getMapper(ActeMapper.class);

    @Override
    public int saveActe(ActeDto acteDto) {
        if (acteRepository.findActeByNumero(acteDto.getNumero()).isPresent()) {
            return 0;
        }

        return (int) acteRepository.save(acteMapper.toEntity(acteDto)).getId();

    }

    @Override

    public ActeDto searchActeByNumero(String numero) {

        return acteMapper.toDto(acteRepository.findActeByNumero(numero).get());
    }


    @Override
    public List<ActeDto> listActes() {
        List<Acte> actes = acteRepository.findAll();

        /* List<ActeDto> acteDtos = new ArrayList<ActeDto>();

        for (Acte acte: actes){
            ActeDto acteDto = acteMapper.toDto(acte);
            acteDto.add(acteDto);
        }*/

        return actes.stream().map(acte -> acteMapper.toDto(acte))
                .collect(Collectors.toList());
    }


    @Override
    public int deleteActe(String numero) {
        acteRepository.deleteById(acteRepository.findActeByNumero(numero).get().getId());
        return 1;
    }


    @Override
    public List<ActeDto> searchActesByKeyword(String keyword) {


        return acteRepository.findActeByNumeroOrNom(keyword, keyword).get().stream()
                .map(acteMapper::toDto)
                //map(acte1 -> acteMapper.toDto(acte))
                .collect(Collectors.toList());
    }


    @Override
    public ActeDto updateActe(ActeDto acteDto) {

        // recherche l'entité qui correspond à l'acte voulu update

        Acte acte = acteRepository.findActeByNumero(acteDto.getNumero()).get();
        acteMapper.copy(acteDto, acte);

        return acteMapper.toDto(acteRepository.save(acte));
    }
}


