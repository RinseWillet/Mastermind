import java.util.Scanner;

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
			if (input.equals("x")) {
				System.out.println("einde");
				break;
			} else if (input.length() < 4) {
				System.out.println("teveel letters");
			} else if (input.length() > 4) {
				System.out.println("te weinig letters");
				// } else if (!(input.matches("abcdef"))){
				// System.out.println("Verkeerde tekens");
			} else {
				InvoerCode invoerCode = new InvoerCode();
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
}
