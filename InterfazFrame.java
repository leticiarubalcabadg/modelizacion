package modelizacion;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazFrame extends JFrame{

    protected JButton solve;
    JPanel down= new JPanel();
    
    JMenuBar menubar= new JMenuBar();
    JMenu menu= new JMenu("Modos");
    JMenuItem option2Personas= new JMenuItem("Modo dos personas");
    JMenuItem optionordenador= new JMenuItem("Reiniciar modo ordenador");
    


    public JPanel bridgit=new JPanel();
    public JPanel f[][];
    Container contentPane=getContentPane();
    
    JButton botonColorAzul[][]=new JButton [11][11];
	private int[][] bridg_it_file;


    public InterfazFrame(int [][] bridg_it_file) {
        super();
        f= new JPanel[11][11];
        initComponents(bridg_it_file);
        this.bridg_it_file=bridg_it_file;
    }


    private void initComponents(final int [][] bridg_it_file) {
    	
        menubar.add(menu);
       menu.add(option2Personas);
       menu.add(optionordenador);
       
       option2Personas.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               StartingPuzzle bridg = new StartingPuzzle();;
                
               int [][] bridg_it_file=bridg.getBridgit();
               InterfazFrameDosPersonas interfaz = new InterfazFrameDosPersonas(bridg_it_file);
           }
       });
       
       optionordenador.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               StartingPuzzle bridg = new StartingPuzzle();;
                
               int [][] bridg_it_file=bridg.getBridgit();
               InterfazFrame interfaz = new InterfazFrame(bridg_it_file);
           }
       });
       
        for (int x = 0; x <11; x++) {        	
            for (int y = 0; y < 11; y++) {
                f[x][y] = new JPanel();
                botonColorAzul[x][y] = new JButton();
                Border border = BorderFactory.createLineBorder(Color.darkGray,1);
                f[x][y].setBorder(border);
                f[x][y].setFont(f[x][y].getFont().deriveFont(Font.BOLD, 14f));
                

                
                bridgit.add(f[x][y]);

                if(bridg_it_file[x][y]==0 || bridg_it_file[x][y]==5){
                	
                	final StartingPuzzle starting= new StartingPuzzle();
                	starting.setBridgit(bridg_it_file);
                	
                	final int x2=x;
                	final int y2=y;
                	
                    f[x][y].setBackground(Color.WHITE);
                    
                    
                    
                    botonColorAzul[x][y].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	//System.out.print(""+x2);
                        	f[x2][y2].setBackground(Color.BLUE); 
                        	
                        	f[x2][y2].remove(botonColorAzul[x2][y2]);
                        	
                        	int[] coordenadas = estrategiaGanadora(x2,y2);
                        	
                        	f[coordenadas[0]][coordenadas[1]].setBackground(Color.RED);
                        	f[coordenadas[0]][coordenadas[1]].remove(botonColorAzul[coordenadas[0]][coordenadas[1]]);
                        
                        	bridg_it_file[x2][y2]=2;
                        	 	
                        }
                    });
                    
                   
                    botonColorAzul[x][y].setBackground(Color.BLUE);
                    
                    f[x][y].add(botonColorAzul[x][y]);
                                     
                    
                }
                
                if(bridg_it_file[x][y]==1){        
                    f[x][y].setBackground(Color.RED);
                }
                
                if(bridg_it_file[x][y]==2){
                    f[x][y].setBackground(Color.BLUE);
                }
                
                if(bridg_it_file[x][y]==3){
                    f[x][y].setBackground(Color.GRAY);
                }
                /**
                if(bridg_it_file[x][y]==5){
                    f[x][y].setBackground(Color.ORANGE);
                }**/


            }
        }


        Border border = BorderFactory.createLineBorder(Color.darkGray,3);
        bridgit.setLayout(new GridLayout(11, 11));
        bridgit.setBorder(border);


        solve=new JButton("Submit");

        down.add(solve);
        contentPane.add(bridgit, BorderLayout.CENTER);
        contentPane.add(down,BorderLayout.PAGE_END);
        contentPane.add(menubar, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

  
    	}
		public int[] estrategiaGanadora (int x,int y){
				
				boolean movimientoHecho=false;
				int[] coordenadas= new int[2];
				
				//movimiento especial
				if(bridg_it_file[x][y]==5 && !movimientoHecho) {
					
					try{

					//comprobar que (x+2,y) o en (x-2,y) esta vacío (especial)
					if((bridg_it_file[x][y+2]==5 || bridg_it_file[x][y+2]==0) && !movimientoHecho) {
						
						//se pone el (x, y+2) en rojo
						bridg_it_file[x][y+2]=1;
						coordenadas[0]=x;
						coordenadas[1]=y+2;
						movimientoHecho=true;
					}
					if((bridg_it_file[x][y-2]==5 || bridg_it_file[x][y-2]==0) && !movimientoHecho) {
						//se pone el (x, y-2) en rojo
						bridg_it_file[x][y-2]=1;
						coordenadas[0]=x;
						coordenadas[1]=y-2;
						movimientoHecho=true;
					}
					}catch(ArrayIndexOutOfBoundsException e) {
						
						if((bridg_it_file[x][y-2]==5 || bridg_it_file[x][y-2]==0) && !movimientoHecho) {
							//se pone el (x, y-2) en rojo
							bridg_it_file[x][y-2]=1;
							coordenadas[0]=x;
							coordenadas[1]=y-2;
							movimientoHecho=true;
						}
					}
				}
				
				//movimiento normal
				if (bridg_it_file[x][y]==0 && !movimientoHecho) {
					
					try {
					//comprobar que la casilla que se va a cambiar de color esta vacía
					if((bridg_it_file[x+1][y+1]==0 || bridg_it_file[x+1][y+1]==5) && !movimientoHecho) {
						//se pone el (x+1, y+1) en rojo
						bridg_it_file[x+1][y+1]=1;
						coordenadas[0]=x+1;
						coordenadas[1]=y+1;
						movimientoHecho=true;
						
					}
					if((bridg_it_file[x-1][y-1]==0 || bridg_it_file[x-1][y-1]==5) && !movimientoHecho) {
						//se pone el (x-1, y-1) en rojo
						bridg_it_file[x-1][y-1]=1;
						coordenadas[0]=x-1;
						coordenadas[1]=y-1;
						movimientoHecho=true;
					}
					}catch(ArrayIndexOutOfBoundsException e) {
						if((bridg_it_file[x-1][y-1]==0 || bridg_it_file[x-1][y-1]==5) && !movimientoHecho) {
							//se pone el (x-1, y-1) en rojo
							bridg_it_file[x-1][y-1]=1;
							coordenadas[0]=x-1;
							coordenadas[1]=y-1;
							movimientoHecho=true;
						}
					}
				}
				
				return coordenadas;
			
		    
		    }


    }

    
    

/**
 * 
    //public int sizesub;
    //public JPanel p[][];
    //p= new JPanel[sizesub][sizesub];
 * This loop adds to each sub grid a textfield
 
for (int u = 0; u <= (sizesub-1); u++) {
    for (int i = 0; i <= (sizesub-1); i++) {
        for (int x = 0; x <= (sizesub-1); x++) {
            for (int y = 0; y <= (sizesub-1); y++) {
                p[u][i].add(f[x + u * (sizesub)][y + i * (sizesub)]);
            }
        }
        sudoku.add(p[u][i]);
    }
}
**/


//f[x][y].setText(""+bridg_it_file[x][y]);
//f[x][y].setEditable(false);

//protected JToggleButton help;
 //protected JButton newPuzzle;

//newPuzzle = new JButton("New Puzzle");
//help = new JToggleButton("Help");


//down.add(help);
//down.add(newPuzzle);

