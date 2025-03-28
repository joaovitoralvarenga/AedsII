

public class string {
    public static void main(String[] args) {
        String entrada = "abcdefgh";

        for(int i = entrada.length() - 1; i>=0;i--) {
            char c = entrada.charAt(i);
            System.out.print(c);
        }
    }
}