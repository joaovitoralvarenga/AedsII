import java.util.Scanner;

public class Combinador  {

	public static String combinaString(String str1, String str2) {
		
		StringBuilder combinacao = new StringBuilder();
		int tam1 = str1.length();
		int tam2 = str2.length();
		int i;

		for(i=0;i<tam1 && i<tam2;i++) {
			combinacao.append(str1.charAt(i));
			combinacao.append(str2.charAt(i));
		}

		while(i<tam1) {
			combinacao.append(str1.charAt(i));
			i++;
		}

		while(i<tam2) {
			combinacao.append(str2.charAt(i));
			i++;
		}

		return combinacao.toString();

	}
		
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	scanner.nextLine();

	for(int i = 0;i<n;i++) {
		String entrada = scanner.nextLine();
		String[] linha = entrada.split(" ");

		String str1 = linha[0];
		String str2 = linha[1];

		String resultado = combinaString(str1, str2);
		System.out.println(resultado);
	}

	scanner.close();

	}
	
}



