import java.util.Scanner;


public class Validacao {

	public static boolean validaSenhas(String str) {

		boolean valida;

		if(str.length() <= 8) {
			valida = false;
		} else {

			boolean temMaiuscula = false;
			boolean temMinuscula = false;
			boolean temNumero = false;
			boolean temCarectereEspecial = false;
			

			for(int i=0;i<str.length();i++) {

				char c = str.charAt(i);

				if(c >= 'A' && c <= 'Z') {
					temMaiuscula = true;
				}

				else if(c >= 'a' && c <= 'z') {
					temMinuscula = true;
				}
				else if(c >= '0' && c <= '9') {
					temNumero = true;
				}
				else {
					temCarectereEspecial = true;
				}

				
			}

			valida = temCarectereEspecial && temMaiuscula && temMinuscula && temNumero;
		}

		return valida;

	}

	public static boolean ehFim(String str) {
		return (str.length() == 3 && str.charAt(0 ) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada = scanner.nextLine();

		while(!ehFim(entrada)) {
			if(validaSenhas(entrada)
		}

	}
}



		
