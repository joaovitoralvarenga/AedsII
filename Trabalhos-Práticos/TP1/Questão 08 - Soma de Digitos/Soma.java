import java.util.Scanner;




public class Soma {

	public static int SomaDigitos(int numero) {

		int resultado;
		if(numero == 0) {
			resultado = 0;
		} else {

			resultado = (numero % 10) + SomaDigitos(numero/10);
		}

		return resultado;
	}

	public static boolean ehFim(String str) {
		return(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
	 
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada = scanner.nextLine();
		while(!ehFim(entrada)) {

			int n = Integer.parseInt(entrada);
			int soma = SomaDigitos(n);
			System.out.println(soma);
			entrada = scanner.nextLine();
		}
		scanner.close();
	}

}


		

			

		


