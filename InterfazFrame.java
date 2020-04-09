package modelizacion;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class InterfazFrame extends JFrame{

    protected JButton solve;
    protected JButton menu;
    protected JButton Exit;
    JPanel down= new JPanel();


    public JPanel bridgit=new JPanel();
    public JTextField f[][];
    Container contentPane=getContentPane();


    public InterfazFrame(int [][] bridg_it_file) {
        super();
        f= new JTextField[11][11];
        initComponents(bridg_it_file);
    }


    private void initComponents(int [][] bridg_it_file) {
        for (int x = 0; x <11; x++) {
            for (int y = 0; y < 11; y++) {
                f[x][y] = new JTextField(1);
                Border border = BorderFactory.createLineBorder(Color.darkGray,1);
                f[x][y].setBorder(border);
                f[x][y].setFont(f[x][y].getFont().deriveFont(Font.BOLD, 14f));
                
                bridgit.add(f[x][y]);

                if(bridg_it_file[x][y]!=0){
                    f[x][y].setText(""+bridg_it_file[x][y]);
                    f[x][y].setEditable(false);
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

//protected JToggleButton help;
 //protected JButton newPuzzle;

//newPuzzle = new JButton("New Puzzle");
//help = new JToggleButton("Help");


//down.add(help);
//down.add(newPuzzle);

