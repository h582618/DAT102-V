package no.hvl.dat102.listeklient;

import java.util.Iterator;

import com.sun.tools.sjavac.server.SysInfo;

import no.hvl.dat102.adt.ListeADT;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;
import koe.sirkulaer.*;
import koe.kjedet.*;

public class KlientPerson {

	public static void main(String[] args) {

		Person anne = new Person("Anne", "Iversen", 1996);
		Person ole = new Person("Ole", "Vik", 1995);
		Person bendik = new Person("Bendik", "Ness", 1997);
		Person zyzz = new Person("Zyzz", "Sikcunt", 1993);

		OrdnetListeADT<Person> liste = new TabellOrdnetListe<Person>();
		OrdnetListeADT<Person> listeK = new KjedetOrdnetListe<Person>();

		SirkulaerKoe<Person> koeSirkulaer = new SirkulaerKoe<Person>();
		KjedetKoe<Person> koeKjedet = new KjedetKoe<Person>();

		liste.leggTil(anne);
		liste.leggTil(ole);
		liste.leggTil(bendik);
		liste.leggTil(zyzz);

		listeK.leggTil(anne);
		listeK.leggTil(ole);
		listeK.leggTil(bendik);
		listeK.leggTil(zyzz);

		koeSirkulaer.innKoe(anne);
		koeSirkulaer.innKoe(ole);
		koeSirkulaer.innKoe(bendik);
		koeSirkulaer.innKoe(zyzz);

		koeKjedet.innKoe(anne);
		koeKjedet.innKoe(ole);
		koeKjedet.innKoe(bendik);
		koeKjedet.innKoe(zyzz);

		Person person = null;
		System.out.println("Liste \n");
		while (!liste.erTom()) {
			person = liste.fjernFoerste();
			System.out.println(person);
		}
//      Liste kjedet
		System.out.println("---------------------");
		System.out.println("Kjedet Liste \n");
		while (!listeK.erTom()) {
			person = listeK.fjernFoerste();
			System.out.println(person);
		}
 		
		
		
		
//		Sirkulaer
		System.out.println("---------------------");
		System.out.println("Sirkulaer Koe \n");
		while (!koeSirkulaer.erTom()) {
			person = koeSirkulaer.utKoe();
			System.out.println(person);
		}

//		Kjedet
		System.out.println("---------------------");
		System.out.println("Kjedet koe \n");
		while (!koeKjedet.erTom()) {
			person = koeKjedet.utKoe();
			System.out.println(person);
		}

	}

}
