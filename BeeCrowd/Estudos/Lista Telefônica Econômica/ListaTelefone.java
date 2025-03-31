import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTelefone {

	public static int eliminaCarecteres (String string1, String string2) {
		int contador = 0;
		int tam = Math.min(string1.length(),string2.length());
		boolean iguais  = true;

		for(int i =0;i<tam && iguais;i++) {
			if(string1.charAt(i) == string2.charAt(i)) {
				contador++;
			} else {
				iguais = false;

			}
		} 
		return contador;
	}

	public static int calculaEconomia(List<String>telefones) {
		int economia = 0;
		for(int i =1;i<telefones.size;i++) {
			economia += eliminaCarecteres(telefones.get(i-1), telefones.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> telefones = new ArrayList<>();

		while(scanner.hasNextInt()) {
			int n = scanner.nextInt();
			scanner.nextLine();
			telefones.clear();

			for(int i=0;i<n;i++) {
				telefones.add(scanner.nextLine());

			}

			System.out.println(calculaEconomia(telefones));
		}


		scanner.close();

		}
		

		}
		

		

			

	
	

	

		

		
