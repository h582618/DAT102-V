package no.hvl.dat102.mengde.test.tabell;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;
import no.hvl.dat102.mengde.test.testMengde;

public class MengdeTabellTest extends testMengde{
	
	@Override
	protected MengdeADT<String> reset() {
		return new TabellMengde<String>();
	}
}
