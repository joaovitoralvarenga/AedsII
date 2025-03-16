import java.util.Scanner;


public class IsRec {

    public static boolean soVogal(String palavra,int i) {
        boolean resultado;
        int tamanho = palavra.length();

        if(i>=tamanho) {
            resultado = true;
        } else {
            char c = palavra.charAt(i);
            if(!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
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
            if(c >= 0 && c <= 9) {
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

    public static boolean ehNumeroReal(String,)
}