package proginfo.ecam03.Projet.de.Classe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proginfo.ecam03.Projet.de.Classe.model.dto.ActeDto;
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
		ActeDto a1 = ActeDto.builder()
				.numero("FR200")
				.nom("SPIDES")
				.prenom("Jean")
				.dateNaissance("12/05/2004")
				.lieuNaissance("Londres")
				.nomPrenomPere("SPIDES Anatol")
				.nomPrenomMere("SPIDES Anne")
				.build();

		ActeDto a2 = ActeDto.builder()
				.numero("FR300")
				.nom("DIPUS")
				.prenom("Mathieu")
				.dateNaissance("12/05/1904")
				.lieuNaissance("Marseille")
				.nomPrenomPere("Louis Paul")
				.nomPrenomMere("Louise Anne")
				.build();

		ActeDto a3 = ActeDto.builder()
				.numero("FR400")
				.nom("Misme")
				.prenom("Mireille")
				.dateNaissance("12/05/1916")
				.lieuNaissance("Paris")
				.nomPrenomPere("Dupont Arnold")
				.nomPrenomMere("Dupont Berthe")
				.build();

		System.out.println("............ Add new acte .............");
		System.out.println("Acte info "+ acteServiceImpl.saveActe(a1));
		System.out.println("Acte info" +acteServiceImpl.saveActe(a2));
		System.out.println("Acte info" +acteServiceImpl.saveActe(a3));

	}
}