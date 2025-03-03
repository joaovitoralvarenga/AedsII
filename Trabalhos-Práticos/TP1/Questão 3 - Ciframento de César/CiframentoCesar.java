import java.util.Scanner;

public class CiframentoCesar  {
    
    public static void cifra(StringBuilder str) {
        int tamanho = str.length();

        for (int i = 0; i < tamanho; i++) {

            char c = str.charAt(i);
            if( c >= 0 && c<= 127) {
                str.setCharAt(i, (char)((c+3) % 128));
            }
         
        }
    }

    public static boolean isFim(String str) {
        if (str.length() != 3) {
            return false;
        }
        return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mensagem = scanner.nextLine();

        while (!isFim(mensagem)) { 
        StringBuilder mensagemCifrada = new StringBuilder(mensagem);
        cifra(mensagemCifrada);
        System.out.println(mensagemCifrada);

        mensagem = scanner.nextLine();
        }

        
      

        scanner.close();
    }
}
