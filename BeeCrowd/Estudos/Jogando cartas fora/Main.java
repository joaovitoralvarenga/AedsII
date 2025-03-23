import java.util.*;


public class Main {

	public static void manejaBaralho(int n) {

		Queue<Integer> fila = new LinkedList<>();

		for(int i= 1; i<= n;i++) {
			fila.add(i);
		}

		StringBuilder descartados = new StringBuilder();
		System.out.print("Discarded cards: ");
		boolean primeiro = true;

		while(fila.size() > 1) {
			int cartaDescartada = fila.poll();
			if(primeiro) {
				descartados.append(cartaDescartada);
				primeiro  = false;
			} else {
				descartados.append(", ").append(cartaDescartada);
			}

			fila.add(fila.poll());
		}

		System.out.println(descartados);
		System.out.println("Remaining card: " +fila.peek());
			
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n != 0) {
            manejaBaralho(n);
            n = scanner.nextInt();
        }

        scanner.close();
	}
}






