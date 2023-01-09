package proginfo.ecam03.Projet.de.Classe.mapper;

import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;
import proginfo.ecam03.Projet.de.Classe.model.entity.Acte;

public class ActeMapperImpl implements ActeMapper{

    @Override
    public Acte toEntity(ActeDto acteDto) {
        Acte acte = new Acte();
        acte.setNumero(acteDto.getNumero());
        acte.setNom(acteDto.getNom());
        acte.setPrenom(acteDto.getPrenom());
        acte.setDateNaissance(acteDto.getDateNaissance());
        acte.setLieuNaissance(acteDto.getLieuNaissance());
        acte.setNomPrenomPere(acteDto.getNomPrenomPere());
        acte.setNomPrenomMere(acteDto.getNomPrenomMere());
        return acte;
    }

    @Override
    public ActeDto toDto(Acte acte) {
        ActeDto acteDto = new ActeDto();
        acteDto.setNumero(acte.getNumero());
        acteDto.setNom(acte.getNom());
        acteDto.setPrenom(acte.getPrenom());
        acteDto.setDateNaissance(acte.getDateNaissance());
        acteDto.setLieuNaissance(acte.getLieuNaissance());
        acteDto.setNomPrenomPere(acte.getNomPrenomPere());
        acteDto.setNomPrenomMere(acte.getNomPrenomMere());
        return acteDto;
    }

    @Override
    public void copy(ActeDto acteDto, Acte acte) {
        acteDto.setNumero(acte.getNumero());
        acteDto.setNom(acte.getNom());
        acteDto.setPrenom(acte.getPrenom());
        acteDto.setDateNaissance(acte.getDateNaissance());
        acteDto.setNomPrenomPere(acte.getNomPrenomPere());
        acteDto.setNomPrenomMere(acte.getNomPrenomMere());
    }
}
