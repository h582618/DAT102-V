package Datakontaktfirma.klient;

import Datakontaktfirma.*;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Klient {

	public static void main(String[] args) {

		Datakontakt dt = new Datakontakt(20);
		
		KjedetMengde<Hobby> hobbyer = new KjedetMengde<Hobby>();
		Hobby hobby1 = new Hobby("Gitar");
		Hobby hobby2 = new Hobby("Fiske");
		KjedetMengde<Hobby> hobbyer2 = new KjedetMengde<Hobby>();
		
		
		hobbyer.leggTil(hobby1);
		hobbyer2.leggTil(hobby2);
////		
//		Medlem m1 = new Medlem("Geir",0, hobbyer);
//		Medlem m2 = new Medlem("Thomas",1, hobbyer);
//		Medlem m3 = new Medlem("Gjerdt",2, hobbyer2);
//		Medlem m4 = new Medlem("Håvard",3, hobbyer2);
//		Medlem m5 = new Medlem("Bruno",4, hobbyer);
//		

		Medlem m1 = new Medlem("Geir", hobbyer);
		Medlem m2 = new Medlem("Thomas", hobbyer);
		Medlem m3 = new Medlem("Gjerdt", hobbyer2);
		Medlem m4 = new Medlem("Håvard", hobbyer2);
		Medlem m5 = new Medlem("Bruno", hobbyer);
		
		
		
		dt.leggTilMedlem(m1);
		dt.leggTilMedlem(m2);
		dt.leggTilMedlem(m3);
		dt.leggTilMedlem(m4);
		dt.leggTilMedlem(m5);
		
//		Tekstgrensesnitt.skrivParListe(dt);
		
//		dt.tilbakestillStatusIndeks("Geir");
		
		
		Tekstgrensesnitt.skrivParListe(dt);
	}

}
