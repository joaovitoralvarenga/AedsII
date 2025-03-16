import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Html {
    
    public static String lePaginaHtml(String endereco) {
        URL url;
        InputStream entrada;
        BufferedReader leitor;
        String resposta = "", linha;

        try {
            url = new URI(endereco).toURL();
            entrada = url.openStream();
            leitor = new BufferedReader (new InputStreamReader(entrada));

            while((linha = leitor.readLine()) != null) {
                resposta += linha + "\n";
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return resposta;
    }

    public static int[] contaLetras(String conteudo, char[] letras) {
       int[] contagem = new int[letras.length];
        
        for(int i = 0;i<conteudo.length();i++) {
            for(int j=0;j<letras.length; j++) {
                if(conteudo.charAt(i) == letras[j]) {
                    contagem[j]++;
                }
            }
        }
        return contagem;
    }

    public static int[] contaPalavras(String conteudo, String[] palavras) {

        int[] contagemPalavras = new int[palavras.length];

        for(int i=0;i<palavras.length; i++) {
            for(int j = 0;j<conteudo.length();j++) {
                if (conteudo.charAt(j) == palavras[i].charAt(0) && j + palavras[i].length() < conteudo.length()) {
                    int tamanho = palavras[i].length();
                    boolean palavraCerta = true;

                    for(int k = 0;k<tamanho;k++) {
                        if (palavras[i].charAt(k) != conteudo.charAt(j + k)) {
                            palavraCerta = false;
                    }
            }
            if(palavraCerta) {
                contagemPalavras[i]++;
            }
        }
    }
}
return contagemPalavras;
    }

    public static void contaElementos(String endereco, String texto) {
        String conteudoPagina = lePaginaHtml(endereco);

        char[] vogais = { 'a', 'e', 'i', 'o', 'u', '\u00E1', '\u00E9', '\u00ED', '\u00F3', '\u00FA', '\u00E0', '\u00E8', '\u00EC', '\u00F2', '\u00F9', '\u00E3', '\u00F5', '\u00E2', '\u00EA', '\u00EE', '\u00F4', '\u00FB' };
        char[] consoantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
         String[] tags = {"<br>", "<table>"};


         int[]contagemVogais = contaLetras(conteudoPagina, vogais);
         int[]contagemConsoantes = contaLetras(conteudoPagina, consoantes);
         int totalConsoantes = 0;

         int[]contagemTags = contaPalavras(conteudoPagina, tags);
         contagemVogais[0] -= (1 * contagemTags[1]);
         contagemVogais[1] -= (1 * contagemTags[1]);
         totalConsoantes -= (3 * contagemTags[1]);
         totalConsoantes -= (2 * contagemTags[0]);
     
         for(int i=0;i<vogais.length;i++) {
            System.out.print(vogais[i] + "(" + contagemVogais[i] + ") ");
         }

         for(int i=0;i<contagemConsoantes.length;i++) {
            totalConsoantes += contagemConsoantes[i];
         }

         System.out.print("consoante(" + totalConsoantes + ") ");

         for(int i=0;i<contagemTags.length;i++) {
            System.out.print(tags[i] + "(" + contagemTags[i] + ") " );
         }

         System.out.println(texto);;
    }

    public static boolean ehFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        String endereco;;

        while(!ehFim(entrada) ) {

            endereco = scanner.nextLine();
            contaElementos(endereco, entrada);

            entrada = scanner.nextLine();

        }

        scanner.close();

    }
}

    