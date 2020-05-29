package modelizacion;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazFrame extends JFrame {

	protected JButton solve;
	JPanel down = new JPanel();

	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Modos");
	JMenuItem option2Personas = new JMenuItem("Modo dos personas");
	JMenuItem optionordenador = new JMenuItem("Reiniciar modo ordenador");

	JTextField turnoTexto = new JTextField();

	public JPanel bridgit = new JPanel();
	public JPanel f[][];
	Container contentPane = getContentPane();

	JButton botonColorAzul[][] = new JButton[11][11];
	private int[][] bridg_it_file;
	int[][] arrayEstrategia = new int[11][11];
	private String[][] bridg_it_file_extra;

	public InterfazFrame(int[][] bridg_it_file, String [][] bridg_it_file_extra) {
		super();
		f = new JPanel[11][11];
		initComponents(bridg_it_file, bridg_it_file_extra);
		this.bridg_it_file = bridg_it_file;
		this.bridg_it_file_extra=bridg_it_file_extra;
	}

	private void initComponents(final int[][] bridg_it_file,final String[][] bridg_it_file_extra) {

		// menubar.add(menu);
		// menu.add(option2Personas);
		// menu.add(optionordenador);

		option2Personas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StartingPuzzle bridg = new StartingPuzzle();
				;

				int[][] bridg_it_file = bridg.getBridgit();
				InterfazFrameDosPersonas interfaz = new InterfazFrameDosPersonas(bridg_it_file);
			}
		});

		optionordenador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StartingPuzzle bridg = new StartingPuzzle();

				int[][] bridg_it_file = bridg.getBridgit();

                String [][] bridg_it_file_extra=bridg.getBridgitEXTRA();
				InterfazFrame interfaz = new InterfazFrame(bridg_it_file,bridg_it_file_extra);
			}
		});

		turnoTexto.setText("�Intenta ganar!");
		turnoTexto.setEditable(false);

		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 11; y++) {
				f[x][y] = new JPanel();
				botonColorAzul[x][y] = new JButton();
				Border border = BorderFactory.createLineBorder(Color.darkGray, 1);
				f[x][y].setBorder(border);
				f[x][y].setFont(f[x][y].getFont().deriveFont(Font.BOLD, 14f));

				bridgit.add(f[x][y]);

				if (bridg_it_file[x][y] == 0 || bridg_it_file[x][y] == 5) {

					final StartingPuzzle starting = new StartingPuzzle();
					starting.setBridgit(bridg_it_file);

					final int x2 = x;
					final int y2 = y;

					f[x][y].setBackground(Color.WHITE);

					botonColorAzul[x][y].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// System.out.print(""+x2);
							f[x2][y2].setBackground(Color.BLUE);

							f[x2][y2].remove(botonColorAzul[x2][y2]);

							int[] coordenadas = estrategiaGanadora(x2, y2);
							


							f[coordenadas[0]][coordenadas[1]].setBackground(Color.RED);
							f[coordenadas[0]][coordenadas[1]].remove(botonColorAzul[coordenadas[0]][coordenadas[1]]);

							bridg_it_file[x2][y2] = 2;

						}
					});

					botonColorAzul[x][y].setBackground(Color.BLUE);

					f[x][y].add(botonColorAzul[x][y]);

				}

				if (bridg_it_file[x][y] == 1) {
					f[x][y].setBackground(Color.RED);
				}

				if (bridg_it_file[x][y] == 2) {
					f[x][y].setBackground(Color.BLUE);
				}

				if (bridg_it_file[x][y] == 3) {
					f[x][y].setBackground(Color.GRAY);
				}

			}
		}

		Border border = BorderFactory.createLineBorder(Color.darkGray, 3);
		bridgit.setLayout(new GridLayout(11, 11));
		bridgit.setBorder(border);

		contentPane.add(bridgit, BorderLayout.CENTER);
		contentPane.add(menubar, BorderLayout.NORTH);
		contentPane.add(turnoTexto, BorderLayout.EAST);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setBackground(Color.darkGray);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}




	public int[] estrategiaGanadora(int x, int y) {

		int[] coordenadas = new int[2];
		
		String click=bridg_it_file_extra[x][y];
		
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				
				String elem=bridg_it_file_extra[i][j];

				
				if(elem.contains(click) && !elem.contains("5")) {	
					if(i!=x && j!=y) {
						coordenadas[0] = i;
						coordenadas[1] = j;
					}					
					
				}else if(elem.contains(click) && elem.contains("5")) {	
					
					if(i!=x || j!=y) {
						coordenadas[0] = i;
						coordenadas[1] = j;
					}
					
				}							
				
			}
		}
		return coordenadas;

	}

}


