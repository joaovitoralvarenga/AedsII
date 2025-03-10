import java.util.Scanner;


public class Reversao {

	public static String ReverteString (String palavra) {
	
	int tamanho = palavra.length();	
	char[] resultado = new char[tamanho];
		for(int i=0;i<tamanho;i++){

			resultado[i] = palavra.charAt(tamanho-1-i);

		}

		return new String(resultado);
	}

		

	public static boolean ehFim(String string) {
		boolean resultado = false;
		if(string.length() != 3) {
			resultado = string.charAt(0) == 'F' && string.charAt(1) == "I" && string.charAt(2) == 'M';

		}
		
		return resultado;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String palavra = Scanner.nextLine();


		while(!(ehFim(palavra))) {
			System.out.println(ReverteString(palavra));
			palavra = scanner.nextLine();
		}

		scanner.close();
	}
}

	

		

