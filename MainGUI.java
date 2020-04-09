package modelizacion;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {

    private JFrame frame;
    private JLabel title;
    private JButton classic;


    /**
     * Constructor for the MainGUI
     */
    public MainGUI() {
        LoadComponents();
    }


    /**
     * Method that loads all the components of the MainGUI and has action listeners for the options.
     *
     */
    private void LoadComponents(){
        frame = new JFrame( "Bridg It");


        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); //opening window in the center
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);


        title = new JLabel("Welcome to Bridg It!");
        title.setBounds(75,-150, 600,600);


        title.setFont(new Font("Comic Sans MS", Font.BOLD,45));
        title.setForeground(Color.white);


        classic = new JButton("Start the game");
        classic.setLayout(null);
        classic.setBounds(235,300,125,30);
        classic.setBackground(Color.white);


        classic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartingPuzzle bridg = new StartingPuzzle();;
                 
                int [][] bridg_it_file=bridg.getBridg();
                Interfaz interfaz = new Interfaz(bridg_it_file);
            }
        });

 
        frame.add(classic);
        frame.add(title);

    }
	
}

/**
 * despues de bridg, sirve para seleccionar uno aleatoriamente
 try {
 	bridg = new StartingPuzzle();
 } catch (IOException ex) {
     ex.printStackTrace();
 }

 //assert bridg != null;
 //int [][] bridg_it_file = bridg.getRandomClassicPuzzle(bridg.getClassicPuzzles());
  **/
