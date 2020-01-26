package com.java24hours.awtc;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class SalutonFrame extends JFrame{

    public SalutonFrame(){
        super("Saluton mondo!");
        setLookAndFeel();
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo=new FlowLayout();
        BorderLayout blo = new BorderLayout();

        setLayout(flo);
        //Border blackline=BorderFactory.createLineBorder(Color.GRAY);
        JPanel buttonPanel=new JPanel();
        buttonPanel.setLayout(flo);
        //buttonPanel.setBorder(blackline);
        JPanel optionPanel=new JPanel();
        optionPanel.setLayout(blo);

        JButton play = new JButton("Play");
        JButton stop = new JButton("Stop");
        JButton pause = new JButton("Pause");
        //Border buttonBorder=BorderFactory.createRaisedBevelBorder();
        //play.setBorder(buttonBorder);
        //stop.setBorder(buttonBorder);
        //pause.setBorder(buttonBorder);
        buttonPanel.add(play);
        buttonPanel.add(stop);
        buttonPanel.add(pause);
        add(buttonPanel);

        JCheckBox usCheck=new JCheckBox("Unite States",true);
        JCheckBox cnCheck=new JCheckBox("CHina",false);
        JCheckBox ukCheck=new JCheckBox("Unite Kingdom",false);
        ButtonGroup cuntries=new ButtonGroup();
        cuntries.add(usCheck);
        cuntries.add(cnCheck);
        //cuntries.add(ukCheck);
        optionPanel.add(usCheck,BorderLayout.WEST);
        optionPanel.add(cnCheck,BorderLayout.CENTER);
        optionPanel.add(ukCheck,BorderLayout.EAST);
        //add(optionPanel,BorderLayout.WEST);

        JComboBox<String> profession=new JComboBox<String>();
        profession.addItem("Butcher");
        profession.addItem("Baker");
        profession.addItem("Candlestick");
        profession.addItem("Fletcher");
        profession.addItem("Fighter");
        profession.addItem("Technical");
        profession.setEditable(false);
        optionPanel.add(profession,BorderLayout.SOUTH);
        add(optionPanel);

        JPanel otherPanel = new JPanel();
        otherPanel.setLayout(flo);
        JTextArea comments=new JTextArea(10,5);
        comments.setLineWrap(true);
        comments.setWrapStyleWord(true);
        JScrollPane scroll=new JScrollPane(comments,
                                            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        otherPanel.add(scroll);

        FreeSpacePanel freeSpacePanel = new FreeSpacePanel();
        otherPanel.add(freeSpacePanel);
        add(otherPanel);

        setVisible(true);
    }
    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exc){
            //ignore error
        }
    }
    public static void main(String[] args){
        SalutonFrame framec=new SalutonFrame();
    }
}