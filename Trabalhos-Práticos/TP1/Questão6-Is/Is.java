import java.util.Scanner;


public class Is {
	public static boolean soVogal (String palavra) {
		boolean resultado = true;
		for(int i=0;i<palavra.length();i++) {
			char c = Character.toLowerCase(palavra.charAt(i));
			if(! (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
				resultado = false;
			}
		}
		return resultado;
	}
	public static boolean soConsoante(String palavra) {
		boolean resultado = true;
		for(int i=0;i<palavra.length();i++) {
			char c = Character.toLowerCase(palavra.charAt(i));
			if(!(c >= 'a' && c <= 'z') && (c != 'a' && c != 'e' && c != 'i'  && c != 'o' && c != 'u')) {
				resultado = false;
			}
		}
		return resultado;
		
	}

	public static boolean ehNumeroInteiro(String string) {
		boolean resultado = true;
		for(int i=0;i<string.length();i++) {
			char c = string.charAt(i);
			boolean ehDigito = (c >= '0' && c <= '9');
			
			if(!ehDigito) {
				resultado = false;
			}
		}

		return resultado;
	}

	public static boolean ehNumeroReal(String string) {
		boolean resultado = true;
		boolean temPontoVirgula = false;
		for(int i=0;i<string.length();i++) {
			char c = string.charAt(i);
			boolean ehDigito = (c >= '0' && c <= '9');

			if(c == ',' || c == '.') {
				if(temPontoVirgula) {
					resultado = false;
				}
				temPontoVirgula = true;

			} else if(!ehDigito) {
				resultado = false;
			}

			if(temPontoVirgula && string.length() == 1) {
				resultado = false;
			}

			}
			return resultado;
			
			}
			
		}
	


		



		 
