
public class Sample {

	public static void main(String[] args) {
		String str = "LEA234560";
		
		int digit = 0;
		int chr = 0;
		
		for(int a = 0; a < str.length(); a++) {
			char ch = str.charAt(a);
			
			if(ch >= '0' && ch <= '9') {
				digit++;
			}
			
			if(ch >= 'A' && ch <= 'Z') {
				chr++;
			}
		}
		
		System.out.println("digit: " + digit);
		System.out.println("chr: " + chr);
		
		if(digit == 6 && chr == 2) {
			System.out.println("Debug");
		}else {
			System.out.println("The length of id must be 6 digit.");
		}
	}

}
