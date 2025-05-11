import java.util.*;

public class TDA {

    public static void resultadoTDA(int num1,int den1, String operador, int num2, int den2) {
        
        int totalNum = 0;
        int totalDen = 0;

        char op = operador.charAt(0);

        switch (op) {
            case '+':
               totalNum = num1 * den2 + num2 * den1;
               totalDen = den1 * den2;
                break;
            case '-':
               totalNum = num1 * den2 - num2 * den1;
               totalDen = den1 * den2;
                break;
            case '*':
               totalNum = num1 * num2;
               totalDen = den1 * den2;
                break;
            case '/':
               totalNum = num1 * den2;
               totalDen = den1 * num2;  
                break;
        
        }

        int divisor = mdc(totalNum, totalDen);
        int numSimplificado = totalNum/divisor;
        int denSimplficado = totalDen/divisor;

        System.out.println(totalNum + "/" + totalDen + " = " + numSimplificado + "/" + denSimplficado);
    }

    public static int mdc(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<n;i++) {
            String line = scanner.nextLine();
            String[] partes = line.split(" ");

            int n1 = Integer.parseInt(partes[0]);
            int d1 = Integer.parseInt(partes[2]);
            String operador = partes[3];
            int n2 = Integer.parseInt(partes[4]);
            int d2 = Integer.parseInt(partes[6]);

            resultadoTDA(n1, d1, operador, n2, d2);
        }

        scanner.close();
    }
}