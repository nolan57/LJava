package com.java24hours.classt;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//public class NewKeyViwer extends JFrame implements KeyListener{
public class NewKeyViwer extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JTextField keyText = new JTextField(80);
    JLabel keyLabel = new JLabel("Press any key in the text field.");

    public NewKeyViwer(){
        super("KeyViwer");
        setLookAndFeel();
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //new heare with inner class
        
        keyText.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent keyEvent){
                char key=keyEvent.getKeyChar();
                keyLabel.setText("You pressed "+key);
            }
        }); 

        BorderLayout blo=new BorderLayout();
        setLayout(blo);
        add(keyLabel,BorderLayout.NORTH);
        add(keyText,BorderLayout.CENTER);
        setVisible(true);

    }
    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exception){
            //ingore error
        }
    }

    public void keyTyped(KeyEvent typeEvent){
        //char key=typeEvent.getKeyChar();
        //keyLabel.setText("You pressed "+key);
    }
    public void keyPressed(KeyEvent pressedEvent){
        //do nothing
    }
    public void keyReleased(KeyEvent releasedEvent) {
        //do nothing   
    }

    public static void main(String[] args) {
        //NewKeyViwer keyViwerFrame=new NewKeyViwer();
        new NewKeyViwer();
    }
}