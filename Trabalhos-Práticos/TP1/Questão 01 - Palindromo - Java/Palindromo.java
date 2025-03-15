public class Palindromo {
    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String string = MyIO.readLine();

        while (!(ehFIM(string))) {
            boolean ehPalindromo = true;
            int contador = string.length();

            for (int i = 0; i < contador / 2; i++) {
                if (string.charAt(i) != string.charAt(contador - i - 1)) {
                    ehPalindromo = false;
                   
                }
            }

            if(ehPalindromo) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }

            string = MyIO.readLine();
        }

       
    }

     public static boolean ehFIM(String string) {
        boolean isFim = false;
        
        if (string.length() == 3) {
            if (string.charAt(0) == 'F' && string.charAt(1) == 'I' && string.charAt(2) == 'M') {
                isFim = true;
            }
        }
        
        return isFim;
    }
}
