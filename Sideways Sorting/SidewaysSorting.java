import java.util.ArrayList;

public class SidewaysSorting {

	public static int compareLowerCase(String a, String b) {
		String a2 = a.toLowerCase();
		String b2 = b.toLowerCase();
		return a2.compareTo(b2);
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
			if (compareLowerCase(a[left], a[right]) <= 0) {
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
		ArrayList<char[][]> list = new ArrayList<>();
		ArrayList<String[]> slist = new ArrayList<>();

		while (io.hasMoreTokens()) {
			int r = io.getInt();
			int c = io.getInt();

			if (r == 0 & c == 0) {
				break;
			}

			char[][] arr = new char[c][r];
			
			for (int i = 0; i < r; i++) {
				String w = io.getWord();
				for (int j = 0; j < c; j++) {
					char ch = w.charAt(j);
					arr[j][i] = ch;
				}
				//io.println(arr[i]);
			}	
			list.add(arr);
		}
		for (int k = 0; k < list.size(); k++) {
			char[][] arr = list.get(k);
			int c = arr.length;
			int r = arr[0].length;
			String[] a = new String[c];

			for (int i = 0; i < c; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < r; j++) {
					sb = sb.append(arr[i][j]);
				}
				a[i] = sb.toString();
			}
			slist.add(a);
		}

		//io.println(slist.get(0));

		for (int i = 0; i < slist.size(); i++) {
			String[] arr = slist.get(i);
			mergeSort(arr, 0, arr.length - 1);
			StringBuilder[] a = new StringBuilder[arr[0].length()];
			for (int j = 0; j < a.length; j++) {
				a[j] = new StringBuilder();
			}

			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[0].length(); k++) {
					a[k] = a[k].append(arr[j].charAt(k));
				}
			}

			for (int j =0; j < a.length; j++) {
				io.println(a[j].toString());
			}
			io.println();
		}	

		/*for (int i = 0; i < list.size(); i++) {
			char[][] cs = list.get(i);
			for (int j = 0; j < cs.length; j++) {
				mergeSort(cs[j], 0, cs[j].length - 1);
				io.println(cs[j]);
			}
			for (int j = 0; j < cs.length; j++) {
				io.print(cs[j]);
			}
		}*/

		io.flush();
		io.close();
	}
}
