import java.util.Arrays;
import java.util.Scanner;

public class mastermindMain {

	public static void main(String[] args) {

		// random code genereren
		Mastermindcode code = new Mastermindcode();
		code.CodeMaken();
		System.out.println("Mastermindcode gegenereerd");
		for (int i = 0; i < 4; i++) {
			System.out.print(code.code[i]);
		}

		// invoer code
		Scanner scan = new Scanner(System.in);
		int beurt = 0;
		while (true) {
			beurt++;
			System.out.println("Geef code van vier letters in (letters a-f, zonder spaties)");
			String input = scan.nextLine();
			if (input.equals("x")) {
				System.out.println("einde");
				break;
			} else if (input.length() < 4) {
				System.out.println("teveel letters");
			} else if (input.length() > 4) {
				System.out.println("te weinig letters");
			//} else if (!(input.matches("abcdef"))){
			//	System.out.println("Verkeerde tekens");				
			} else {
				InvoerCode invoerCode = new InvoerCode();
				invoerCode.InvoerCodeMaken(input);
				code.checkenCode(code.code, invoerCode.invoer);
				if (Arrays.equals(code.code, invoerCode.invoer)) {
					System.out.println("Gewonnen in " + beurt + " beurten");
					break;
				} 
			} 
		}
	}
}
/*
 * Programmeer het spel Mastermind tegen de computer, waarbij je gebruik maakt
 * van Object Oriented Programming. Hieronder staat het spelverloop uitgelegd.
 * 
 * Spelverloop De computer kiest random vier letters uit de verzameling {a, b,
 * c, d, e, f}. De gekozen rij wordt verder “code” genoemd. De volgorde is van
 * belang; een letter mag vaker voorkomen. De gebruiker moet de verborgen code
 * proberen te achterhalen. De gebruiker geeft een code van vier letters op. De
 * computer geeft een reactie op de ingegeven code, door te antwoorden met: ->
 * het aantal correcte letters die op de juiste plaats staan -> het aantal
 * correcte letters dat NIET op de juiste plaats staat De gebruiker geeft nu een
 * nieuwe code op, gebaseerd op deze nieuwe informatie.
 * 
 * Als alle vier letters op de juiste plaats staan, is de code gekraakt en het
 * spel ten einde. Een lopend spel kan worden beëindigd door het invoeren van
 * een q; alle andere invoer moet ofwel correct zijn (dus in de verzameling
 * voorkomen), ofwel resulteren in opnieuw bevragen van de gebruiker
 */
