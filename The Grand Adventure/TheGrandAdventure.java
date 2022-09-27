import java.util.LinkedList;

public class TheGrandAdventure {
	
	public static void simulate(Kattio io, LinkedList<String> adventures) {
		
		
		while (adventures.size() > 0) {
			String adventure = adventures.removeFirst();
			LinkedList<Character> stack = new LinkedList<>();
			boolean valid = true;

			for (int i = 0; i < adventure.length(); i++) {
				char ch = adventure.charAt(i);
				if (ch == '$' || ch == '*' || ch == '|') {
					stack.push(ch);
				} else if (ch == 't') {
					if (stack.peek() == null || stack.peek() != '|') {
						valid = false;
						io.println("NO");
						break;
					} else {
						stack.pop();
					}
				} else if (ch == 'j') {
					if (stack.peek() == null || stack.peek() != '*') {
						valid = false;
						io.println("NO");
						break;	
					} else {
						stack.pop();	
					}
				} else if (ch == 'b') {
					if (stack.peek() == null || stack.peek() != '$') {
						valid = false;
						io.println("NO");
						break;
					} else {
						stack.pop();	
					}
				}
			}

			if (valid && !stack.isEmpty()){
				io.println("NO");
			} else if (valid) {
				io.println("YES");
			}
		}
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		LinkedList<String> adventures = new LinkedList<>();

		int n = io.getInt();
		
		for (int i = 0; i < n; i++) {
			String str = io.getWord();
			adventures.addLast(str);
		}

		simulate(io, adventures);

		io.flush();
		io.close();
	}
}
