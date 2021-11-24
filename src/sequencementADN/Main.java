package sequencementADN;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// char[] tableau = adn.toCharArray();
//		
//		
//		Patient patient1 = new Patient("7777x77x777777x777777");
//		
//		System.out.println(patient1.getSexe() +" "+ patient1.getTaille());
//		
//		Patient patient2 = new Patient("999x999999x999x999999x9999");
//		
//		System.out.println("le patient est de "+patient2.getSexe()+" a "+patient2.getAge()+ " . " +patient2.getTaille());
//		
//		Scanner scan = new Scanner(System.in);
//		
//		// demande nom patient
//		System.out.println("Bonjour, Veuillez entrer votre nom:");
//		String nomPatient = scan.next();
//		
//		//demande age du patient
//		System.out.println("Veuillez entrer votre age:");
//		String agePatientString = "";
//		int agePatient = scan.nextInt();
//		if(agePatient > 65) {
//			agePatientString = "plus de 65 ans";
//			
//		} else if (agePatient > 21) {
//			agePatientString = "plus de 21 ans";
//			
//		} else if (agePatient <= 21) {
//			agePatientString = "moins de 21 ans";
//		} 
//		
//		//demande le sexe du patient
//		System.out.println("Etes vous de sexe feminin ou masculin? ");
//		String sexePatient = scan.next();
//		scan.close();		
//		System.out.println("Bonjour " + nomPatient + " , vous avez "+ agePatient +" ans. Vous êtes de sexe " + sexePatient+" .");
//		
//		
//		
//		Patient patient3 = new Patient("77x77x7");
//			
//			if (agePatientString == patient3.getAge()) {
//				System.out.println("information age bonne");
//			} else {
//				System.out.println("information age fausse! Vous avez "+ patient3.getAge());
//			}
		// System.out::println

		int compteurAge = 0;
		int compteurGenre = 0;
		int compteurMoyenneAge = 0;
		float resultat = 0;
		
		List<Patient> patients = new ArrayList<Patient>();

		try (Stream<String> stream = Files.lines(Paths.get("C:\\adn.txt"))) {
			stream.forEach((k) -> {
				Patient pt = new Patient(k);
				patients.add(pt);
			});

		} catch (IOException e) {
			System.out.println("Erreur");
			e.printStackTrace();
		}
		for (Patient str : patients) {
			if (str.getAge() == "plus de 65 ans") 
				compteurAge++;
			
			if (str.getSexe() == "sexe feminin") 
				compteurGenre++;
			
			if (str.getAge() == "moins de 21 ans") 
				compteurMoyenneAge++;
			
		}
		
		resultat = ((float)compteurMoyenneAge/patients.size())*100;

		
		System.out.println("Il y a "+compteurAge+" personnes de plus de 65 ans, "+compteurGenre+" personnes de sexe feminin et "+resultat+" % ont moins de 21 ans.");
		
	}
}
