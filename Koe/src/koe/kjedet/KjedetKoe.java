package koe.kjedet;

import koe.ADT.*;
import koe.exception.EmptyCollectionException;

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;

	public KjedetKoe() {
		front = null;
		bak = null;
		antall = 0;
	}

	public KjedetKoe(LinearNode<T> element) {
		antall = 0;
		front = element;
		bak = element;
	}

	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (erTom()) {
			front = nyNode;
		} else {
			bak.setNeste(nyNode);
		}
		bak = nyNode;
		antall++;
	}

	@Override
	public T utKoe() {
		if (erTom()) {
			throw new EmptyCollectionException("Koe");
		}
		T resultat = front.getElement();
		front = front.getNeste();
		
		antall--;
		
		if (erTom()) {
			bak = null;
		}

		return resultat;
	}

	@Override
	public T foerste() {
		if(erTom()) {
			throw new EmptyCollectionException("Tom koe");
		}
		return front.getElement();
	}

	@Override
	public boolean erTom() {
		return(front==null);
	}

	@Override
	public int antall() {
		return antall;
	}

}// class
