import java.util.ArrayList;

public class SortOfSorting {
	
	// Compare the first 2 characters of the string only
	// true if a is smaller, false if a is bigger
	public static boolean compareStrings(String a, String b) {
		if ((a.charAt(0) < b.charAt(0)) || (a.charAt(0) == b.charAt(0) && a.charAt(1) <= b.charAt(1))) {
			return true;
		} else {
			return false;
		}
	}

	public static void mergeSort(String[] a, int i, int j) {
		if (i < j) {
			int mid = (i + j) / 2;
			mergeSort(a, i, mid);
			mergeSort(a, mid + 1, j);
			merge(a, i, mid, j);
		}
	}

	public static void merge(String[] a, int i, int mid, int j) {
		String[] temp = new String[j - i + 1];
		int left = i, right = mid + 1, next = 0;

		while (left <= mid && right <=j) {
			if (compareStrings(a[left], a[right])) {
				temp[next++] = a[left++];
			} else {
				temp[next++] = a[right++];
			}
		}

		while (left <= mid) {
			temp[next++] = a[left++];
		}

		while (right <= j) {
			temp[next++] = a[right++];
		}

		for (int k = 0; k < temp.length; k++) {
			a[i + k] = temp[k];
		}
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		ArrayList<String []> list = new ArrayList<>();

		// Read input
		while (io.hasMoreTokens()) {
			int n = io.getInt();

			if (n == 0) {
				break;
			}

			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = io.getWord();
			}
			list.add(arr);
		}

		for (String[] arr : list) {
			mergeSort(arr, 0, arr.length - 1);
			for (int i = 0; i < arr.length; i++) {
				io.println(arr[i]);
			}
			io.println();
		}

		io.flush();
		io.close();
	}
}
