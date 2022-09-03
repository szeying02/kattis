class Mjehuric {

	public static void bubbleSort(int[] arr, Kattio io) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j+ 1] = temp;
					io.println(stringify(arr).trim());
				}
			}
		}
	}

	public static String stringify(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb = sb.append(arr[i]);
			sb = sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Kattio io = null;

		// Try-Finally
		try {
			io = new Kattio(System.in, System.out);
			int[] arr = new int[5];

			// Read Input
			for (int i = 0; i < 5; i++) {
				int j = io.getInt();
				arr[i] = j;
			}

			// Bubble Sort
			bubbleSort(arr, io);


			io.close();
		} finally {
			if (io != null) {
				io.close();
			}
		}
	}
}
