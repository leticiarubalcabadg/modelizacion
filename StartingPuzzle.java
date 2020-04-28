package modelizacion;

public class StartingPuzzle {

	//ocupada rojo->1
	//ocupada azul->2
	//prohibida->3
	//libre->0
	//especial ->5

	public int[][] getBridgit() {
		return bridgit;
	}

	public void setBridgit(int[][] bridgit) {
		StartingPuzzle.bridgit = bridgit;
	}

	static int[][] bridgit ={

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            {2, 0, 2, 0, 2, 0,2,5,2,5,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 5,2,5,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 5, 2, 5,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 5, 2, 5, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 1, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            };
	
	
	
	
    public void setColor(int x2, int y2, int color) {
		for (int x = 0; x <= 11; x++) {
			for (int y = 0; y <= 11; y++) {
				if (x == x2 && y == y2)
					bridgit[x][y] = color;
			}
		}
	}

}
