package sequencementADN;

public class Patient {

	private String adn;
	private String sexe;
	private String age;
	private String taille;
	
	public Patient(String adn) {
		this.adn = adn;
		//int nombreCaracteres = adn.lengh();
		
		if(adn.contains("7")) {
			this.sexe = "sexe masculin";
			
		} else if (adn.contains("9")) {
			this.sexe = "sexe feminin";
		}
		
		if(adn.length() > 18) {
			this.age = "plus de 21 ans";
			
		} else if (adn.length() > 6) {
			this.age = "moins de 21 ans";
			
		} else {
			this.age = "plus de 65 ans";
		} 
		
		int count = (int) adn.chars().filter(c -> c == 'x').count();
		switch (count) {
		case 1 : this.taille = "Personne entre 0.5m et 1m50";
				break;
		case 2 : this.taille = "Personne entre 1m51 et 1m70";
				break;
		case 3 : this.taille = "Personne entre 1m71 et 1m80";
				break;
		case 4 : this.taille = "Personne entre 1m81 et 1m90";
				break;
		case 5 : this.taille = "Personne de plus de 1m90";
				break;
		}
	}

	public String getAdn() {
		return adn;
	}

	public String getSexe() {
		return sexe;
	}

	public String getAge() {
		return age;
	}

	public String getTaille() {
		return taille;
	}

	
}
