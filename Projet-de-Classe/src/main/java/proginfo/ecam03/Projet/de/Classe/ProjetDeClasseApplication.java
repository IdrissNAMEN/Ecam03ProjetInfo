package proginfo.ecam03.Projet.de.Classe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proginfo.ecam03.Projet.de.Classe.model.endity.Acte;

import proginfo.ecam03.Projet.de.Classe.service.ActeServiceImpl;

@SpringBootApplication

public class ProjetDeClasseApplication  implements CommandLineRunner {
private final ActeServiceImpl acteServiceImpl;

	public ProjetDeClasseApplication(ActeServiceImpl acteServiceImpl) {
		this.acteServiceImpl = acteServiceImpl;
	}


	public static void main(String[] args) {
		SpringApplication.run(ProjetDeClasseApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Acte a1 = new Acte("SPIDES", "Jean","12/05/2004","Londre","Strasbourg","SPIDES Anatol", "Electricien", "SPIDES Anne", "Assistante");
		Acte a2 = new Acte("TATE","Gérome", "15/11/1950", "Barcelone", "Lyon", "TATE Fédérique", "Ingénieur", "TATE Joelle","Ménagere");
		Acte a3 = new Acte("TRAORRE", "Mounir", "20/05/2001","Abidjan", "Cote Ivoire","TRAORRE Soleman","Enseignant", "TRAORRE Julle", "Assureure");
		System.out.println("............ Add new acte .............");
		System.out.println("Acte info "+ acteServiceImpl.save(a1));
		System.out.println("Acte info" +acteServiceImpl.save(a2));
		System.out.println("Acte info" +acteServiceImpl.save(a3));
		System.out.println("...........List acte.............");
		acteServiceImpl.getAllActe().forEach(acte -> {
			System.out.println("Nom :" +acte.getNom() +"\t Prenom :" +acte.getPrenom() +"\t DateNaissance :" +acte.getDateNaissance() +"" +
					"\t LieuNaissance :" +acte.getLieuNaissance() +"`\t LieuResidence :" +acte.getLieuResidence() +"\t NomPrenomPere :" +acte.getNomPrenomPere()+"\t ProfessionPere :" +acte.getProfessionPere() +"\t NomPrenomMere :" +acte.getNomPrenomMere()+"\t ProfessionMere :" +acte.getProfessionMere());

		});



	}
}
