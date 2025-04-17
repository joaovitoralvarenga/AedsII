import disney.Show;
import java.util.*;

public class PesquisaSequencial {

    public static boolean BuscaSequencial(String title) {
        Show[] shows =  new Show[400];
        boolean encontrado = false;
        int comparações = 0;

        for(int i=0;i<shows.length && !encontrado;i++) {
            comparações++;
            if(shows[i].getTitle() == title) {
                encontrado = true;
                

            }

        }

        return encontrado;
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada  = scanner.nextLine();

        Show[] shows = new Show[500];
        int contador = 0;

        Show.leArquivo();
        List<String>linhas = new ArrayList<>(400);

        long inicio = System.currentTimeMillis();
        int[] comparações = new int[1];

        while(!Show.ehFim(entrada)) {
            int indice = Show.converteStr(entrada);
            if(indice >=0 && indice < linhas.size()); {
                Show s = new Show();
                s.ler(linhas.get(indice));
                shows[contador++] = s;
            }

            = scanner.nextLine;
            }

            while(!Show.ehFim(entrada)) {
                boolean achado = BuscaSequencial()
            }

        }

        






    

}



