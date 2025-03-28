import java.util.Scanner;
import java.util.Stack;

public class DiamantesAreia {

	public static int achaDiamantes(String str) {
		Stack<Character> diamante = new Stack<>();
		int diamantes = 0;
		
		for(int i=0;i<str.length();i++) {
			char c =str.charAt(i);

			if(c == '<') {
				diamante.push(c);
			} else if(c == '>' && !diamante.isEmpty()) {
				diamante.pop();
				diamantes++;
			}
		}

		return diamantes;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		for(int i =0;i<n;i++) {
			String entrada = scanner.nextLine();
			System.out.println(achaDiamantes(entrada));
		}
		
		scanner.close();
	}
}
	
