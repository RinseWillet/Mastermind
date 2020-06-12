import java.util.Scanner;

public class mastermindSpel {

	void start() {
		Scanner scan = new Scanner(System.in);
		soundEffects sound = new soundEffects();
		System.out.println("Welkom bij Mastermind");
		boolean spelen = SpelenVraag();
		
					
		// random code genereren
		Mastermindcode code = new Mastermindcode();
		code.CodeMaken();
		System.out.println("Mastermindcode gegenereerd");

		// invoer code

		int beurt = 0;
										
		while (spelen == true) {
			beurt++;
			System.out.println("Geef code van vier letters in (letters a-f, zonder spaties, q is einde)");
			String input = scan.nextLine();
			boolean contains = true;
			contains = onlyLettersAF(input);												//checken verkeerde letters
			if (input.equals("x")) {														//einde
				System.out.println("dit potje is voorbij - opnieuw spelen?");
				sound.bad();
				spelen=SpelenVraag();
				if (spelen==true) {
					code.CodeMaken();					
					System.out.println("Mastermindcode gegenereerd");
				}				
			} else if (input.length() < 4) {												// verkeerd aantal letters ingegeven
				System.out.println("te weinig letters");
			} else if (input.length() > 4) {
				System.out.println("te veel letters");
			} else if (contains == false) {													// checken verkeerde letters
				System.out.println("Verkeerde tekens");
			} else {
				InvoerCode invoerCode = new InvoerCode();									//invoer okay - > invoer omzetten naar integers en checken op de mastermindcode				
				invoerCode.InvoerCodeMaken(input);
				code.checkenCode(invoerCode.invoercodeInInts, code.secretcodeInInts);
				System.out.println("Het aantal correcte letters op juiste positie : " + code.result[0]);
				System.out.println("Het aantal correcte letters op foute positie : " + code.result[1]);
				if (code.result[0] == 4) {
					System.out.println(">>>Je hebt gewonnen<<<");
					System.out.println(">>>en dat in maar " + beurt + " beurten<<<");
					System.out.println(">>>Tijd voor een biertje<<<");
					System.out.println("of nog eens spelen?");
					sound.good();
					spelen=SpelenVraag();
					if (spelen==true) {
						code.CodeMaken();					
						System.out.println("Mastermindcode gegenereerd");
					}
				}
			}
		}		
		scan.close();
	}

	boolean onlyLettersAF (String input) {													//method om the checken of enkel a-f ingevoerd zijn.
			
			char[] check = new char[4];
			check = input.toCharArray();
			
			boolean contains = true;
			for (char c : check) {
			    if (!(c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f')) {
			        contains = false;
			        }
			}
			return contains;
			}
	
	boolean SpelenVraag () {
		soundEffects sound = new soundEffects();
		boolean spelen = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Start spel = s; Stoppen = q");
		String start = scan.nextLine();
		while(true) {
			if(start.equals("q")) {
			System.out.println("einde");
			spelen = false;
			return spelen;
			}
		if(start.equals("s") ) {
			spelen = true;
			return spelen;
		}
		scan.close();
		}
	}
}

			