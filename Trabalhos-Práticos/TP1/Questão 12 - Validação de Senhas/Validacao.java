import java.util.Scanner;


public class Validacao {

	public static boolean validaSenhas(String str) {

		boolean valida;

		if(str.length() < 8) {
			valida = false;
			//Se a senha tem menos de 8 caracteres, a senha já é definida como inválida, afim de poupar checagens desncessárias.
		} else {

			boolean temMaiuscula = false;                //Definição de varíaveis que posteriromente retornaram valores booleanos 
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

			valida = temCarectereEspecial && temMaiuscula && temMinuscula && temNumero;    //A varíavel válida so retorna true se todas as outras condicionais forem verdadeiras
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
			if(validaSenhas(entrada)) {
				System.out.println("SIM");
			} else {
				System.out.println("NAO");
			}

			entrada = scanner.nextLine();
		}
		scanner.close();

	}
}



		
