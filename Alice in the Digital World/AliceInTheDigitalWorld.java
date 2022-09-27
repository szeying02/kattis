import java.util.LinkedList;

public class AliceInTheDigitalWorld {

	public static long simulation(int[] arr, int m) {
		LinkedList<Integer> window = new LinkedList<Integer>();

		boolean present = false;
		long max = 0;
		long curr = 0;

		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];

			if (j < m) {
				window.clear();
				present = false;
				curr = 0;
			} else {
				window.addLast(j);
				curr += j;

				if (j == m && present) {
					int k = window.removeFirst();
					curr -= k;
					while (k != j) {
						k = window.removeFirst();
						curr -= k;
					}
				}

				if (j == m && !present) {
					present = true;
				}

				if (present) {
					max = curr > max ? curr : max;
				}
			}
		}

		return curr > max && present ? curr : max;
	}
			
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		int datasets = io.getInt();

		for (int i = 0; i < datasets; i++) {
			int n = io.getInt();
			int m = io.getInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				int k = io.getInt();
				arr[j] = k;
			}

			io.println(simulation(arr, m));
		}

		io.flush();
		io.close();
	}
}
