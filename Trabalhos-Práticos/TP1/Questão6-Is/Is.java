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
			if(!(c >= 'a' || c <= 'z') && (c != 'a' || c != 'e' || c != 'i' || c != 'o' || c != 'u')) {
				resultado = false;
			}
		}
		return resultado;
		
	}

	public static boolean ehNumeroInteiro(String string) {
		boolean resultado = false;
		for(int i=0;i<string.length();i++) {
			char c = string.charAt(i);
			
			if( c == '.' || c ==',') {
				resultado = true;
			}
		}

		return resultado;
	}

	public static boolean ehNumeroReal(String string) {
		boolean resultado = false;
		boolean temPontoVirgula = false;
		for(int i=0;i<string.length();i++) {
			char c = string.charAt(i);
			boolean ehDigito = (c >= '0' && c <= '9');
			if(c >= '0' && c <= '9') {

			}
		}
	}
}

		



		 
