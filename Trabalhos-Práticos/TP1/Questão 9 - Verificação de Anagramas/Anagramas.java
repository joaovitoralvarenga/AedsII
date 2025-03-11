import java.util.Scanner;


public class Anagramas {

	public static boolean ehAnagrama(String str1, String str2) {
		boolean iguais = true;

			if(str1.length() != str2.length()) {
				iguais = false;
			}


			int[] contador = new int[26];

			for(int i=0;i<str1.length();i++) {
				char c = str1.charAt(i);
				if(c >= 'a' && c <= 'z') {
					contador[c-'a']++;
				} else if(c >= 'A' && c <= 'Z') {
					contador[c-'A']++;
				}
			}

			for(int i=0;i<str2.length();i++) {
				char c = str2.charAt(i);
				if(c >= 'a' && c <= 'z') {
					contador[c -'a']--;
				} else if(c >= 'A' && c <= 'Z') {
					contador[c- 'A']--;
	
				}
			}

			for(int i=0;i<26;i++) {
				if(contador[i] != 0) {
					iguais = false;
				}
			}

			return iguais;
	
		}

		public static boolean ehFim(String str) {
			return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
		}

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in); 
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
					System.out.println("SIM");
				} else {
					System.out.println("NAO");
				}

				entrada = scanner.nextLine();
			}

		   scanner.close();
		}
		
	}

	