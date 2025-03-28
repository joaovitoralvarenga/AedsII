import java.util.Scanner;
import java.util.Stack;

public class DiamantesAreia {

	public static int achaDiamantes(String str) {
		Stack<Character> diamante = new Stack<>();             //Utilização de uma pilha, a fim de armazenar e logo retirar os elementos inseridos,
		int diamantes = 0;                                     //assim dimunuindo o custo do processo de comparação e identificação de diamantes
		
		for(int i=0;i<str.length();i++) {
			char c =str.charAt(i);

			if(c == '<') {
				diamante.push(c);                          
			} else if(c == '>' && !diamante.isEmpty()) {        //Se o elemento for ">" e a pilha conter pelo menos um elemento, ele retira esse elemento
				diamante.pop();                                 //e incrementa a quantidade de diamantes, deixando a pilha vazia para otimizar o custo.
				diamantes++;
			}
		}

		return diamantes;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		for(int i =0;i<n;i++) {
			String entrada = scanner.nextLine();
			System.out.println(achaDiamantes(entrada));
		}
		
		scanner.close();
	}
}
	
