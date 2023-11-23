package it.unibo.mvc;

import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My First Java GUI");

    private SimpleGUI(final Controller controller){

        // creazione oggetti e dichiarazione 
        final JTextArea text = new JTextArea();
        final LayoutManager layout = new BorderLayout();
        final JPanel panel1 = new JPanel();
        panel1.setLayout(layout);

        //gestione buttone save
        final JButton save = new JButton("save");

        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.save(text.getText());
                }catch(IOException e1){
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);

                }  
            }
            
        });

        panel1.add(text,BorderLayout.CENTER);
        panel1.add(save,BorderLayout.SOUTH);

        frame.setContentPane(panel1);

        frame.setDefaultCloseOperation(0);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
    }

    private void display() {
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param a
     *            unused
     */
    public static void main(final String... a) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }






}
