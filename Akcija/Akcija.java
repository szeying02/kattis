import java.util.Arrays;

class Akcija {

	public static int[] reverseArr(int[] arr) {
		for (int i = 0; i < arr.length / 2; i ++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		Kattio io = null;

		// Try - Finally
		try {
			io = new Kattio(System.in, System.out);

			// Read Input
			int n = io.getInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				int j = io.getInt();
				arr[i] = j;
			}

			Arrays.sort(arr);
			arr = reverseArr(arr);

			int cost = 0;
			int grp = n / 3;
			int last = 3 * grp;

			for (int i = 0; i < grp; i++) {
				cost += arr[i * 3];
				cost += arr[i * 3 + 1];
			}

			for (int i = last; i < arr.length; i++) {
				cost += arr[i];
			}

			io.println(cost);

			io.close();
		} finally {
			if (io != null) {
				io.close();
			}
		}
	}
}
