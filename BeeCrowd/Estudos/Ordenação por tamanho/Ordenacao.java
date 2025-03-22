import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ordenacao {
    public static void InsertionSort(List<String> palavras) {
        int n = palavras.size();
        for (int i = 1; i < n; i++) {
            String chave = palavras.get(i);
            int j = i - 1;

            
            while (j >= 0 && palavras.get(j).length() < chave.length()) {
                palavras.set(j + 1, palavras.get(j));
                j--;
            }
            palavras.set(j + 1, chave); 
        }
    }

    public static void ordenaStrings() {

        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i =0;i<n;i++) {
            String linha = scanner.nextLine();
            List<String> palavras = new ArrayList<>(Arrays.asList(linha.split(" ")));

            InsertionSort(palavras);

            System.out.println(String.join(" ", palavras));
        }

        scanner.close();
    
    }
        
    
    public static void main(String[] args) {
        ordenaStrings();
    }
}