import java.util.Scanner;

public class Combinador  {

	public static String combinaString(String str1, String str2) {
		
		String combinacao = "";
		int tam1 = str1.length();
		int tam2 = str2.length();

		for(int i = 0;i<tam1 && i<tam2;i++) {
				combinacao = combinacao + str1.charAt(i) + str2.charAt(i);
		}




