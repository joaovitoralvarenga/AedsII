import java.util.Scanner;




public class SomaV2 {

	public static int somaDigitos(String str, int i) {
		int soma = 0;
		if(i<str.length()) {
			char n = str.charAt(i);
			soma = (n - '0');
			soma += somaDigitos(str, i+1);
	}
	
	return soma;
}

	public static boolean ehFim(String str) {
		return(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
	 
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada = scanner.nextLine();
		while(!ehFim(entrada)) {

			System.out.println(somaDigitos(entrada, 0));
			entrada = scanner.nextLine();

			
		}
		scanner.close();
	}

	}


		

			

		



