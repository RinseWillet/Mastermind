import java.util.Random;
import java.util.Arrays;

//Creeër random set van 4 getallen en zet om naar 4 characters;
//versie 1
/*
* Random random = new Random (); int[] code = new int[4]; for (int i=0; i<4;
* i++) { int x = random.nextInt(6); int ascii = x + 97; code[i] = ascii; }
*/

//versie 2

public class Mastermindcode {
	private char[] keuzeletters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f' };
	public char[] code = new char[4];

	public Mastermindcode() {
		this.keuzeletters = keuzeletters;
		this.code = code;
	}

	public void CodeMaken() {
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int x = random.nextInt(6);
			code[i] = keuzeletters[x];
		}
	}

	public void checkenCode(char[] code, char[] invoer) {

		int aantallettersgoed = 0;								//aantal letters juist in code, maar niet op goede plek
		int aantalpositiesgoed = 0;								//aantal letters juist in code en op goede plek
		
		for (int i = 0; i < code.length; i++) {					//loop die checkt of de juiste letters op goede plek staan
			if (code[i] == invoer[i]) {		
				aantalpositiesgoed++;							// aantal juiste letters en goede plek erbij
				aantallettersgoed--;							// aantal juiste letters en niet goede plek eraf
			}
		}
		
	    for (char check : code) {								//loop die checkt of juiste letters in the code zitten
	            if (Arrays.toString(invoer).indexOf(check) != -1) {
	                aantallettersgoed++;
	            }		
			}
			
	
	// het aantal correcte letters op de juiste plaats staan
	System.out.println("het aantal correcte letters op de juiste plaats: "+aantalpositiesgoed);

	// het aantal correcte letters die niet op de juiste plaats staan
	System.out.println("het aantal correcte letters op de foute plaats: "+aantallettersgoed);

	}
}

