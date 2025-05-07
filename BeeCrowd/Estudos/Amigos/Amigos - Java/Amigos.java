import java.util.*;


public class Amigos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] amigosAtuais = scanner.nextLine().split(" ");
		List<String> listaL = new ArrayList<>(Arrays.asList(amigosAtuais));

		String[] listaN = scanner.nextLine().split(" ");

		String listaS = scanner.nextLine();

		if(listaS.equals("nao")) {
			
			listaL.addAll(Arrays.asList(listaN));

		} else {

			int posicao = listaL.indexOf(listaS);

			listaL.addAll(posicao, Arrays.asList(listaN));

		}

		StringBuilder resultado = new StringBuilder();
		for(int i = 0; i < listaL.size();i++) {
			resultado.append(listaL.get(i));
			if(i < listaL.size() - 1) {
				resultado.append(" ");
			}
		}

		System.out.println(resultado.toString());

		scanner.close();

	}

}

		  

				
	
