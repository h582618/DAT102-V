
public class Oppgave3 {

	public static <T extends Comparable <T>> boolean binaerSoek(T[] data, int min, int maks, el element) {
		
		if(min > maks) { //Basis tilfellet, ingen elment
			return false;
		}
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		
		if(resultat == 0) {
			return true;
		}
		if(resultat < 0) {
			return binearSoak(data,min,midtpunkt -1, el);
		}
		else {
			return binaersoak(data,midtpunkt +1, maks , el);
		}
	}
}
