package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		resultat = foerste.getElement();

		foerste = foerste.getNeste();
		antall--;

		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		LinearNode<T> denne = foerste;

		T resultat = null;

		if (antall == 1) {
			resultat = foerste.getElement();
			siste = foerste = null;
			antall--;
			return resultat;
		}

		while (denne.getNeste() != siste) {
			denne = denne.getNeste();
		}

		resultat = siste.getElement();
		siste = denne;
		denne.setNeste(null);
		antall--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
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
	public void leggTil(T element) {

		LinearNode<T> nynode = new LinearNode<T>(element);

		if (erTom()) {
			foerste = siste = nynode;
			antall++;
			return;
		}
		if (antall() == 1) {
			if (element.compareTo(foerste.getElement()) >= 0) {
				foerste.setNeste(nynode);
				siste = nynode;
			} else {
				nynode.setNeste(foerste);
				foerste = nynode;
			}
			antall++;
			return;
		}

		LinearNode<T> denne = foerste;
		LinearNode<T> forrige = foerste;

		while (denne != null) {
			if (element.compareTo(denne.getElement()) <= 0) {
//				Hvis første
				if (denne == foerste) {
					nynode.setNeste(foerste);
					foerste = nynode;
					antall++;
					return;
				} else {
					forrige.setNeste(nynode);
					nynode.setNeste(denne);
					antall++;
					return;
				}
			}
			forrige = denne;
			denne = denne.getNeste();

		}

//		Hvis størst setter inn på slutten.
		forrige.setNeste(nynode);
		siste = nynode;
		antall++;
	}

	@Override
	public T fjern(T element) {

		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
