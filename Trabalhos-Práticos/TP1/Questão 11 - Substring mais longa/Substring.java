import java.util.Scanner;

public class Substring {
	public static int contaSubString(String str) {
		int quantidade = 0;
		int maior = 0;
		char letras[] = new char[str.length()];
		int inicio = 0;
		//Variável que será utilizada posteriormente para alteração do ponto de partida 
		//da checagem das letras de cada string.		

		for(int i=0;i<str.length();i++) {
			char atual = str.charAt(i);
			
			for(int j = inicio;j<quantidade;j++) {   //É realizada uma dupla checagem no vetor, afim de contastar a presença repetida de um carectere
				if(letras[j] == str.charAt(i)) { 
					inicio = j + 1;                   //Se um carectere aparece mais de uma vez, a contagem reinicia a partir do caractere que vem depois do repetido

				}
			}

			letras[quantidade] = atual;	             
			 //O vetor é atualizado para a variável que se repete
			quantidade++;

			if((quantidade- inicio) > maior) {         //Realiza a checagem da maior substring, apartir da comparação entre o tamanho a posição após a letra repetida.
				maior = quantidade - inicio;
			}
		}

		return maior;
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

