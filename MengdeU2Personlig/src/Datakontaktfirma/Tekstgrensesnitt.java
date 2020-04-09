package Datakontaktfirma;

import java.util.Scanner;

public class Tekstgrensesnitt {

	public static Medlem lesMedlem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Navn");
		String navn = sc.next();
	
		Medlem m = new Medlem(navn);
		
		sc.close();
		
		return m;
	}
	
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {

		Medlem mTab[] = arkiv.getMedlemsTabell();
		System.out.print("Parnavn");
		System.out.printf("%20s","Hobbyer");
		System.out.println("");
		int antallP = 0;
		for (int i = 0; i < arkiv.getMedlemmer(); i++) {
			int indeks = arkiv.finnPartnerFor(mTab[i].getNavn());
			if (indeks > -1) {
				antallP++;
				System.out.printf("%1s,%14s", (mTab[i].getNavn() + " og " + mTab[indeks].getNavn()),mTab[i].getHobbyer());
//				System.out.printf("%15s", mTab[i].getHobbyer());
				System.out.println("");
	
			}
		}
		System.out.println("................");
		System.out.println("Antall par funnet: " + antallP);
	}

	public static void menyValg() {
		Scanner input = new Scanner(System.in);
	}
}
