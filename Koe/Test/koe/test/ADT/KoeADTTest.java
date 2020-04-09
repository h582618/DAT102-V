package koe.test.ADT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import koe.ADT.*;
import koe.exception.EmptyCollectionException;

public abstract class KoeADTTest {

	private KoeADT<Integer> koe;

	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny koe for hver test.
	 * 
	 * 
	 */
	@Before
	public final void setup() {
		koe = reset();
	}

	/**
	 * Test på at en ny koe er tom
	 */

	@Test
	public final void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test inn og utkoe
	 * Setter først inn, og fjerner etterpå.
	 */
	@Test
	public final void innOgUtKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);

		try {
		assertEquals(e0, koe.utKoe());
		assertEquals(e1, koe.utKoe());
		assertEquals(e2, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e4, koe.utKoe());
		} catch(EmptyCollectionException e) {
			fail("Uventet feil" + e.getMessage());
		}
		
	}
	/**
	 * Tester første i kø
	 */
	@Test 
	public final void foersteIkoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		
		try {
			assertEquals(e0, koe.utKoe());
			
		} catch(EmptyCollectionException e) {
			fail("Uventet feil" + e.getMessage());
		}
	}
	@Test
	public final void antallKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);

			assertEquals(3,koe.antall());
		
	}
}
