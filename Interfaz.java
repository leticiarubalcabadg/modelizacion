package modelizacion;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interfaz extends InterfazFrame{

    public Interfaz(final int[][] bridg_it_file) {

        super(bridg_it_file);

        /**
         * This loop iterates through all the JTextFields to check user input with DocumentListener.
         
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                final int finalI = i;
                final int finalJ = j;
                f[finalI][finalJ].getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        try {
                            int jml = Integer.parseInt(f[finalI][finalJ].getText());
                            if (jml < 1 || jml > 9) {
                                //JOptionPane.showMessageDialog(null, "You can only input numbers from 1 till 9");
                                //RemoveText();

                            } else {
                            	bridg_it_file[finalI][finalJ] = jml; //first adds the input in the board
                                Bridg_it game = new Bridg_it(bridg_it_file); //then checks if input is valid
                               /**
                                if (!game.isValid()) {
                                	bridg_it_file[finalI][finalJ] = 0; //sets it back to zero if not valid
                                    JOptionPane.showMessageDialog(null, "This is not a correct move");
                                    RemoveText();
                                }
                                


                            }

                            if(jml==1) {

                              	 f[finalI][finalJ].setBackground(Color.BLUE);
                            }

                            if(jml==2) {

                              	 f[finalI][finalJ].setBackground(Color.RED);
                            }
                        } catch (NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, "You can only input numbers not letters.");
                            RemoveText();
                        }

                       
                    }


                    @Override
                    public void removeUpdate(DocumentEvent e) {
                    	bridg_it_file[finalI][finalJ] = 0; //if user deletes input
                    }


                    @Override
                    public void changedUpdate(DocumentEvent e) {                 
                    }


                    /**
                     * Method implementing removing user input from jtextfield if not valid
                     
                    private void RemoveText() {
                        Runnable remove = new Runnable() {
                            @Override
                            public void run() {
                                f[finalI][finalJ].setText("");

                            }
                        };
                        SwingUtilities.invokeLater(remove);
                    }


                });
            }
        }**/
        //Submit button
        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Bridg_it game = new Bridg_it(bridg_it_file);
                boolean hasZero = false;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (bridg_it_file[i][j] == 0) {
                            hasZero = true;
                        }
                    }
                }
                //tenemos q comprobar si todo es correcto con game.isValid()
                if (!hasZero) {
                    JOptionPane.showMessageDialog(null, "Congratulations you beat the game!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all the boxes.");
                }
            }

        });
        
    }



	
	
}
