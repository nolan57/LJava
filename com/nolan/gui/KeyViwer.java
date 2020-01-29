package com.nolan.gui;

import java.awt.event.*;
import javax.swing.*;

//import sun.awt.AWTAccessor.KeyEventAccessor;

import java.awt.*;

import java.awt.*;

public class KeyViwer extends JFrame implements KeyListener{
    JTextField keyText = new JTextField(80);
    JLabel keyLabel = new JLabel("Press any key in the text field.");

    public KeyViwer(){
        super("KeyViwer");
        setLookAndFeel();
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyText.addKeyListener(this);
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
        char key=typeEvent.getKeyChar();
        keyLabel.setText("You pressed "+key);
    }
    public void keyPressed(KeyEvent pressedEvent){
        //do nothing
    }
    public void keyReleased(KeyEvent releasedEvent) {
        //do nothing   
    }

    public static void main(String[] args) {
        KeyViwer keyViwerFrame=new KeyViwer();
    }
}