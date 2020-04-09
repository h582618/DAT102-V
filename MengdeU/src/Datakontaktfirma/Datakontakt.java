package Datakontaktfirma;

import javax.swing.text.html.HTMLDocument.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {

//	MengdeADT <Medlem> mTab;
	Medlem[] mTab;
	int antallMedlemmer;

	public Datakontakt(int n) {

//		mTab = new TabellMengde<Medlem>();
		mTab = new Medlem[n];
		antallMedlemmer = 0;
	}

	public Medlem[] getMedlemsTabell() {
		return mTab;
	}

	public boolean leggTilMedlem(Medlem person) {

		boolean lagtTil = false;
		for (int i = 0; i < mTab.length && !lagtTil; i++) {
			if (mTab[i] != null) {
				if (!mTab[i].equals(person)) {
					mTab[antallMedlemmer] = person;
					antallMedlemmer++;
					lagtTil = true;
				}
			} else {
				mTab[antallMedlemmer] = person;
				antallMedlemmer++;
				lagtTil = true;
			}

		}
		return lagtTil;
	}

//		boolean lagtTil = false;
//		if(!mTab.inneholder(person)) {
//			mTab.leggTil(person);
//		antallMedlemmer++;
//			lagtTil = true;
//		} else {
//			System.out.println(person + " er allerede medlem");
//		}
//		return lagtTil;

	public int finnMedlemsIndeks(String medlemsNavn) {


		int indeks = -1;
		
		for(int i = 0; i  < antallMedlemmer; i++) {
			if(mTab[i].getNavn().equals(medlemsNavn)) {
				indeks = i;
			}
		}
		return indeks;
		
		
	
	}

	public boolean erKoblet(String medlemsNavn) {
		boolean koblet = false;

		int m1 = finnMedlemsIndeks(medlemsNavn);

		for (int i = 0; i < antallMedlemmer; i++) {
			if (m1 == mTab[i].getStatusIndeks() && mTab[i].getNavn() != medlemsNavn) {
				koblet = true;
			}
		}
//		if(m1 > -1) {
//			koblet = true;
//		}

		return koblet;
	}

	public int finnPartnerFor(String medlemsNavn) {

		boolean funnet = false;

		int m1 = finnMedlemsIndeks(medlemsNavn);
		int m2 = -1;

		int indeks = -1;

//		if(!erKoblet(medlemsNavn)){
		for (int i = 0; i < antallMedlemmer && !funnet; i++) {
			m2 = i;
			if ((mTab[m2].passerTil(mTab[m1])) && m1 != m2
//			 Sjekker at indeksen ikke allerede er lik så vi slipper duplikater
					&& mTab[m2].getStatusIndeks() == -1 && mTab[m1].getStatusIndeks() == -1
					) {
				mTab[m2].setStatusIndeks(m1);
				mTab[m1].setStatusIndeks(m2);
				indeks = m2;
				funnet = true;
			}
		}
		
		return indeks;
		

//		int j = -1;
//		Medlem m = finnMedlem(medlemsnavn);
//		
//		for(int i = 0; i < antallMedlemmer; i++ ) {
//			if(!mTab[i].equals(m)) { //Sjekker at de ikke er lik.
//				if(m.passerTil(mTab[i])) {
//					m.setStatusIndeks(1);
//					mTab[i].setStatusIndeks(1);
//				}
//			}
//		}
//		
//		return j;
	}

	public Medlem finnMedlem(String medlemsnavn) {
		Medlem m = null;
		for (int i = 0; i < antallMedlemmer; i++) {
			if (mTab[i].getNavn() == medlemsnavn) {
				m = mTab[i];
				m.setStatusIndeks(i);
				return m;
			}
		}
		return m;
	}

	public void tilbakestillStatusIndeks(String medlemsnavn) {
		int m1 = finnMedlemsIndeks(medlemsnavn);
		int m2 = finnPartnerFor(medlemsnavn);

		if (m1 != -1) {
			mTab[m1].setStatusIndeks(-1);
			mTab[m2].setStatusIndeks(-1);

		}
	}

	public int getMedlemmer() {
		return antallMedlemmer;
	}
}
