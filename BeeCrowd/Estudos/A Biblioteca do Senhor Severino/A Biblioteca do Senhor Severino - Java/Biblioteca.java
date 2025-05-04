import java.util.*;


public class Biblioteca {

	public static void ordenaPorCouting(String[] arrayLivros, int[] codigos) {       //Declara-se dois arrays, um inteiro e um de strings, a fim de comportar a demanda das entradas.
	       int tam = codigos.length;

	       int max = 0;
	       for(int i=0;i<tam;i++) {
		       if(codigos[i] > max) {
			       max = codigos[i];
		       }                                                    //Utiliza-se do algoritimo de ordenação "Couting Sort", visto que os elementos a serem ordenados
	       }                                                        //compreendem apenas números inteiros, caso ideal para esse algoritmo, a fim de aumentar a eficiência.

	       int[] contador = new int[max + 1];

	       for(int i=0;i<tam;i++) {
		       contador[codigos[i]]++;
	       }

	       String[] resultado = new String[tam];

	       int indiceResultado = 0;

	       for(int i = 0;i <= max;i++) {
		       while(contador[i] > 0 ) {

			       String codigosFormatados = String.format("%04d",i);
			       resultado[indiceResultado] = codigosFormatados;
			       indiceResultado++;
			       contador[i]--;
			       
		       }
	       }

	     for(int i = 0;i < tam; i++) {
		     arrayLivros[i] = resultado[i];
	     }
	}


     public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     

		 while(scanner.hasNextInt()) {

			int n = scanner.nextInt();
			scanner.nextLine();

			String[] codigosLivros = new String[n];
			int[] codigos = new int[n];

			for(int i = 0;i<n;i++) {
				codigosLivros[i]= scanner.nextLine().trim();                  //Após ler os números, quando há uma quebra de linha, essa linha é interpretada como um elemento do array.
				codigos[i] = Integer.parseInt(codigosLivros[i]);              //Esses elementos, então são convertidos em "string", como a saída do problema.

			}

			ordenaPorCouting(codigosLivros, codigos);

			for(String code : codigosLivros) {
				System.out.println(code);
			}
			}


			scanner.close();


		 }
		}




		       

