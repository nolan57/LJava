package com.nolan.classt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton red, green, blue;
    public ColorFrame(){
        super("Color Frame");
        setLookAndFeel();
        setSize(330,130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo=new FlowLayout();
        setLayout(flo);

        red=new JButton("Red");
        green=new JButton("Green");
        blue=new JButton("Blue");
        add(red);
        add(green);
        add(blue);

        ActionListener actionListener=new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(event.getSource()==red){
                    getContentPane().setBackground(Color.RED);
                }
                if(event.getSource()==green){
                    getContentPane().setBackground(Color.GREEN);
                }
                if(event.getSource()==blue){
                    getContentPane().setBackground(Color.BLUE);
                }
            }
        };

        ActionListener al=(event)->{
            if(event.getSource()==red){
                getContentPane().setBackground(Color.RED);
            }
            if(event.getSource()==green){
                getContentPane().setBackground(Color.GREEN);
            }
            if(event.getSource()==blue){
                getContentPane().setBackground(Color.BLUE);
            }
        };

        //red.addActionListener(actionListener);
        //green.addActionListener(actionListener);
        //blue.addActionListener(actionListener);
        red.addActionListener(al);
        green.addActionListener(al);
        blue.addActionListener(al);

        setVisible(true);
    }

    private void setLookAndFeel() {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exception){
            //donothing
        }
    }
    public static void main(String[] args) {
        new ColorFrame();
    }
}