package no.hvl.dat102.mengde.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public abstract class testMengde {

	private MengdeADT<String> begge;
	private MengdeADT<String> m1;
	private MengdeADT<String> m2;
	private MengdeADT<String> fasit;

	protected abstract MengdeADT<String> reset();

	public void setup() {
		begge = reset();
		m1 = reset();
		m2 = reset();
		fasit = reset();
	}

	@Test
	public void fjernTest() {
		setup();

//		m1.leggTil("Brus");
//		m1.leggTil("Hus");
//		
//		assertEquals("Hus",m1.fjern("Hus"));
//		
//		m2.leggTil("Brus");
//		
//		assertTrue(m1.equals(m2));
//		m1.leggTil("Test");
		m1.leggTil("Test1");
		m1.leggTil("Test2");
		
		m1.leggTil("Brus");
		m1.leggTil("Test4");
		m1.leggTil("Test3");

		fasit.leggTil("Test3");
		fasit.leggTil("Brus");

		m1.fjern("Test4");
		m1.fjern("Test1");
		m1.fjern("Test2");

		Iterator it1 = m1.oppramser();

		System.out.println("");
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		System.out.println("");
		Iterator it2 = fasit.oppramser();

		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		assertTrue(m1.equals(fasit));

	}

	@Test
	public void UnionTest() {

		setup();
		m1.leggTil("Hus");
		m1.leggTil("Brus");
		m1.leggTil("Bergen");
		m1.leggTil("Data");
		m1.leggTil("Gris");

		m2.leggTil("Gris");
		m2.leggTil("Saft");
		m2.leggTil("Hus");
		m2.leggTil("Kjeks");
		m2.leggTil("Kake");

		fasit.leggTil("Gris");
		fasit.leggTil("Brus");
		fasit.leggTil("Bergen");
		fasit.leggTil("Data");
		fasit.leggTil("Kjeks");
		fasit.leggTil("Saft");
		fasit.leggTil("Hus");
		fasit.leggTil("Kake");

		begge = m1.union(m2);

		assertTrue(fasit.equals(begge));

	}

	@Test
	public void snittTest() {
		setup();
		m1.leggTil("Hus");
		m1.leggTil("Brus");
		m1.leggTil("Bergen");
		m1.leggTil("Data");
		m1.leggTil("Gris");

		m2.leggTil("Gris");
		m2.leggTil("Saft");
		m2.leggTil("Hus");
		m2.leggTil("Kjeks");
		m2.leggTil("Kake");

		fasit.leggTil("Gris");
		fasit.leggTil("Hus");

		begge = m1.snitt(m2);

		assertTrue(fasit.equals(begge));
	}

	@Test
	public void differensTest() {
		setup();
		m1.leggTil("Hus");
		m1.leggTil("Brus");
		m1.leggTil("Bergen");
		m1.leggTil("Data");
		m1.leggTil("Gris");

		m2.leggTil("Gris");
		m2.leggTil("Saft");
		m2.leggTil("Hus");
		m2.leggTil("Kjeks");
		m2.leggTil("Kake");

		fasit.leggTil("Bergen");
		fasit.leggTil("Data");
		fasit.leggTil("Brus");

		begge = m1.differens(m2);

		assertTrue(fasit.equals(begge));
	}
}
