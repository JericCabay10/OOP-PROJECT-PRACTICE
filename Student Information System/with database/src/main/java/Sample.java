import java.time.*;

public class Sample {
	public static void main(String[] args) {
		int num = 10;
		
		int a = 0, b = 1;
		
		for(int c = 0; c <= num; c++) {
			System.out.print(a + " ");
			int temp = a + b;
			a = b;
			b = temp;
		}
	}
}
