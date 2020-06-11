import java.util.Scanner;
import java.util.Arrays;

public class mastermindSpel {

	void start() {

		// random code genereren
		Mastermindcode code = new Mastermindcode();
		code.CodeMaken();
		System.out.println("Mastermindcode gegenereerd");

		// invoer code

		int beurt = 0;
		
		Scanner scan = new Scanner(System.in);
		
						
		while (true) {
			beurt++;
			System.out.println("Geef code van vier letters in (letters a-f, zonder spaties)");
			String input = scan.nextLine();
			boolean contains = true;
			contains = onlyLettersAF(input);												//checken verkeerde letters
			if (input.equals("x")) {														//einde
				System.out.println("einde");
				break;
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
					break;
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
}
			