/**
 * 
	
public void cogerArrayEstrategia() {

for (int x = 10; x != -1; x--) {
	for (int y = 10; y != -1; y--) {				

		arrayEstrategia[10 - x][y] = (x * 10) + y;
	}
}

}

if (bridg_it_file[x][y] == 5 && !movimientoHecho) {

	coordenadas[1] = valor % 10;
	coordenadas[0] = (valor - coordenadas[1]) / 10;
	System.out.println("5:Nuestro coordenada en x es " + coordenadas[0]);
	System.out.println("5:Nuestro coordenada en y es " + coordenadas[1]);

} else if (bridg_it_file[x][y] == 0 && !movimientoHecho) {

	coordenadas[1] = (valor + 1) % 10;
	coordenadas[0] = (valor - coordenadas[1]) / 10;

	System.out.println("0:Nuestro coordenada en x es " + coordenadas[0]);
	System.out.println("0:Nuestro coordenada en y es " + coordenadas[1]);

}

**/



/**
 * //movimiento especial if(bridg_it_file[x][y]==5 && !movimientoHecho) {
  
  try{
 * 
 * //comprobar que (x+2,y) o en (x-2,y) esta vac�o (especial)
 * if((bridg_it_file[x][y+2]==5 || bridg_it_file[x][y+2]==0) &&
 * !movimientoHecho) { //se pone el (x, y+2) en rojo bridg_it_file[x][y+2]=1;
 * coordenadas[0]=x; coordenadas[1]=y+2; movimientoHecho=true; } else
 * if((bridg_it_file[x][y-2]==5 || bridg_it_file[x][y-2]==0) &&
 * !movimientoHecho) { //se pone el (x, y-2) en rojo bridg_it_file[x][y-2]=1;
 * coordenadas[0]=x; coordenadas[1]=y-2; movimientoHecho=true; }
 * }catch(ArrayIndexOutOfBoundsException e) {
 * 
 * if((bridg_it_file[x][y-2]==5 || bridg_it_file[x][y-2]==0) &&
 * !movimientoHecho) { //se pone el (x, y-2) en rojo bridg_it_file[x][y-2]=1;
 * coordenadas[0]=x; coordenadas[1]=y-2; movimientoHecho=true; } } }
 * 
 * //movimiento normal if (bridg_it_file[x][y]==0 && !movimientoHecho) {
 * 
 * try { //comprobar que la casilla que se va a cambiar de color esta vac�a
 * if((bridg_it_file[x+1][y+1]==0 || bridg_it_file[x+1][y+1]==5) &&
 * !movimientoHecho) { //se pone el (x+1, y+1) en rojo
 * bridg_it_file[x+1][y+1]=1; coordenadas[0]=x+1; coordenadas[1]=y+1;
 * movimientoHecho=true;
 * 
 * } else if((bridg_it_file[x-1][y-1]==0 || bridg_it_file[x-1][y-1]==5) &&
 * !movimientoHecho) { //se pone el (x-1, y-1) en rojo
 * bridg_it_file[x-1][y-1]=1; coordenadas[0]=x-1; coordenadas[1]=y-1;
 * movimientoHecho=true; } }catch(ArrayIndexOutOfBoundsException e) {
 * if((bridg_it_file[x-1][y-1]==0 || bridg_it_file[x-1][y-1]==5) &&
 * !movimientoHecho) { //se pone el (x-1, y-1) en rojo
 * bridg_it_file[x-1][y-1]=1; coordenadas[0]=x-1; coordenadas[1]=y-1;
 * movimientoHecho=true; } } }
 * 
 **/

/**
 * 
 * //public int sizesub; //public JPanel p[][]; //p= new
 * JPanel[sizesub][sizesub]; This loop adds to each sub grid a textfield
 * 
 * for (int u = 0; u <= (sizesub-1); u++) { for (int i = 0; i <= (sizesub-1);
 * i++) { for (int x = 0; x <= (sizesub-1); x++) { for (int y = 0; y <=
 * (sizesub-1); y++) { p[u][i].add(f[x + u * (sizesub)][y + i * (sizesub)]); } }
 * sudoku.add(p[u][i]); } }
 **/

//f[x][y].setText(""+bridg_it_file[x][y]);
//f[x][y].setEditable(false);

//protected JToggleButton help;
// protected JButton newPuzzle;

//newPuzzle = new JButton("New Puzzle");
//help = new JToggleButton("Help");

//down.add(help);
//down.add(newPuzzle);
