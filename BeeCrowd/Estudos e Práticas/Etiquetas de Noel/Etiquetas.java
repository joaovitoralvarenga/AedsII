import java.util.Scanner;


public class Etiquetas {

    public void organizaEtiqutas(String str) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextLine();


        
        String idiomas[] = new String[n];
        String saudacao[] = new String[n];

        for(int i =0;i<n;i++) {

            saudacao[i] = scanner.nextLine();
            idiomas[i] = scanner.nextLine();
        }
    }


