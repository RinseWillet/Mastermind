public class InvoerCode {
	
	int[] invoercodeInInts = new int[4];
	
	public InvoerCode() {
		
	}

	public int[] InvoerCodeMaken(String input) {
		
		char a1 = input.charAt(0);
        char b1 = input.charAt(1);
        char c1 = input.charAt(2);
        char d1 = input.charAt(3);
		System.out.println("je voerde in: ");
		System.out.println(">> " + a1 + " - " + b1 + " - " + c1 + " - " + d1 + " <<");
		
		
	    char[] chars = input.toCharArray();

	    for (int i=0; i < 4; i++) {
	       switch (chars[i]) {
	                case 'a': {
	                	invoercodeInInts[i] = 0; break;
	                }
	                case 'b': {
	                	invoercodeInInts[i] = 1; break;
	                }
	                case 'c': {
	                	invoercodeInInts[i] = 2; break;
	                }
	                case 'd': {
	                	invoercodeInInts[i] = 3; break;
	                }
	                case 'e': {
	                	invoercodeInInts[i] = 4; break;
	                }
	                case 'f': {
	                	invoercodeInInts[i] = 5; break;
	                }
	            }
	        }
	        return invoercodeInInts;
	    }
	
}

