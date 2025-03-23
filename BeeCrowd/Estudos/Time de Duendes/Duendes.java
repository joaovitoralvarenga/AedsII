
import java.util.Scanner;


public class Duendes {

	public static void ordenaDuendes(String[] nome, int[] idade,int n)	{
		

		for(int i=0;i<n-1;i++) {
			int maior = i;

			for(int j= i+1;j<n;j++) {
				if((idade[j] > idade[maior] || (idade[j] == idade[maior] && nome[j].compareTo(nome[maior]) < 0)) ) {
					maior = j;
				}
			}

			int tempIdade = idade[i]; 
			idade[i] = idade[maior];
			idade[maior] = tempIdade;

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
			System.out.println(nome[i] + " " + idade[i]);
			 System.out.println(nome[i+numTimes] + " " + idade[i+numTimes]);
			 System.out.println(nome[i+2*numTimes] + " " + idade[i+2*numTimes]);
			 System.out.println();
		}
		scanner.close();
	}

	public static void main(String[] args) {
		
		ordenaTimes();
	}
}