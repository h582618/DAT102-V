package no.hvl.dat102.mengde.test.kjedet;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.test.testMengde;

public class MengdeKjedetTest extends testMengde{
	
	@Override
	protected MengdeADT<String> reset() {
		return new KjedetMengde<String>();
	}
}
