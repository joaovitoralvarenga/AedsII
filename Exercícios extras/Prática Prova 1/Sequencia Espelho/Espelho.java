import java.util.Scanner;

public class Espelho {

    public static void espelho(int inicio,int fim) {

        String sequencia = "";

        for(int i=inicio;i<= fim;i++) {
            sequencia += i;
        }

        System.out.print(sequencia);

        for(int i = sequencia.length()-1;i >= 0;i--) {
            System.out.print(sequencia.charAt(i));
        }

        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inicio, fim;

        while(scanner.hasNextLine()) {
            inicio = scanner.nextInt();
            fim = scanner.nextInt();
            espelho(inicio, fim);
        }

        scanner.close();
    }

    }
    

