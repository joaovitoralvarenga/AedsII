import java.util.Scanner;


public class Anagramas {

	public static boolean ehAnagrama(String str1, String str2) {
		boolean iguais = true;

			if(str1.length() != str2.length()) {     //Caso base, uma vez que se as strings tem quantidades diferentes de carecteres
				iguais = false;                      //obrigatoriamente elas não podem ser anagramas
			}


 			int[] contador = new int[26];           //Declaração de um array que serve como contador relativo a frequência de cada carectere.

			for(int i=0;i<str1.length();i++) {      
				char c = str1.charAt(i);
				if(c >= 'a' && c <= 'z') {          //Na primeira string, o contador é incrementado para cada carecter, afim de que posteriormente
					contador[c-'a']++;              //possa se estabelecer uma comparação com a segunda string
				} else if(c >= 'A' && c <= 'Z') {
					contador[c-'A']++;
				}
			}

			for(int i=0;i<str2.length();i++) {
				char c = str2.charAt(i);
				if(c >= 'a' && c <= 'z') {
					contador[c -'a']--;            //É realizado o decremento afim de constatar uma comparação depois
				} else if(c >= 'A' && c <= 'Z') {
					contador[c- 'A']--;
	
				}
			}

			for(int i=0;i<26;i++) {
				if(contador[i] != 0) {
                 //Após o decremento de carecteres que são encontrados nas duas strings
				 //se o valor atribuído ao contador for igual a 0, significa que as strings são anagramas, pois possuem a presença das mesmas letras 
				 //com o mesmo numero de aparições.
					
					iguais = false;
				}
			}

			return iguais;
	
		}

		public static boolean ehFim(String str) {
			return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
		}

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in, "UTF-8") ; 
			String entrada = scanner.nextLine();

			while(!ehFim(entrada)) {
				String str1 = "", str2 = "";
				int i = 0;
				while(i < entrada.length() && entrada.charAt(i)!= ' '){
					str1 += entrada.charAt(i);
					i++;
				}

				i += 3;
				while(i<entrada.length()) {
					str2 += entrada.charAt(i);																																										
					i++;
				}
				

				if(ehAnagrama(str1, str2)) {
				MyIO.println("SIM");
				} else {
					MyIO.println("NÃO");
				}

				entrada = scanner.nextLine();
			}

		   scanner.close();
		}
		
	}

	
