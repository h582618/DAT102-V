package no.hvl.dat102;

import java.io.*;
import java.util.Scanner;

import no.hvl.dat102.adt.StabelADT;

public class Balansering {

	StabelADT<Parentesinfo> tStabell = new TabellStabel<>();

	private boolean passer(char aapent, char lukket) {

		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;

		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		int lengde = innDataStreng.length();

		for (int i = 0; i < lengde; i++) {

			char b = innDataStreng.charAt(i);

			if (b == '(' || b == '[' || b == '{') {
				tStabell.push(new Parentesinfo(linjenr, i, b));
			}
// FEIL 2
			if (b == ')' || b == ']' || b == '}') {
				if (tStabell.erTom()) {
					System.out.println(
							"Lukkesymbol " + b + " tegn nr " + (i + 1) + " mangler tilsvarende åpnesymbol " + linjenr);
				} else {

					Parentesinfo vp1 = tStabell.pop();
					char vp = vp1.getVenstreparentes();
//  FEIL 1
					if (!passer(vp, b)) {
						System.out.println("Lukkesymbol " + b + " på linje nr " + linjenr + " ,tegn nr " + (i + 1)
								+ " har feil åpnesymbol");
						tStabell.push(vp1);
					}
				}
			}

		}
		// Hvis ikke alt er poppet, er det noe som ikke er lukket

	}//

	public void lesFraFil(String filnavn) {
		Scanner sc = new Scanner(System.in);
		FileReader tekstFilLeser = null;

		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 1;
		try {

			linje = tekstLeser.readLine();
			while (linje != null) {
				foretaBalansering(linje, linjenr);
				linje = tekstLeser.readLine();
				linjenr++;

			}
			if (!tStabell.erTom()) {
				while (!tStabell.erTom()) {
					// FEIL 3
					Parentesinfo v1 = tStabell.pop();
					int v1Tegn = v1.getPosisjon();
					System.out.println("Åpnesymbol " + v1.getVenstreparentes() + " på linje nr " + linjenr
							+ ", tegn nr " + v1Tegn + " mangler lukkesymboll");
				}
			}
			sc.close();
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}

	public void meny() {
		System.out.println("Tast inn filnavn");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		lesFraFil(input);
		sc.close();

	}

}// class
