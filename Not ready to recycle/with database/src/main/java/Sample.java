import java.util.*;

public class Sample {
	static Scanner scan = new Scanner(System.in);
	
	public static void mergedTwoArray() {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {4, 5, 6};
		
		int[] merged = new int[arr1.length + arr2.length];
		
		for(int a = 0; a < arr1.length; a++) {
			merged[a] = arr1[a];
		}
		
		for(int b = 0; b < arr2.length; b++) {
			merged[arr1.length + b] = arr2[b];
		}
		
		for(int merge : merged) {
			System.out.print(merge + " ");
		}
	}
	
	public static void searchLinear() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int num = 0;
	
		do {
			System.out.print("Search: ");
			num = scan.nextInt();
			
			boolean isFound = false;
			for(int a = 0; a < arr.length; a++) {
				if(num == arr[a]) {
					isFound = true;
					System.out.println("The element: " + num + " found in index");
					break;
				}				

			}
			if(!isFound) {
				System.out.println("Not in index");
			}
		} while(num != 0);
	}
	
	public static void primeNumber() {
		while(true) {
			System.out.print("Enter a number: ");
			int num = scan.nextInt();
			
			boolean isPrime = true;
			
			for(int a = 2; a < num; a++) {
				if(num % a == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				System.out.println(num + " Prime number");
			}else {
				System.out.println(num + " Not Prime number.");
			}
		}
	}
	
	public static void reverseNumber() {
		while(true) {
			System.out.print("Enter a number: ");
			int num = scan.nextInt();
			
			int reverse = 0;
			while(num != 0) {
				reverse = reverse * 10 + num % 10;
				num /= 10;
			}
			System.out.println(reverse);
		}
	}
	
	public static void pascalTriangle() {
		int length = 5;
		
		for(int a = 0; a < length; a++) {
			for(int b = 0; b < length - a; b++) {
				System.out.print(" ");
			}
			
			int num = 1;
			for(int j = 0; j <= a; j++) {
				System.out.print(num + " ");
				num = num * (a - j) / (j + 1);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			System.out.print("choice: ");
			int choice = scan.nextInt();
			
			if(choice == 1) {
				mergedTwoArray();
			}else if(choice == 2) {
				searchLinear();				
			}else if(choice == 3) {
				primeNumber();
			}else if(choice == 4) {
				reverseNumber();
			}else if(choice == 5) {
				pascalTriangle();
			}
		}
	}

}
