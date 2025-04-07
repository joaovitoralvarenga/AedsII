import java.util.*;



public class Dicionario {

	public static void extraiPalavra(String texto, Set<String> palavras) {
		StringBuilder palavraAtual = new StringBuilder();
		

		texto = texto + " ";
		int tam = texto.length();

	

		for(int i=0;i<tam;i++) {

			char c = texto.charAt(i);
			boolean maiuscula = c >= 'A' && c <= 'Z';
			boolean minuscula = c >= 'a' && c <= 'z';              //Converte qualquer ocorrência de letra maíuscula par minúscula 
			                                                       //visto que elas devem ser desconsideradas

			if(maiuscula || minuscula) {
				if(maiuscula) {
					c = (char) (c - 'A' + 'a');
				}

				palavraAtual.append(c);
			} else if(palavraAtual.length() > 0) {
				palavras.add(palavraAtual.toString());
				palavraAtual  = new StringBuilder();             //Adiciona a palavra sem ocorrência de maísuculas a um set 
			}	                                                 //passado por referência que será incorporado em um HashSet na main.

		}
			
	}

	public static void quickSort(List<String> lista, int inicio,int fim) {
		if(inicio<fim) {
			int posicaoPivo = particionar(lista,inicio,fim);
			quickSort(lista, inicio, posicaoPivo - 1);
			quickSort(lista, posicaoPivo + 1, fim);
		}
	}

	public static int particionar(List<String> lista, int inicio, int fim) {
		String pivo  = lista.get(fim);
		int i = inicio - 1;

		for(int j = inicio;j< fim;j++) {
			if(lista.get(j).compareTo(pivo) <= 0) {
				i++;
				trocar(lista,i,j);
			}
		}

		trocar(lista,i+1,fim);
		return i + 1;
	}

	public static void trocar(List<String> lista,int i,int j) {
		String temp = lista.get(i);
		lista.set(i,lista.get(j));
		lista.set(j,temp);
	}

	public static void main(String[] args) {
		Set<String> conjuntoPalavras = new HashSet<>();
		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			extraiPalavra(linha, conjuntoPalavras);
		}

		scanner.close();

		List<String> palavrasOrdenadas = new ArrayList<>(conjuntoPalavras);
        quickSort(palavrasOrdenadas, 0, palavrasOrdenadas.size() - 1);

        for (String palavra : palavrasOrdenadas) {
            System.out.println(palavra);
        }
	}

}
		

