import java.util.Scanner;


public class IsRec {

    public static boolean soVogal(String palavra,int i) {
        boolean resultado;
        int tamanho = palavra.length();

        if(i>=tamanho) {
            resultado = true;
        } else {
            char c = palavra.charAt(i);
            if((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                resultado = soVogal(palavra, i + 1);
            } else {
                resultado = false;
            }

            
        }
        return resultado;
    }

    public static boolean soConsoante (String palavra,int i) {
        boolean resultado;
        int tamanho = palavra.length();

        if(i>=tamanho) {
            resultado = true;
        } else {
            char c = palavra.charAt(i);
            if ((c >='a' && c <= 'z') && !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                resultado = soConsoante(palavra, i+1);
            } else {
                resultado = false;
            }
        }
        return resultado;
    }

    public static boolean ehNumeroInteiro(String string,int i) {
        boolean resultado;
        int tamanho = string.length();

        if(i>=tamanho) {
            resultado = true;
        } else {
            char c = string.charAt(i);
            if(c >= '0' && c <= '9') {
                resultado = ehNumeroInteiro(string, i+1);
            } else {
                resultado = false;
            }
        }
        return resultado;
    }

    public static boolean ehNumeroReal(String string,int i,boolean temPontoVirgula) {
        boolean resultado = true;
        
        int tamanho = string.length();

        if(i<tamanho) {
                char c = string.charAt(i);

                if(c == '.' || c == ',') {
                    if(temPontoVirgula) {
                        resultado = false;
                    } else {
                        resultado = ehNumeroReal(string, i+1,true);
                    }
                } else if(c >= '0' && c <= '9') {
                    resultado = ehNumeroReal(string, i+1,temPontoVirgula);
                } else {
                    resultado = false;
                }
        }
        return resultado;
    }

    public static boolean ehNumeroReal(String string) {
        boolean resultado;

        if(string.length() == 0) {
            resultado = false;
        } else if(string.length() == 1 && (string.charAt(0) == '.' || string.charAt(0) == ',')) {
            resultado =false;
        } else {
            resultado = ehNumeroReal(string,0,false);
        }
        return resultado;
    }

    public static boolean ehFim(String str) {
        return (str.length() == 3 && str.charAt(0 ) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        while(!ehFim(entrada)) {

            boolean x1 = soVogal(entrada, 0);
            boolean x2 = soConsoante(entrada, 0);
            boolean x3 = ehNumeroInteiro(entrada, 0);
            boolean x4 = ehNumeroReal(entrada);

            System.out.println(
                (x1 ? "SIM" : "NAO") + " " +
                (x2 ? "SIM" : "NAO") + " " +
                (x3 ? "SIM" : "NAO") + " " +
                (x4 ? "SIM" : "NAO")
            );
            entrada = scanner.nextLine();

            
        }
        scanner.close();
    }
}