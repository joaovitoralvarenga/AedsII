import java.util.Scanner;

public class Ordenacao {
    public static void ordenaStrings() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        for(int i = 0; i < n; i++) {
            String linha = scanner.nextLine();
            String[] palavras = linha.split(" ");
            
            for(int j = 0; j < palavras.length; j++) {
                int maior = j;
                for(int k = j + 1; k < palavras.length; k++) {
                    if(palavras[k].length() > palavras[maior].length()) {
                        maior = k;
                    }
                }
				if(maior != j) {
					String temp = palavras[j];
                palavras[j] = palavras[maior];
                palavras[maior] = temp;
				}
                
            }
            
            System.out.println(String.join(" ", palavras));
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        ordenaStrings();
    }
}