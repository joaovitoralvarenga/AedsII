import java.util.Scanner;


public class PalindromoRec {
	public static boolean ehPalindromo(String str,int i) {
		boolean palindromo = true;
		int tamanho = str.length() ;

		if(i>tamanho/2) {
			palindromo = true;
		}
		else {
			if(str.charAt(i) != str.charAt(tamanho - 1 - i)) {
				palindromo = false;
			}else {
				palindromo = ehPalindromo(str, i+1);
			}
		}

		return palindromo;

		
	}
	
	public static boolean ehFim(String string) {
		return (string.length() == 3 && string.charAt(0) == 'F' && string.charAt(1) == 'I' && string.charAt(2) == 'M');
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada = scanner.nextLine();

		while(!ehFim(entrada)) {
			if(ehPalindromo(entrada, 0)) {
				System.out.println("SIM");
			} else {
				System.out.println("NAO");
			}

			entrada = scanner.nextLine();
		}

		scanner.close();
	}
}

	

			
		
			

