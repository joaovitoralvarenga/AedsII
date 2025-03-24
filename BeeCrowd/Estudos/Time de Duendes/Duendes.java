
import java.util.Scanner;


public class Duendes {

	public static void ordenaDuendes(String[] nome, int[] idade,int n)	{
		

		for(int i=0;i<n-1;i++) {
			int maior = i;

			for(int j= i+1;j<n;j++) {
				if((idade[j] > idade[maior] || (idade[j] == idade[maior] && nome[j].compareTo(nome[maior]) < 0)) ) {
					//Ordena-se por seleção as informações sobre os duendes, visto a quantidade de dados e requisitos.
					
					maior = j;
				}
			}

			int tempIdade = idade[i]; 
			idade[i] = idade[maior];
			idade[maior] = tempIdade;        //A troca é realizada tanto para a idade e para o nome, afim de que 
			                                 //as informações relativas ao duende "X" fiquem "na mesma posição" no array.

			String tempNome = nome[i]; 
			nome[i] = nome[maior];
			nome[maior] = tempNome;
		}
	}

	public static void ordenaTimes() {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		

		String[] nome = new String[n];
		int[] idade = new int[n];

		for(int i=0;i<n;i++) {

			nome[i] = scanner.next();
			idade[i] = scanner.nextInt();
			
		}

		ordenaDuendes(nome, idade,n);

		
		int numTimes = n/3;
		for(int i=0;i<numTimes;i++) {
		
			System.out.println("Time " +(i+1));
			System.out.println(nome[i] + " " + idade[i]); //Para o primeiro duende apenas imprime o primeiro elemento
			 System.out.println(nome[i+numTimes] + " " + idade[i+numTimes]);
			 //Para o entregador, a posição no array é somada do número de times, a fim de posiconá-lo no time correto.
			 System.out.println(nome[i+2*numTimes] + " " + idade[i+2*numTimes]);
			 System.out.println();
		}
		scanner.close();
	}

	public static void main(String[] args) {
		
		ordenaTimes();
	}
}