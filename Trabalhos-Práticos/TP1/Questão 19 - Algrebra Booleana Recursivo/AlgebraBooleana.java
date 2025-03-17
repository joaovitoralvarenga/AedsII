import java.util.Scanner;

public class AlgebraBooleana {

  
    public static String avaliarExpressao(String expressao) {
       
        if (expressao.length() == 1 && (expressao.equals("0") || expressao.equals("1"))) {
            return expressao;
        }
        
     
        int inicio = -1;
        int fim = -1;
        
        for (int i = 0; i < expressao.length(); i++) {
            if (expressao.charAt(i) == '(') {
                inicio = i;
            } else if (expressao.charAt(i) == ')') {
                fim = i;
                break;
            }
        }
        
        
        if (inicio == -1 || fim == -1) {
            return expressao;
        }
        
        
        char operacao = inicio > 0 ? expressao.charAt(inicio - 1) : ' ';
        
      
        String conteudoParenteses = expressao.substring(inicio + 1, fim);
        
        
        String resultado = "";
        if (operacao == 't') { 
            resultado = avaliarNOT(expressao, inicio, fim);
        } else if (operacao == 'd') { 
            resultado = avaliarAND(expressao, inicio, fim);
        } else if (operacao == 'r') {
            resultado = avaliarOR(expressao, inicio, fim);
        } else {
            return expressao;
        }
        
      
        return avaliarExpressao(resultado);
    }
    
   
    private static String avaliarNOT(String expressao, int inicio, int fim) {
     
        if (inicio < 3 || inicio + 1 >= expressao.length()) {
            return expressao;
        }
        
     
        char resultadoNOT = expressao.charAt(inicio + 1) == '0' ? '1' : '0';
        
      
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < expressao.length(); i++) {
            if (i == inicio - 3) {
                resultado.append(resultadoNOT);
            } else if (i > inicio - 3 && i <= fim) {
              
            } else {
                resultado.append(expressao.charAt(i));
            }
        }
        
        return resultado.toString().replaceAll(" ", "");
    }
  
    private static String avaliarAND(String expressao, int inicio, int fim) {
        
        if (inicio < 3 || inicio + 3 >= expressao.length() || fim - 1 < 0) {
            return expressao;
        }
        
      
        char resultadoAND = '0';
        if (expressao.charAt(inicio + 1) == '1' && 
            expressao.charAt(inicio + 3) == '1' && 
            expressao.charAt(fim - 1) == '1') {
            resultadoAND = '1';
        }
        
        
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < expressao.length(); i++) {
            if (i == inicio - 3) {
                resultado.append(resultadoAND);
            } else if (i > inicio - 3 && i <= fim) {
              
            } else {
                resultado.append(expressao.charAt(i));
            }
        }
        
        return resultado.toString().replaceAll(" ", "");
    }
    
    
    private static String avaliarOR(String expressao, int inicio, int fim) {
      
        if (inicio < 2 || inicio + 1 >= expressao.length() || fim - 1 < 0) {
            return expressao;
        }
        
        
        char resultadoOR = '0';
        if (expressao.charAt(inicio + 1) == '1' || 
            (inicio + 3 < expressao.length() && expressao.charAt(inicio + 3) == '1') || 
            expressao.charAt(fim - 1) == '1' || 
            (fim - 3 >= 0 && expressao.charAt(fim - 3) == '1')) {
            resultadoOR = '1';
        }
        
        
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < expressao.length(); i++) {
            if (i == inicio - 2) {
                resultado.append(resultadoOR);
            } else if (i > inicio - 2 && i <= fim) {
              
            } else {
                resultado.append(expressao.charAt(i));
            }
        }
        
        return resultado.toString().replaceAll(" ", "");
    }
    
   
    public static boolean calcularExpressao(String expressao) {
        String resultado = avaliarExpressao(expressao);
        return resultado.length() > 0 && resultado.charAt(0) == '1';
    }
    
    public static String substituirVariaveis(String entrada, char A, char B, char C) {
        StringBuilder bool = new StringBuilder();
        
        int inicioIndice = entrada.charAt(0) == '3' ? 4 : 3;
        
        for (int i = inicioIndice; i < entrada.length(); i++) {
            if (entrada.charAt(i) == 'A') {
                bool.append(A);
            } else if (entrada.charAt(i) == 'B') {
                bool.append(B);
            } else if (entrada.charAt(i) == 'C' && entrada.charAt(0) == '3') {
                bool.append(C);
            } else {
                bool.append(entrada.charAt(i));
            }
        }
        
        return bool.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine().replaceAll(" ", "");

        while (entrada.length() > 0 && entrada.charAt(0) != '0') {
            if (entrada.length() > 2) {
                char A = entrada.charAt(1);
                char B = entrada.charAt(2);
                char C = (entrada.length() > 3 && entrada.charAt(0) == '3') ? entrada.charAt(3) : '*';
                
                String expressaoBooleana = substituirVariaveis(entrada, A, B, C);
                
                System.out.println(calcularExpressao(expressaoBooleana) ? "1" : "0");
            } else {
                System.out.println("0"); 
            }
            
            entrada = scanner.nextLine().replaceAll(" ", "");
        }

        scanner.close();
    }
}