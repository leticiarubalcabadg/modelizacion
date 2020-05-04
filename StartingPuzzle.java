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

	public static int[][] getBridgit2() {
		return bridgit2;
	}

	public static void setBridgit2(int[][] bridgit2) {
		StartingPuzzle.bridgit2 = bridgit2;
	}

	public static int[][] getBridgit3() {
		return bridgit3;
	}

	public static void setBridgit3(int[][] bridgit3) {
		StartingPuzzle.bridgit3 = bridgit3;
	}

	public static int[][] getBridgit4() {
		return bridgit4;
	}

	public static void setBridgit4(int[][] bridgit4) {
		StartingPuzzle.bridgit4 = bridgit4;
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
	
	
	static int[][] bridgit2 ={

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            {2, 0, 2, 0, 2, 0,2,5,2,5,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 5,2,5,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 5, 2, 5,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 1, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 5, 2, 5, 2, 0,2,0,2,0,2},

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            };
	
	
	
	static int[][] bridgit3 ={

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            {2, 0, 2, 0, 2, 0,2,5,2,5,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 5,2,5,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 1, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 5, 2, 5,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 5, 2, 5, 2, 0,2,0,2,0,2},

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            };
	
	
	static int[][] bridgit4 ={

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            {2, 0, 2, 0, 2, 0,2,5,2,5,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 5,2,5,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 5, 2, 5,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 5, 2, 5, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 1, 2, 0,2,0,2,0,2},

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            };
	
	
	
	
	static int[][] bridgit2jugadores ={

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            {2, 0, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 0, 1, 0, 1,0,1,0,1,3},

            {2, 0, 2, 0, 2, 0,2,0,2,0,2},

            {3, 1, 3, 1, 3, 1,3,1,3,1,3},

            };
	
		
	
    public static int[][] getBridgit2jugadores() {
		return bridgit2jugadores;
	}

	public static void setBridgit2jugadores(int[][] bridgit2jugadores) {
		StartingPuzzle.bridgit2jugadores = bridgit2jugadores;
	}

	
	public void setColor(int x2, int y2, int color) {
		for (int x = 0; x <= 11; x++) {
			for (int y = 0; y <= 11; y++) {
				if (x == x2 && y == y2)
					bridgit[x][y] = color;
			}
		}
	}

}
