package com.nolan.gui;

import javax.swing.*;
import java.awt.event.*;

public class LottoEvent implements ActionListener,
                                    ItemListener,
                                    Runnable{

    LottoMadness gui;
    Thread playing;

    public LottoEvent(LottoMadness gui){
        this.gui=gui;
    }

    //implement interface ActionListener method
    public void actionPerformed(ActionEvent actionEvent) {
    
    }

    private void startPlaying() {
        playing=new Thread(this);
        playing.start();
        
    }
    private void stopPlaying() {
        playing=null;

    }
    private void clearAllField() {
        
    }

    //implement interface ItemListener method
    public void itemStateChanged(ItemEvent itemEvent) {
    
    }

    //next three methods will be call in method run
    private void addOneToField(JTextField textField){

    }
    private boolean numberGone(int num,JTextField[] pastNume,int count) {
        return false;
    }    
    private boolean matcheOne(JTextField win,JTextField[] allPicks) {
        return false;
    }
    //implement interface Runnable method
    public void run(){
        //+numberGone(int num,JTextField[] pastNume,int count)
        //+addOneToField(JTextField textField)
        //+matcheOne(JTextField win,JTextField[] allPicks)
        try{
            //gui→sleep-time
            //Thread.sleep(sleep-time)
            Thread.sleep(5000);
        }catch(InterruptedException exception){

        }

    }

}