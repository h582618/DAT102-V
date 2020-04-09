package koe.test.kjedet;

import koe.ADT.*;
import koe.kjedet.KjedetKoe;
import koe.test.ADT.KoeADTTest;

public class KoeKjedetTest extends KoeADTTest{

	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}
}
