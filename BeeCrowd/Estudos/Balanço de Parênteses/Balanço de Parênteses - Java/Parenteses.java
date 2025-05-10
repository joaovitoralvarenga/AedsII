import java.util.*;



public class Parenteses {

    public static boolean expressaoValida(String str) {
        boolean valida = true;

        Stack<Character> parenteses = new Stack<>();            //Se utiliza de uma pilha que armazena carecteres, para garantir maior eficiência.

      for(int i = 0;i< str.length();i++) {
        char c = str.charAt(i);

        if(c == '(') {
            parenteses.push(c);                              //Quando um carectere é reconhecido comoo "(" ele é adicionado à pilha
        }else if(c == ')' && !parenteses.isEmpty()) {        //Se um carectere é ")" e a fila não está vazia, então é reconhecido como uma expressão válida
            parenteses.pop();                                //O único elemento da fila recebe pop, e a mesma se torna vazia, a fim de aumentar a eficiência.
        }else if(c == ')') {
            valida = false;
        }
      }

      if(valida && !parenteses.isEmpty()) {
        valida  = false;
      }
      return valida;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        while(scanner.hasNextLine()) {
            String entrada = scanner.nextLine();
            if(expressaoValida(entrada)) {
                System.out.println("correct");
            } 
            else {
                System.out.println("incorrect");
            }

            

    }

    scanner.close();

}
}



