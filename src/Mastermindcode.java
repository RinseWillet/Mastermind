import java.util.Random;

public class Mastermindcode {
	
	int[] secretcodeInInts = new int[4];							//de mastermind code wordt een array van integers, en de InvoerCode (zie InvoerCode.java) methode cast de input van de scanner in main in een integer-array.  
	int[] result = new int[2];										// array om resultaten code testen door te geven naar main
																	// idee methode van Aditya-Kharosekar - // https://github.com/Aditya-Kharosekar/Mastermind/blob/master/Game.java
	
	public Mastermindcode() {

	}

	public void CodeMaken() {                                  		//deze methode maakt een randomized (0-5) array van 4 integers											
		Random random = new Random();								//aangezien we de invoer omzetten in een array van integers kunnen we de code ook in integers laten genereren en vergelijken.
		for (int i = 0; i < 4; i++) {
			secretcodeInInts[i] = random.nextInt(6);
		}
		//System.out.println(Arrays.toString(secretcodeInInts));	// test om int array mastermindcode weer te geven
	}

	public int[] checkenCode(int[] mastermindcode, int[] invoer) {
						
		int[] randomcode = new int[4];
		int[] invoercode = new int[4];
		for (int i = 0; i < 4; i++) {
			randomcode[i] = mastermindcode[i];						//hier kopieert de methode de random mastermindcode in een nieuwe array, die bewerkt kan worden in de rest van de methode, zonder dat originele code verloren gaat
			invoercode[i] = invoer[i];								//idem voor invoercode - deze verandert uiteraard wel per invoer iteratie ;-)
		}	

		int GoedeLettersPositie = 0;								// hier wordt gecheckt of de gekozen letters positioneel overeenkomen met de mastermindcode
		for (int i = 0; i < randomcode.length; i++) {				
			if (randomcode[i] == invoercode[i]) {
				GoedeLettersPositie++;					
				randomcode[i] = -1;									//de copie mastermindcode wordt aangepast om in de rest vd method niet nogmaals geteld te worden (de gekozen letters zullen nooit overeenkomen met -1 en de mastermindcode ook niet
				invoercode[i] = -1;
			}
		}

		int GoedeLetters = 0;										//deze methode checkt voor de goede 'letters' (als integers) en foute posities. Goede letters en goede positie zijn in de kopiëen vd invoer en mastermindcode array al aangepast naar -1
		for (int i = 0; i < randomcode.length; i++) {				//de mastermindcode wordt per letter gecheckt aan de invoercode
			if (randomcode[i] == -1) {								//de positie is al bewerkt, dus door, niet meer checken, naar de volgende iteratie for (int i= etc. )loop
				continue;
			}
			for (int j = 0; j < randomcode.length; j++) {			//per mastermindcode integer wordt iedere invoercode gecheckt
				if (invoercode[j] == -1) {							//de invoerpositie is al bewerkt, dus door, niet meer checken, naar de volgende iteratie for (int j= etc. )loop
					continue;
				}
				if (randomcode[i] == invoercode[j]) {				//als de mastermindcode posite eerste for loop overeenkomt met 1 van de invoercode posities tweede for loop, dan eentje extra bijtellen bij goede letter
					GoedeLetters++;									// en foute positie, en vervolgens de kopieën van mastermindcode en invoercode aanpassen (algehad) naar -1;
					randomcode[i] = -1;
					invoercode[j] = -1;
				}
			}
		}
		result[0]=GoedeLettersPositie;
		result[1]=GoedeLetters;
		return result;												// return array met resultaten.				
	}
}

