package Datakontaktfirma;

public class Hobby {

	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	public String toString() {
		return "<" + hobbyNavn + ">";
	}
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby)hobby2;
		
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
}
