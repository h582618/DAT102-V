package no.hvl.dat102.dobbelkjedetordnetlistem;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeMADT;

//********************************************************************
//  
//  Representerer en dobbeltkjedet ordnet liste med midtpeker.
//********************************************************************
;

public class DobbelKjedetOrdnetListeM<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T> {
//M for midtpeker
	private DobbelNode<T> foerste;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;

	/******************************************************************
	 * Oppretter en tom liste.
	 ******************************************************************/
	// Konstrukt�r

	public DobbelKjedetOrdnetListeM(T minVerdi, T maksVerdi) {

		// F�rste node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		midten = foerste;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	@Override
	public void leggTil(T el) {

		int n = -1;
		// Setter inn ordnet f�r den noden p peker p�
		DobbelNode<T> p;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			antall++;

			if (el.compareTo(midten.getElement()) >= 0) {// Finn plass i siste
															// halvdel
				n = 1;
				p = midten.getNeste();
			} else { // Finn plass i f�rste halvdel
				p = foerste.getNeste();
				n = -1;
			}

			while (el.compareTo(p.getElement()) >= 0) {
				p = p.getNeste();
			} // while

			// Setter inn:
			// Innsett foran noden som p peker p�

			DobbelNode<T> nyNode = new DobbelNode<T>(el);
			p.getForrige().setNeste(nyNode);
			nyNode.setForrige(p.getForrige());
			nyNode.setNeste(p);
			p.setForrige(nyNode);

			if (el.compareTo(midten.getElement()) >= 0) {
				if (antall % 2 == 0) { // Partall, gjør ikke en dritt

				} else if (antall % 2 == 1) { // Oddetall, plasserer Høyre for midten
					midten = midten.getNeste();

				}
			} else { // Venstre for midten
				if (antall % 2 == 0) {
					midten = midten.getForrige();
				}
			}

			// Fyll ut med noen f� setninger

			// Oppdaterer ny midten
//			nyMidten(n);

		} // else lovlige

	}//

	// **********************************************************************************
	// Hjelpemetode til � finne ny midten.
	// Mindre effektiv fordi vi m� gjennomg� ca halve listen, men greit nok,
	// ellers kan en teste p� om antall er partall er oddetall ved oppdatering
	// av midtpeker
	// *********************************************************************************
//	private void nyMidten(int n) {
//		int midtNR = antall / 2;
////		DobbelNode<T> p = foerste.getNeste();
////		
//		if(n == 1) {
//			 // Flytt til høyre
//			midten = midten.getNeste();
//		} else if(n == 0) {
//			//flytt til venstre
//			midten = midten.getForrige();
//		}

//		for (int i = 1; i <= midtNR; i++) {
//			p = p.getNeste();
//		}
//		midten = p;
//	}//

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
	@Override
	public boolean fins(T el) {
		boolean funnet = false;
		DobbelNode<T> p = null;
		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
				p = midten; // Midten defineres � tilh�re siste del
			} else { // Let i f�rste halvdel
				p = foerste.getNeste();
			}

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while

			// Test p� funnet
			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}
		} // else
		return funnet;
	}//

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************
	// Omskrive til � bruke finn-metoden
	@Override
	public T fjern(T el) {
		T resultat = null;
		DobbelNode<T> p = null;
		boolean funnet = false;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			if (el.compareTo(midten.getElement()) >= 0) {
				p = midten;
			} else {
				p = foerste.getNeste();
			}

			p = finn(el);

			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}

			if (funnet) {

				antall--;

				// Oppadtere midten

				resultat = p.getElement();

				if (finn(el) == midten) {
					if (antall % 2 == 0) {
						midten = midten.getForrige();
					} else if (antall % 2 == 1) {
						midten = midten.getNeste();
					}

					p.getForrige().setNeste(p.getNeste());
					p.getNeste().setForrige(p.getForrige());

				} else {
					p.getForrige().setNeste(p.getNeste());
					p.getNeste().setForrige(p.getForrige());

					if (el.compareTo(midten.getElement()) >= 0) {
						if (antall % 2 == 0) { // Flytter mot venstre
							midten = midten.getForrige();

						}
					} else { // Flytter mot høyre hvis oddetall
						if (antall % 2 == 1) {
							midten = midten.getNeste();
						}
					}

				}

			} // funnet

		} // lovlige
		return resultat;
	}//

	/* Alternativ kan fjern-metoden bruke finn-metoden */

	private DobbelNode<T> finn(T el) {
		DobbelNode<T> node = null;
		DobbelNode<T> p = null;

		// Kun lovlige verdier
		if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			p = midten; // Midten defineres � tilh�re siste del
		} else { // Let i f�rste halvdel
			p = foerste.getNeste();
		}
		while (el.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} // while

		// Test p� funnet
		if (el.compareTo(p.getElement()) == 0) {
			node = p;
		}
		return node;
	}

	// ***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	public void skrivListe() {
		DobbelNode<T> p = foerste;

		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}

		System.out.println(
				"Foerste:" + foerste.getElement() + " Midten:" + midten.getElement() + " Siste:" + siste.getElement());
		System.out.println();

	}//

}// class
