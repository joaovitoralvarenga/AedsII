import java.util.Random;
import java.util.Scanner;

public class AlteracaoAleatoria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();
        gerador.setSeed(4);

        String palavra = scanner.nextLine();

        while(!(ehFim(palavra))) {

            char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26 ));

            String resultado = palavra.replace(letra1,letra2);

            System.out.println(resultado);

            palavra = scanner.nextLine();
        }
        scanner.close();
    }

    public static boolean ehFim(String palavra) {
        boolean fim = false;
        if(palavra.length() == 3){
            if (palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M') {
                fim = true;
        }
    }
    return fim;
    }

    public static String TrocaCaracteres(String texto, char letra1, char letra2) {
    
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char atual = texto.charAt(i);
            if (atual == letra1) {
                resultado.append(letra2); 
            } else {
                resultado.append(atual);
            }
        }

        return resultado.toString();
    }
}