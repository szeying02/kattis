import java.util.TreeMap;
import java.util.Map;

class OpeningCeremony {
	public static void main(String[] args) {
		Kattio io = null;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		// Try - Finally 
		try {
			io = new Kattio(System.in, System.out);

			// Read Input
			int n = io.getInt();
			for (int i = 0; i < n; i++) {
				int j = io.getInt();
				if (map.containsKey(j)) {
					map.put(j, map.get(j) + 1);
				} else {
					map.put(j, 1);
				}
			}

			// Total number of towers affected by horizontal cuts, accumulated
			int h = 0;
			int ans = n;

			for (Map.Entry<Integer, Integer> e : map.entrySet()) {
				int k = e.getKey();
				int v = e.getValue();
				h += v;
				int cuts = n - h + k;
				ans = cuts < ans ? cuts : ans;
			}

			io.println(ans);
			io.close();
		} finally {
			if (io != null) {
				io.close();
			}
		}
	}
}
