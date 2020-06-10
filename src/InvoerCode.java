
public class InvoerCode {
	
public char[]invoer;

	public InvoerCode() {
		this.invoer= invoer;
	}

	public void InvoerCodeMaken(String input) {
		invoer = input.toCharArray();
		System.out.println("je voerde in: ");
		System.out.println(">> " + invoer[0] + " - " + invoer[1] + " - " + invoer[2] + " - " + invoer[3] + " <<");
	}

}
