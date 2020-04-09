package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}//

	@Override
	public T fjern(T element) {

		LinearNode<T> forgjenger = start, aktuell = start;

		if (!inneholder(element)) {
			return null;
		}

		while (aktuell != null) {
			if (aktuell.getElement().equals(element)) {

				if (aktuell.equals(forgjenger)) {
					start = start.getNeste();
				} else {
					forgjenger.setNeste(aktuell.getNeste());
				}

				antall--;
				return element;

			} else {
				forgjenger = aktuell;
				aktuell = aktuell.getNeste();
			}
		}
		return null;
	}
	/*
	 * boolean funnet = false; LinearNode<T> forgjenger = null, aktuell = start; T
	 * resultat = null;
	 * 
	 * // Søker til funnet eller til kjeden er tom while (aktuell != null &&
	 * !funnet) { if (aktuell.getElement().equals(element)) { funnet = true; } else
	 * { aktuell = aktuell.getNeste(); forgjenger = aktuell; } } // Hvis funnet if
	 * (funnet) { antall--; resultat = aktuell.getElement(); if (forgjenger == null
	 * && start.getNeste() == null) { // Første og eneste element start = null;
	 * aktuell = null; System.out.println("Første og eneste"); } else if (forgjenger
	 * == null) { // Første element start = start.getNeste();
	 * System.out.println("Første"); } else { // Ellers
	 * forgjenger.setNeste(aktuell.getNeste()); aktuell = aktuell.getNeste();
	 * System.out.println("Ellers");
	 * 
	 * } //Noe gale med ellers, får ikke fjern til å fungere. Må tegne }
	 * 
	 * return resultat; }//
	 */

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(Object m2) {
		boolean likeMengder = false;
		T element;
		if (m2 instanceof KjedetMengde) {
			Iterator<T> m2It = ((KjedetMengde<T>) m2).oppramser();
			if (this.antall() == ((KjedetMengde<T>) m2).antall()) {
				likeMengder = true;
				while (m2It.hasNext()) {
					element = m2It.next();
					if (!this.inneholder(element)) {
						return false;
					}
				}
			}

		}

		return likeMengder;

	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element = null;
		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}

		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (!inneholder(element)) {
				begge.leggTil(element);
			}
		}

		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (inneholder(element)) {
				snittM.leggTil(element);
			}
		}

		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		Iterator<T> teller = m2.oppramser();
		// Legger først til hele m1 i differensM
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			element = aktuell.getElement();
			differensM.leggTil(element);
			aktuell = aktuell.getNeste();
		}

		// Fjerner deretter elementer som er i m2 fra differensM
		while (teller.hasNext()) {
			element = teller.next();
			if (inneholder(element)) {
				differensM.fjern(element);
			}
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		// Fyll ut
		return erUnderMengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	public String toString() {// For klassen KjedetMengde
		String resultat = "";
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			resultat += aktuell.getElement().toString() + "\t";
			aktuell = aktuell.getNeste();
		}
		return resultat;
	}

}// class
