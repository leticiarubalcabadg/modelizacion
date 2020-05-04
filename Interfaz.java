package modelizacion;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{

    private JFrame frame;
    private JLabel title;
    private JButton ordenador1;
    private JButton ordenador2;
    private JButton ordenador3;
    private JButton ordenador4;


    /**
     * Constructor for the MainGUI
     */
    public Interfaz() {
        LoadComponents();
    }


    /**
     * Method that loads all the components of the MainGUI and has action listeners for the options.
     *
     */
    private void LoadComponents(){
        frame = new JFrame( "Estrategias posibles");


        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); //opening window in the center
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN.darker());


        title = new JLabel("¡Elige una estrategia!");
        title.setBounds(75,-150, 600,600);


        title.setFont(new Font("Comic Sans MS", Font.BOLD,35));
        title.setForeground(Color.white);


        ordenador1 = new JButton("Estrategia 1");
        ordenador1.setLayout(null);
        ordenador1.setBounds(180,200,225,40);
        ordenador1.setBackground(Color.white);


        ordenador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartingPuzzle bridg = new StartingPuzzle();;
                 
                int [][] bridg_it_file=bridg.getBridgit();
                InterfazFrame interfaz = new InterfazFrame(bridg_it_file);
            }
        });
        
        
        
        ordenador2= new JButton("Estrategia 2");
        ordenador2.setLayout(null);
        ordenador2.setBounds(180,300,225,40);
        ordenador2.setBackground(Color.white);


        ordenador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartingPuzzle bridg = new StartingPuzzle();;
                 
                int [][] bridg_it_file=bridg.getBridgit2();
                InterfazFrame interfaz = new InterfazFrame(bridg_it_file);
            }
        });
        
        
        
        ordenador3= new JButton("Estrategia 3");
        ordenador3.setLayout(null);
        ordenador3.setBounds(180,400,225,40);
        ordenador3.setBackground(Color.white);


        ordenador3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartingPuzzle bridg = new StartingPuzzle();;
                 
                int [][] bridg_it_file=bridg.getBridgit3();
                InterfazFrame interfaz = new InterfazFrame(bridg_it_file);
            }
        });
        
        
        ordenador4= new JButton("Estrategia 4");
        ordenador4.setLayout(null);
        ordenador4.setBounds(180,500,225,40);
        ordenador4.setBackground(Color.white);


        ordenador4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartingPuzzle bridg = new StartingPuzzle();;
                 
                int [][] bridg_it_file=bridg.getBridgit4();
                InterfazFrame interfaz = new InterfazFrame(bridg_it_file);
            }
        });

 
        frame.add(ordenador1);
        frame.add(ordenador2);
        frame.add(ordenador3);
        frame.add(ordenador4);
        frame.add(title);

    }
	
}

