package koe.test.sirkulaer;

import koe.ADT.KoeADT;
import koe.sirkulaer.SirkulaerKoe;
import koe.test.ADT.KoeADTTest;

public class KoeSirkulaerTest extends KoeADTTest {

	@Override
		protected KoeADT<Integer> reset() {
			return new SirkulaerKoe<Integer>();
		}
}
