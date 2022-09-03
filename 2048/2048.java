class Game {

	public int[][] grid = new int[4][4];

	public void transpose() {
		int[][] ans = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				ans[j][i] = this.grid[i][j];
			}
		}
		this.grid = ans;
	}

	public void reverse() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				int temp = this.grid[i][j];
				this.grid[i][j] = this.grid[i][4 - j - 1];
				this.grid[i][4 - j -1] = temp;
			}
		}
	}

	public void left() {
		for (int i = 0; i < 4; i++) {
			int ct = 0, nt = 1, index = 0;
			int[] row = new int[] {0, 0, 0, 0};
			while (true) {
				if (nt >= 4) {
					if (ct < 4) {
						row[index] = this.grid[i][ct];
					}
					break;
				} else if (this.grid[i][ct] == 0) {
					ct++;
					nt++;
				} else if (this.grid[i][nt] == 0){
					nt++;
				} else if (this.grid[i][ct] == this.grid[i][nt]) {
					row[index] = this.grid[i][ct] * 2;
					ct = nt + 1;
					nt = ct + 1;
					index++;
				} else {
					row[index] = this.grid[i][ct];
					ct++;
					nt = ct + 1;
					index++;
				}
			}
			this.grid[i] = row;
		}
	}

	public void up() {
		transpose();
		left();
		transpose();
	}

	public void right() {
		reverse();
		left();
		reverse();
	}

	public void down() {
		transpose();
		reverse();
		left();
		reverse();
		transpose();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j ++) {
				sb = sb.append(this.grid[i][j]);
				if (j < 3) {
					sb = sb.append(" ");
				}
			}
			if (i < 3) {
				sb = sb.append("\n");
			} 
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		Kattio io = null;

		// Try - Finally
		try {
			io = new Kattio(System.in, System.out);

			Game g = new Game();

			// Read Input
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					g.grid[i][j] = io.getInt();
				}
			}

			int move = io.getInt();

			switch (move) {
				case 0:
					g.left();
					break;
				case 1:
					g.up();
					break;
				case 2:
					g.right();
					break;
				case 3:
					g.down();
					break;
			}

			io.println(g.toString());

			io.close();
		} finally {
			if (io != null) {
				io.close();
			}
		}
	}
}
