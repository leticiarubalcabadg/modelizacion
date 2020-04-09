package modelizacion;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazFrame extends JFrame{

    protected JButton solve;
    JPanel down= new JPanel();


    public JPanel bridgit=new JPanel();
    public JPanel f[][];
    Container contentPane=getContentPane();
    
    JButton botonColorRojo[][]=new JButton [11][11];
    JButton botonColorAzul[][]=new JButton [11][11];


    public InterfazFrame(int [][] bridg_it_file) {
        super();
        f= new JPanel[11][11];
        initComponents(bridg_it_file);
    }


    private void initComponents(final int [][] bridg_it_file) {
    	
        for (int x = 0; x <11; x++) {        	
            for (int y = 0; y < 11; y++) {
                f[x][y] = new JPanel();
                botonColorRojo[x][y] = new JButton();
                botonColorAzul[x][y] = new JButton();
                Border border = BorderFactory.createLineBorder(Color.darkGray,1);
                f[x][y].setBorder(border);
                f[x][y].setFont(f[x][y].getFont().deriveFont(Font.BOLD, 14f));
                

                
                
                bridgit.add(f[x][y]);

                if(bridg_it_file[x][y]==0){
                	
                	final StartingPuzzle starting= new StartingPuzzle();
                	starting.setBridgit(bridg_it_file);
                	
                	final int x2=x;
                	final int y2=y;
                	
                    f[x][y].setBackground(Color.WHITE);
                    
                    botonColorRojo[x][y].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	//System.out.print(""+x2);
                        	f[x2][y2].setBackground(Color.RED);
                        	bridg_it_file[x2][y2]=1;
                        	
                        	f[x2][y2].remove(botonColorAzul[x2][y2]);
                        	f[x2][y2].remove(botonColorRojo[x2][y2]);
                        	
                            for (int x = 0; x < 11; x++) {
                    			for (int y = 0; y <11; y++) {
                    				System.out.print(bridg_it_file[x][y]);
                    			}
                    			System.out.println();
                    		}
                            
                        }
                    });
                    
                    
                    botonColorAzul[x][y].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	//System.out.print(""+x2);
                        	f[x2][y2].setBackground(Color.BLUE);
                        	bridg_it_file[x2][y2]=2;
                        	
                        	f[x2][y2].remove(botonColorAzul[x2][y2]);
                        	f[x2][y2].remove(botonColorRojo[x2][y2]);
                        	 	
                        }
                    });
                    
                    botonColorRojo[x][y].setBackground(Color.RED);
                    botonColorAzul[x][y].setBackground(Color.BLUE);
                    
                    f[x][y].add(botonColorAzul[x][y]);
                    f[x][y].add(botonColorRojo[x][y]);                  
                    
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


            }
        }


        Border border = BorderFactory.createLineBorder(Color.darkGray,3);
        bridgit.setLayout(new GridLayout(11, 11));
        bridgit.setBorder(border);


        solve=new JButton("Submit");

        down.add(solve);
        contentPane.add(bridgit, BorderLayout.CENTER);
        contentPane.add(down,BorderLayout.PAGE_END);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

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

