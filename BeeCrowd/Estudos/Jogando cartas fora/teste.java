import java.util.Scanner;

public class teste {


    public static void ordenaArray(int n, int[] cartas) {
        for(int i=0;i<n-1;i++) {
            int temp = cartas[i+1];
            for(int j=i+1;j<n-1;j++) {
                cartas[j] = cartas[j+1];
            }
            cartas[n-1] =temp;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] cartas = new int[n];

        for(int i=0;i<n;i++){
            cartas[i] = i+1;
        }

        ordenaArray(n, cartas);

        System.out.print("Array final: ");
        for (int carta : cartas) {
            System.out.print(carta + " ");
        }
        
        scanner.close();
    }
    
}
