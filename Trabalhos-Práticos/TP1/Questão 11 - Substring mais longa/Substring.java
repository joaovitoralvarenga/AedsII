import java.util.Scanner;

public class Substring {
	public static int  contaSubString(String str) {

		int repete = 0;
		int quantidade = 0;
		char letras[] = new char[str.length()];

		for(int i=0;i<str.length();i++) {
			

			for(int j=0;j<str.length();i++) {
				if(letras[j] == str.charAt(i)) {

					repete++;
				}
			}

			if(repete == 0) {
				letras[i] = str.charAt(i);
				quantidade++;
			} 
		}

		return quantidade;
	}

	public static boolean ehFim(String entrada) {
		return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada = scanner.nextLine();

		while ()) {
			
		}
	}

