import java.util.Scanner;


public class Etiquetas{

    public static void organizaEtiquetas() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
	    scanner.nextLine();


    
        String idiomas[] = new String[n];
        String saudacao[] = new String[n];

        for(int i =0;i<n;i++) {

		idiomas[i] = scanner.nextLine();
		saudacao[i] = scanner.nextLine();
        }

	int pessoa = scanner.nextInt();
	scanner.nextLine();

	String nome[] = new String[pessoa];
	String linguagemPessoa[] = new String[pessoa];

	for(int i = 0;i<pessoa;i++) {	
		nome[i] = scanner.nextLine();
		linguagemPessoa[i] = scanner.nextLine();

		
    }

     
     
      for(int i=0;i<pessoa;i++) {
	      for(int j=0;j<n;j++) {

		      if(linguagemPessoa[i].equals(idiomas[j])) {
			      System.out.println(nome[i]);
			      System.out.println(saudacao[j]);
				  System.out.println();

				  j = n;

			      
		      }
	      }
      }

      scanner.close();

    }

	public static void main(String[] args) {
	    organizaEtiquetas();
	}



   
}





