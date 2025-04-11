import java.util.Scanner;


public class Atalhos {

	public static String codificaHtml(String str) {
		int tam = str.length();
		StringBuilder codificada = new StringBuilder();
		boolean italicoAberto = false;
	    boolean negritoAberto = false;

		for(int i=0;i<tam;i++) {
			char c = str.charAt(i);

			if(c == '_') {
				codificada.append(italicoAberto ? "</i>" : "<i>");
				italicoAberto = !italicoAberto;
			}else if(c == '*') {
				codificada.append(negritoAberto ? "</b>" : "<b>");
				negritoAberto = !negritoAberto;
			} else {
				codificada.append(c);
			}
		
			}
			return codificada.toString();
		}
		
		  public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				System.out.println(codificaHtml(linha));
				
			}

			

			scanner.close();
		  }
		}




