import java.util.Scanner;


public class CiframentoRec {
	public static String Cifra(String string, int i) {
		int tamanho = string.length();
		String cifrada = "";

		if(i >= tamanho) {
			cifrada = "";
		} else {
			char c = string.charAt(i);
			if(c >= 32 && c < 126) {
				char carectere = (char) (c+3);
				cifrada = carectere + Cifra(string, i + 1);
			} else {
				cifrada = c + Cifra(string, i+1);
			}

		    
		}
		return cifrada;
	}

	public  static boolean ehFim(String str) {
		return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada = scanner.nextLine();

		while(!ehFim(entrada)) {
			System.out.println(Cifra(entrada, 0));

			entrada = scanner.nextLine();
		}

		scanner.close();

		
	}

}

		
			




