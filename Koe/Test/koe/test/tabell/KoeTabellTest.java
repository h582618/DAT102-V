package koe.test.tabell;

import koe.ADT.KoeADT;
import koe.tabell.TabellKoe;
import koe.test.ADT.KoeADTTest;

public class KoeTabellTest extends KoeADTTest {

	@Override
		protected KoeADT<Integer> reset() {
			return new TabellKoe<Integer>();
		}
}
