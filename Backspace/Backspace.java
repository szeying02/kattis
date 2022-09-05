import java.util.LinkedList;

class Backspace {
	public static String simulation(String str) {
		LinkedList<Character> ll = new LinkedList<Character>();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (c == '<') {
				ll.pop();
			} else {
				ll.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (ll.size() != 0) {
			sb = sb.append(ll.removeLast());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		String word = io.getWord();
		String ans = simulation(word);
		io.println(ans);
		io.close();
	}
}
