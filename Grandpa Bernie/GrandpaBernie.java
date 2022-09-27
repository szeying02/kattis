import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class GrandpaBernie {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();

		int n = io.getInt();

		for (int i = 0; i < n; i++) {
			String country = io.getWord();
			int year = io.getInt();

			if (map.get(country) != null) {
				map.get(country).add(year);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(year);
				map.put(country, list);
			}
		}

		int q = io.getInt();
		HashSet<String> sorted = new HashSet<>();

		for (int i = 0; i < q; i++) {
			String country = io.getWord();
			int number = io.getInt();

			ArrayList<Integer> list = map.get(country);
			
			if (!sorted.contains(country)) {
				Collections.sort(list);	
				sorted.add(country);
			}

			io.println(list.get(number - 1));
		}

		io.flush();
		io.close();
	}
}
