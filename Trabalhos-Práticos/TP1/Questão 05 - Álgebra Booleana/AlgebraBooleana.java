import java.util.Scanner;

public class AlgebraBooleana {

    public static boolean calcularExpressao(String str) {
        String resultado = "";
        int inicio = 0, fim = 0;
        boolean resposta;

        while (str.length() > 1) {

            
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    inicio = i;
                } else if (str.charAt(i) == ')') {
                    fim = i;
                    i = str.length();
                }
            }

            if (str.charAt(inicio - 1) == 't') { 
                resultado = "";

                for (int i = 0; i < str.length(); i++) {
                    if (i == (inicio - 3)) {
                        resultado += (str.charAt(inicio + 1) == '0') ? '1' : '0';
                    } else if (i > (inicio - 3) && i <= fim) {
                        resultado += "";
                    } else {
                        resultado += str.charAt(i);
                    }
                }

            } else if (str.charAt(inicio - 1) == 'd') { 
                resultado = "";

                for (int i = 0; i < str.length(); i++) {
                    if (i == (inicio - 3)) {
                        if (str.charAt(inicio + 1) == '1'
                                && str.charAt(inicio + 3) == '1'
                                && str.charAt(fim - 1) == '1') {
                            resultado += '1';
                        } else {
                            resultado += '0';
                        }
                    } else if (i > (inicio - 3) && i <= fim) {
                        resultado += "";
                    } else {
                        resultado += str.charAt(i);
                    }
                }

            } else if (str.charAt(inicio - 1) == 'r') { 
                resultado = "";

                for (int i = 0; i < str.length(); i++) {
                    if (i == (inicio - 2)) {
                        if (str.charAt(inicio + 1) == '1'
                                || str.charAt(inicio + 3) == '1'
                                || str.charAt(fim - 1) == '1' || str.charAt(fim - 3) == '1') {
                            resultado += '1';
                        } else {
                            resultado += '0';
                        }
                    } else if (i > (inicio - 2) && i <= fim) {
                        resultado += "";
                    } else {
                        resultado += str.charAt(i);
                    }
                }
            }

            str = resultado.replaceAll(" ", "");
        }

        resposta = (str.charAt(0) == '1');
        return resposta;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine().replaceAll(" ", "");

        while (entrada.charAt(0) != '0') {
            String bool = "";

            char A = entrada.charAt(1);
            char B = entrada.charAt(2);
            char C = (entrada.charAt(0) == '3') ? entrada.charAt(3) : '*';

            
            if (entrada.charAt(0) == '3') {
                for (int i = 4; i < entrada.length(); i++) {
                    if (entrada.charAt(i) == 'A') {
                        bool += A;
                    } else if (entrada.charAt(i) == 'B') {
                        bool += B;
                    } else if (entrada.charAt(i) == 'C') {
                        bool += C;
                    } else {
                        bool += entrada.charAt(i);
                    }
                }
            } else {
                for (int i = 3; i < entrada.length(); i++) {
                    if (entrada.charAt(i) == 'A') {
                        bool += A;
                    } else if (entrada.charAt(i) == 'B') {
                        bool += B;
                    } else {
                        bool += entrada.charAt(i);
                    }
                }
            }

            System.out.println(calcularExpressao(bool) ? "1" : "0");

            entrada = scanner.nextLine().replaceAll(" ", "");
        }

        scanner.close();
    }
}