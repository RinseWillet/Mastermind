import java.util.Scanner;

/*versie werkend, maar nog niet 'elegant'
* idee methode voor het checken Mastermindcode.java van Aditya-Kharosekar - // https://github.com/Aditya-Kharosekar/Mastermind/blob/master/Game.java
* to do:
* 
* nog eens spelen
* verkeerde letters niet accepteren
* geluidseffecten/overwinningsliedje
* moeilijkheidsnivea (easy : unlimited (1000) beurten, hard: max 10 beurten)  
*/

public class mastermindMain {
		
	public static void main(String[] args) {		
		System.out.println("Welkom bij Mastermind");
				Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Start spel = s; Stoppen = x");
			String menu = scan.nextLine();
			if (menu.equals("x")) {
				System.out.println("einde");
				break;
			} else if (menu.contentEquals("s")) {				
				mastermindSpel spelenmaar = new mastermindSpel();
				spelenmaar.start();				
			} else {
				continue;
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
