package no.hvl.dat102.tabell;

import java.util.Arrays;

import no.hvl.dat102.EmptyCollectionException;

import no.hvl.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int antall;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		antall = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		resultat = liste[antall - 1];
		liste[antall - 1] = null;
		antall--;

		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		resultat = liste[0];
		liste[0] = null;
		for (int i = 0; i < antall - 1; i++) {
			liste[i] = liste[i + 1];
		}

		liste[antall - 1] = null;
		antall--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		resultat = liste[antall - 1];

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		liste[antall] = element;
		antall++;
		Arrays.sort(liste, 0, antall);

	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {

		int indeks = finn(element);

		T resultat = null;

		if (indeks > -1) {

			resultat = liste[indeks];

			liste[indeks] = null;

			for (int i = indeks; i < antall - 1; i++) {
				liste[i] = liste[i + 1];
			}

			liste[antall - 1] = null;
			antall--;

		}
		return resultat;

	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;

		boolean funnet = false;

		while (!funnet && i < antall) {
			if (liste[i].equals(el)) {
				funnet = true;
				resultat = i;
			}
			i++;
		}

		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < antall; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
