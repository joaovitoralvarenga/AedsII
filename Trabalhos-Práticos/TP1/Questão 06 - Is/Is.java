import java.util.Scanner;


public class IsRec {
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
			if((c >= 'a' && c <= 'z')  &&( c == 'a' || c == 'e' || c =='i'  || c ==  'o' || c =='u')){
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
			public static boolean isFim(String str) {
				if (str.length() != 3) {
					return false;
				}
				return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
			}

			public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				String entrada = scanner.nextLine().trim();

				while(!isFim(entrada)) {
					

					boolean x1 = soVogal(entrada) ;
                    boolean x2 = soConsoante(entrada);
                    boolean x3 = ehNumeroInteiro(entrada);
                    boolean x4 = ehNumeroReal(entrada);


					System.out.println(
                    (x1 ? "SIM" : "NAO") + " " +
                    (x2 ? "SIM" : "NAO") + " " +
                    (x3 ? "SIM" : "NAO") + " " +
                    (x4 ? "SIM" : "NAO")
            );

			entrada  = scanner.nextLine().trim();
        }

		scanner.close();
				}
			}
			
		
	


		



		 
