package com.java24hours.gui;

import java.awt.*;
import javax.swing.*;

public class FreeSpaceFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public FreeSpaceFrame() {
        super("Disk free space");
        setLookAndFeel();
        setSize(500,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        FreeSpacePanel freeSpacePanel = new FreeSpacePanel();
        add(freeSpacePanel);
        setVisible(true);
    }

    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        }catch(Exception xException){
                //ignore error
        }
    }

    public static void main(String[] args){
        FreeSpaceFrame freeSpaceFrame = new FreeSpaceFrame();
    }
}