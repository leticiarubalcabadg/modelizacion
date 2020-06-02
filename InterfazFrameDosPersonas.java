
	package modelizacion;

	import javax.swing.*;
	import javax.swing.border.Border;

	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

public class InterfazFrameDosPersonas extends JFrame{

		
	    JPanel down= new JPanel();
	    
	    JMenuBar menubar= new JMenuBar();
	    JMenu menu= new JMenu("Modos");
	    JMenuItem option2Personas= new JMenuItem("Reiniciar modo dos personas");
	    JMenuItem optionordenador= new JMenuItem("Modo ordenador");
	    
	    JMenu turnoTexto= new JMenu("Es turno del ROJO");
	   


	    public JPanel bridgit=new JPanel();
	    public JPanel f[][];
	    Container contentPane=getContentPane();
	    
	    JButton botonColorRojo[][]=new JButton [11][11];
	    JButton botonColorAzul[][]=new JButton [11][11];


	    public InterfazFrameDosPersonas(int [][] bridg_it_file) {
	        super();
	        f= new JPanel[11][11];
	        initComponents(bridg_it_file);
	    }


	    private void initComponents(final int [][] bridg_it_file) {
	    	
	    	
	        //menubar.add(menu);
	        //menu.add(optionordenador);
	        //menu.add(option2Personas);
	        menubar.add(turnoTexto);
	        
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
	                String [][] bridg_it_file_extra=bridg.getBridgitEXTRA();
	                InterfazFrame interfaz = new InterfazFrame(bridg_it_file,bridg_it_file_extra);
	            }
	        });
	        

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
	                        	f[x2][y2].setBackground(Color.RED);
	                        	bridg_it_file[x2][y2]=1;
	                        	
	                        	f[x2][y2].remove(botonColorRojo[x2][y2]);
	                        	f[x2][y2].remove(botonColorAzul[x2][y2]);	                        	
	                      
	         	    	    	turnoTexto.setText("Es turno del AZUL");
	         	    	    	
	         	    	    	 JPanel panel = new JPanel();
	         	    	    	 JOptionPane.showMessageDialog(panel, "Turno del jugador azul");
	                        }
	                    });
	                    
	                    botonColorAzul[x][y].addActionListener(new ActionListener() {
	                        @Override
	                        public void actionPerformed(ActionEvent e) {
	                        	
	                        	f[x2][y2].setBackground(Color.BLUE);
	                        	bridg_it_file[x2][y2]=2;

	                        	
	                        	f[x2][y2].remove(botonColorAzul[x2][y2]);
	                        	f[x2][y2].remove(botonColorRojo[x2][y2]);

	                        	
		         	    	    	turnoTexto.setText("Es turno del ROJO");

		         	    	    	 JPanel panel = new JPanel();
		         	    	    	 JOptionPane.showMessageDialog(panel, "Turno del jugador rojo");
	                        	 	
	                        }
	                    });
	                    
	                                       
	                    

	                    
	                    botonColorAzul[x][y].setBackground(Color.BLUE);
	                    
	                    f[x][y].add(botonColorAzul[x][y]);  

	                    
	                    botonColorRojo[x][y].setBackground(Color.RED);
	                    
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

	    }	    

