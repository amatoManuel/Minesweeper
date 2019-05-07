package Minesweeper;


public class Grid {
	public int[][] grid;
	public int[][] bomb;
	
	public Grid(){
		grid = new int[9][9];
	}
	
	public void checkGrid(){
		int x,y;
		for (int[] ints : this.bomb) {
			x = ints[0];
			y = ints[1];
			if (x - 1 >= 0)
				this.grid[x - 1][y]++;
			if (x - 1 >= 0 && y - 1 >= 0)
				this.grid[x - 1][y - 1]++;
			if (y - 1 >= 0)
				this.grid[x][y - 1]++;
			if (x - 1 >= 0 && y + 1 < this.grid.length)
				this.grid[x - 1][y + 1]++;
			if (x + 1 < this.grid.length)
				this.grid[x + 1][y]++;
			if (y + 1 < this.grid.length && x + 1 < this.grid.length)
				this.grid[x + 1][y + 1]++;
			if (y + 1 < this.grid.length)
				this.grid[x][y + 1]++;
			if (x + 1 < this.grid.length && y-1>=0)
				this.grid[x + 1][y - 1]++;
		}
		for (int[] ints : this.bomb) {
			x = ints[0];
			y = ints[1];
			this.grid[x][y] = -1;
		}
			
	}
	
	public void insertBombAt(int i,int x, int y) throws Exception {
		if(x<this.grid.length && y<this.grid.length && x>=0 && y>=0){
			for(int j=0;j<i;j++) {
				if (x == this.bomb[j][0] && y == this.bomb[j][1])
					throw new Exception("Hai inserito una coordinata già esistente");
			}
			this.bomb[i][0] = x;
			this.bomb[i][1] = y;
			this.grid[x][y] = -1;
			}
		else
			throw new Exception("Hai inserito delle coordinate fuori dalla griglia");
	}

	
	public void setBomb(int size) throws Exception {
		if(size==0)
			throw new Exception("Errore! Hai inserito 0 bombe");
		else if(size>=this.grid.length*this.grid.length)
			throw new Exception("Hai inserito troppe bombe");
		else if(size<=this.grid.length*this.grid.length)
			this.bomb= new int[size][2];
		for(int i=0;i<size;i++)
			for(int j=0;j<2;j++)
			this.bomb[i][j]=-1;
	}

	public int clickAt(int x, int y){
		return this.grid[x][y];
	}

	@Override
	public String toString() {
		String s="";
		for(int i=this.grid.length-1;i>=0;i--) {
			for (int j = 0; j < this.grid[i].length; j++)
				if(j<this.grid[i].length-1) s +=" "+ this.grid[j][i]+" |";
				else s+=" "+this.grid[j][i];


			if(i<this.grid[i].length) s += "\n-----------------------------------\n";
		}
		return s;
	}
}
