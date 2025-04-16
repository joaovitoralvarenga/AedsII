import disney.Show;
import java.util.*;

public class PesquisaSequencial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada  = scanner.nextLine();

        Show[] shows = new Show[500];
        int contador = 0;

        Show.leArquivo();
        List<String> linhas = Show.getCsvLines();

        while(!Show.ehFim(entrada)) {
            int indiceShow = Show.converteStr(entrada);
            if(indiceShow >=0 && indiceShow < linhas.size)
        }
    }


}



