import java.util.Scanner;


public class Anagramas {

	public static boolean ehAnagrama(String str1, String str2) {
		bool iguais = true;

			if(str1.length() != str2.length()) {
				iguais = false;
			}

			int[] contagem = new int[52];

			for(int i=0;i<str1.length();i++) {
				char c = str1.charAt(i);
				if(c >= 'a' && c <= 'z') {
					contagem[c-'a']++
				} else if(c >= 'A' && c
			}






		}

		public static boolean ehFim(String str) {
			return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
		}

	}
		  

