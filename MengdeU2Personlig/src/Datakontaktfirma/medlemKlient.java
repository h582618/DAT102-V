package Datakontaktfirma;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class medlemKlient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KjedetMengde<Hobby> hobbyer = new KjedetMengde<Hobby>();
		Hobby hobby1 = new Hobby("Gitar");
		
		hobbyer.leggTil(hobby1);
		Medlem m1 = new Medlem("Geir",1, hobbyer);
	
		m1.skrivUt();
		
	}

	
}
