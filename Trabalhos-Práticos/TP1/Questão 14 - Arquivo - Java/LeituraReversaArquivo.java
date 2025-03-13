import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class LeituraReversaArquivo {

    public static void escreveArquivo(int n, Scanner scanner) {
        try (RandomAccessFile arquivo = new RandomAccessFile("numeros.txt", "rw")) {
            
            for (int i = 0; i < n; i++) {
                double numero = scanner.nextDouble();
                arquivo.writeDouble(numero);
            }
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }

    public static void leArquivoReverso(int n) {
        try (RandomAccessFile arquivo = new RandomAccessFile("numeros.txt", "r")) {

            int tamArquivo = (int) arquivo.length();
            int contador = tamArquivo/8;

            int leContador = contador;

            if(n<contador) {
                leContador = n;
            }
           
            for (int i = leContador-1;i>=0; i--) {
               
                arquivo.seek(i * 8);  
                double numero = arquivo.readDouble();

                double parteInteira = (int) numero;
                if(numero - parteInteira == 0) {
                    System.out.println((int)numero);
                } else {
                    System.out.println(numero);
                }
              
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  

      
        escreveArquivo(n, scanner);

        
        leArquivoReverso(n);

        scanner.close();  
    }
}
