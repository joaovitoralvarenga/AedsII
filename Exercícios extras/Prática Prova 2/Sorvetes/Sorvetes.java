import java.util.*;

public class Sorvetes {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numTeste = 1;

		int p = scanner.nextInt();
		int s = scanner.nextInt();

		while(p != 0 || s != 0) {

			List<int[]> intervalos = new ArrayList<>();

			for(int i=0;i<s;i++) {

				int u = scanner.nextInt();
				int v = scanner.nextInt();

				intervalos.add(new int[] {Math.min(u, v), Math.max(u, v)});
			}

			for(int i=1;i<intervalos.size();i++) {
				int[] chave = intervalos.get(i);
				int j = i - 1;

				while(j >=0 && intervalos.get(j)[0] > chave[0]) {
					intervalos.set(j + 1, intervalos.get(j));
					j--;
				}

				intervalos.set(j+ 1, chave);
			}

			List<int[]> resultado = new ArrayList<>();

			if(!intervalos.isEmpty()) {
				resultado.add(intervalos.get(0));

				for(int i = 1;i< intervalos.size();i++) {
					int[] atual = intervalos.get(i);
					int[] ult = resultado.get(resultado.size() - 1);

					if(atual[0] > ult[1]) {
						resultado.add(atual);
					}

					else {
						ult[1] = Math.max(ult[1], atual[1]);
					}
				}
			}

			System.out.println("Teste " + numTeste);
			for(int[] intervalo : resultado) {
				System.out.println(intervalo[0] + " " + intervalo[1]);
			}

			

			numTeste++;
			p = scanner.nextInt();
            s = scanner.nextInt();



		}

		scanner.close();


	}

}


 