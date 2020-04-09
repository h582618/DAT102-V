
public class Oppgave1 {

	public static void main(String [] args ) {
//		System.out.println(sum(10));
		
		skrivUt(10);
		
	}
	//a
	public static int sum(int n) {
		int v = 0;
		// basissteget
		if(n <= 1) {
			return n;
		} else {
			v = n + sum(n-1);
		}
		return v;
	}
	//b
	public static int tallfølge(int n) {
		
		int a0 = 2;
		int a1 = 5;
		int an = 0;
		
		//Basisteget
		
		if(n > 1) {
			an = ((5*tallfølge((n-1)) - 6*tallfølge(n-2)) + 2);
			
		} else if (n == 1){
			return a1;
		} else if (n == 0){
			return a0;
		} else {
			return 0;
		}
		return an;
	}
	
	public static int skrivUt(int n) {
		
		if(n >= 1) {
		System.out.println(tallfølge(n));
		return(skrivUt(n-1));
		} else {
			return 0;
		}
	}
}
