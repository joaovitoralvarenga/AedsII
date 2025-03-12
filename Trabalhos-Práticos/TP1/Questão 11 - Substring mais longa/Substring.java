import java.util.Scanner;

public class Substring {
	public static int  contaSubString(String str) {
		int quantidade = 0;
		char letras[] = new char[str.length()];

		for(int i=0;i<str.length();i++) {

			boolean encontrado = false;
			
			for(int j=0;j<quantidade;j++) {
				if(letras[j] == str.charAt(i)) {
					encontrado = true;
				}
			}

			if(!encontrado) {
				letras[quantidade] = str.charAt(i);
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

		while(!ehFim(entrada)) {
			System.out.println(contaSubString(entrada));
			entrada = scanner.nextLine();
		}

		scanner.close();
 
	
	}

}

