package Datakontaktfirma;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	
	public Medlem() {
		hobbyer = new KjedetMengde<Hobby>();
		this.navn = "";
		statusIndeks = -1;
	}
	
	
	public Medlem(String navn) {
		hobbyer = new KjedetMengde<Hobby>();
		this.navn = navn;
		statusIndeks = -1;
	}
	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
		this.navn = navn;
		statusIndeks = -1;
	}
	public Medlem(String navn, int indeks, MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
		this.navn = navn;
		statusIndeks = indeks;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	public void leggTilHobby(Hobby hobby) {
		hobbyer.leggTil(hobby);
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyMengde) {
		hobbyer = hobbyMengde;
	}
	public String getHobbyer() {
		return hobbyer.toString();
	}

	public boolean passerTil(Medlem medlem2) {

		boolean passer = false;

		if (hobbyer.equals(medlem2.hobbyer)) {
			passer = true;
		}
		return passer;

	}
	public void skrivUt() {
		System.out.println( navn + " " + hobbyer.toString());
	}
}