/*
*
* Creeër random set van 4 getallen en zet om naar 4 characters;
* versie 1
* private char[] keuzeletters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f' };
* Random random = new Random (); int[] code = new int[4]; for (int i=0; i<4;
* i++) { int x = random.nextInt(6); int ascii = x + 97; code[i] = ascii; }
* 
* uiteindelijk versie 2 aangepast om een random int array te maken, zie definitieve code; 
*
* 
* Maurice idee - deze werkt jammergenoeg ook niet (aantallen goedeletters onjuiste plek bij code ebdb invoer eeeb of beeb)
* 
* public void checkenCode(InvoerCode invoer, Mastermindcode code) { int x = 0;
* // aantal positie + letter goed int y = 0; // aantal positie fout + letter
* goed
* 
* if (code.a == invoer.a1 && code.b == invoer.b1 && code.c == invoer.c1 &&
* code.d == invoer.d1) { System.out.println("correct, je hebt gewonnen!"); x =
* 4;
* 
* } else { if (code.a == invoer.a1) { x++; } else if ((code.a == invoer.b1) ||
* (code.a == invoer.c1) || (code.a == invoer.d1)) { y++; } if (code.b ==
* invoer.b1) { x++; } else if ((code.b == invoer.a1) || (code.b == invoer.c1)
* || (code.b == invoer.d1)) { y++; } if (code.c == invoer.c1) { x++; } else if
* ((c == invoer.a1) || (code.c == invoer.b1) || (code.c == invoer.d1)) { y++; }
* if (code.d == invoer.d1) { x++; } else if ((code.d == invoer.a1) || (code.d
* == invoer.b1) || (code.d == invoer.c1)) { y++; } }
* System.out.println("Aantal juiste letters op de juiste positie : " + x);
* System.out.println("Aantal juiste letters op de verkeerde positie: " + y); }
 * }
 * 
 * 
 * // eerste idee, dit denkpad liep vast (best case scenario - aantallen goedeletters onjuiste plek bij code ebdb invoer eeeb of beeb)
 * 
 * 
 * int aantallettersgoed = 0; // aantal letters juist in code, maar niet op
 * goede plek int aantalpositiesgoed = 0; // aantal letters juist in code en op
 * goede plek char[] codechecken = new char[4]; char[] invoerchecken = new
 * char[4]; codechecken = code; invoerchecken = invoer;
 * System.out.println("verandering code positie goed " +
 * Arrays.toString(codechecken));
 * System.out.println("verandering invoer positie goed" +
 * Arrays.toString(invoerchecken)); for (int i = 0; i < codechecken.length; i++)
 * { // loop die checkt of de juiste letters op goede plek staan if
 * (codechecken[i] == invoerchecken[i]) { aantalpositiesgoed++; // aantal juiste
 * letters en goede plek erbij codechecken[i] = '*'; // aantal juiste letters en
 * niet goede plek eraf invoerchecken[i] = 'z';
 * 
 * } else { for (int j=0; j<codechecken.length; j++) { if (invoerchecken[0] ==
 * codechecken[j]) { aantallettersgoed++; invoerchecken[0] = 'Y'; codechecken[i]
 * = 'X'; } }
 * 
 * } } System.out.println("verandering code positie goed " +
 * Arrays.toString(codechecken));
 * System.out.println("verandering invoer positie goed" +
 * Arrays.toString(invoerchecken)); invoerchecken = invoer; codechecken = code;
 * System.out.println("verandering code positie goed " +
 * Arrays.toString(codechecken));
 * System.out.println("verandering invoer positie goed" +
 * Arrays.toString(invoerchecken));/* for (int i=0; i<codechecken.length; i++) {
 * if (invoerchecken[1] == codechecken[i]) { aantallettersgoed++;
 * invoerchecken[1] = 'z'; codechecken[i] = '*'; } }
 * 
 * for (int i=0; i<codechecken.length; i++) { if (invoerchecken[2] ==
 * codechecken[i]) { aantallettersgoed++; invoerchecken[2] = 'z'; codechecken[i]
 * = '*'; } }
 * 
 * for (int i=0; i<codechecken.length; i++) { if (invoerchecken[3] ==
 * codechecken[i]) { aantallettersgoed++; invoerchecken[3] = 'z'; codechecken[i]
 * = '*'; } }
 */

// for (char check : invoer) { //loop die de mastermindcode doorloopt
// if (Arrays.toString(code).indexOf(check) != -1) { //als de index van de
// stringwaarde van de ingegevencode array niet -1 is (staat een letter eerder
// al) dan aantallettersgoed 1 erbij. (idee gepikt van Joris);
// aantallettersgoed++;
// het aantal correcte letters op de juiste plaats staan
// het aantal correcte letters die niet op de juiste plaats staan
