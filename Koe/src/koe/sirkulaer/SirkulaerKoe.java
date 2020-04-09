package koe.sirkulaer;
import koe.ADT.*;
import koe.exception.*;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		foran = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}
     //...

	@Override
	public void innKoe(T element) {
		if(antall() == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak+1) % koe.length;
		antall++;
	}

	@Override
	public T utKoe() {
		if(erTom()) {
			throw new EmptyCollectionException("Er tom");
		}	
		 T resultat = koe[foran];
		 
		 koe[foran] = null;
		 foran++;
		 antall--;
		
		 return resultat;
	}

	@Override
	public T foerste() {
		if(erTom()) {
			throw new EmptyCollectionException("Er tom");
		}	
		return koe[foran];
	}

	@Override
	public boolean erTom() {
		return(koe[foran]==null);
	}

	@Override
	public int antall() {
		return antall;
	}
	public void utvid() {

		T[] koeU = (T[]) (new Object[koe.length * 2]);
		for (int i = 0; i < koe.length; i++) {
			koeU[i] = koe[i];
		}
		koe = koeU;

	}
}

