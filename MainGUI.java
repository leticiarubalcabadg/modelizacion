package modelizacion;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{

    private JFrame frame;
    private JLabel title;
    private JButton ordenador;
    private JButton deDosJugadores;


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
        frame.getContentPane().setBackground(Color.CYAN.darker());


        title = new JLabel("!Bienvenidos a Bridg It!");
        title.setBounds(75,-150, 600,600);


        title.setFont(new Font("Comic Sans MS", Font.BOLD,45));
        title.setForeground(Color.white);


        ordenador = new JButton("Jugar contra el ordenador");
        ordenador.setLayout(null);
        ordenador.setBounds(180,300,225,40);
        ordenador.setBackground(Color.white);


        ordenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                Interfaz interfazDos = new Interfaz();
            }
        });
        
        deDosJugadores = new JButton("Jugar contra otro jugador");
        deDosJugadores.setLayout(null);
        deDosJugadores.setBounds(180,400,225,40);
        deDosJugadores.setBackground(Color.white);
        
        
        deDosJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartingPuzzle bridg = new StartingPuzzle();;
                 
                int [][] bridg_it_file=bridg.getBridgit2jugadores();
                InterfazFrameDosPersonas interfaz = new InterfazFrameDosPersonas(bridg_it_file);
            }
        });
        

 
        frame.add(ordenador);
        frame.add(deDosJugadores);
        frame.add(title);

    }
	
}

