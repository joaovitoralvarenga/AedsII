import java.util.Scanner;

public class Contagem {
       public static int contaPalavras(String str) {

              int palavras = 1;

              for(int i=0;i<str.length();i++) {
                     if(str.charAt(i) == ' ' ){
                            palavras++;
                     }
              }
             
              return palavras;

       } 

       public static boolean ehFim(String str) {
              return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2)== 'M');
       }


 

       public static void main(String[] args) {
              Scanner scanner = new Scanner(System.in);
              String entrada = scanner.nextLine();

              while(!ehFim(entrada)) {
                     System.out.println(contaPalavras(entrada));
                     entrada = scanner.nextLine();
              }
              
              scanner.close();
       }

}

       
	       
