package koe.tabell;

import koe.ADT.*;
import koe.exception.EmptyCollectionException;

//********************************************************************
//
//  Representerer en samling k�, implementert vha en tabell.
// foran er i posisjon 0.
//********************************************************************

public class TabellKoe<T> implements KoeADT<T> {
	private final static int STDK = 100;
	private int bak;
	private T[] koe;

	/******************************************************************
	 * Oppretter en tom k� med standard st�rrelse.
	 ******************************************************************/
	public TabellKoe() {
		this(STDK);
	}

	/******************************************************************
	 * Oppretter en tom k� med kapasitet gitt ved parameter
	 ******************************************************************/
	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = (T[]) (new Object[startKapasitet]);
	}

	@Override
	public void innKoe(T element) {
		if (koe.length == antall()) {
			utvid();
		}

		koe[bak] = element;
		bak++;

	}

	@Override
	public T utKoe() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("Er tom");
		}
		T resultat = koe[0];
		bak--;
		for (int i = 0; i < bak; i++) {
			koe[i] = koe[i + 1];
		}

//		Hvis Bak er lik lengden på køen vil du ha et duplikat av det bakerste elementet
//		Derfor har jeg laget en if setning
		if (bak == koe.length) {
			koe[bak + 1] = null;
		}

		return resultat;

	}

	@Override
	public T foerste() {
		if (erTom()) {
			throw new EmptyCollectionException("Er tom");
		}
		return koe[0];
	}

	@Override
	public boolean erTom() {
		return(koe[0] == null);
	}

	@Override
	public int antall() {
		return bak;
	}

	public void utvid() {

		T[] koeU = (T[]) (new Object[koe.length * 2]);
		for (int i = 0; i < koe.length; i++) {
			koeU[i] = koe[i];
		}
		koe = koeU;

	}
}
