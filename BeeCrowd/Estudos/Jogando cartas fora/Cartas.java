import java.util.Scanner;


public class Cartas {

	public static void manejaBaralho(int n, int[] cartas) {

		System.out.print("Discarded cards: ");

		for(int i=0;i<n-1;i++) {

			System.out.print( cartas[i] + (i < n- 2 ? ", " : "\n"));

			int temp = cartas[i+1];

			for(int j= i +1;j< n-1;j++) {
				cartas[j] = cartas[j+1];
			}

			cartas[n-1] = temp;
			
		}

		System.out.print("Remaining card: " + cartas[n-1]);
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

	
		while(n != 0) {

			int[] cartas = new int[n];
			for(int i=0;i<n;i++) {
				cartas[i] = i+1;
			}	

			manejaBaralho(n, cartas);

			n = scanner.nextInt();

		}

		

		scanner.close();
	}
}






