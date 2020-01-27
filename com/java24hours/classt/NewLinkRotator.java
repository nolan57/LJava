package com.java24hours.classt;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

//public class NewLinkRotator extends JFrame implements Runnable,ActionListener{
public class NewLinkRotator extends JFrame implements Runnable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String[] pageTitle;
    URI[] pageLink=new URI[3];
    int current=0;
    Thread runner;
    JLabel siteLabel=new JLabel();

    public NewLinkRotator(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        FlowLayout flo=new FlowLayout();
        setLayout(flo);
        add(siteLabel);
        pageTitle=new String[]{
            "Oracle's Java site",
            "Cafe au Lait",
            "JavaWorld"
            //"Sams Publishing",
            //"Workbench"
        };
        pageLink[0]=getURI("http://www.oracle.com/technetwork/java");
        pageLink[1]=getURI("http://wwww.javaworld.com");
        pageLink[2]=getURI("http://java24hours.com");
        //pageLink[4]=getURI("http://wwww.samspublishing.com");
        //pageLink[5]=getURI("http://workbench.cadenhead.org");
        
        Button visitButton=new Button("Visit Site");
        //visitButton.addActionListener(al);
        visitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                Desktop desktop=Desktop.getDesktop();
                if(pageLink[current]!=null){
                    try{
                        desktop.browse(pageLink[current]);
                        runner=null;
                        System.exit(0);
                    }catch(IOException ioException){
                        //donothing
                        System.out.println("open url error!");
                    }
                }                
            }
        });
        add(visitButton);
        setVisible(true);
        start();

    }

    private void start() {
        if(runner==null){
            runner=new Thread(this);
            runner.start();
        }
    }

    private URI getURI(String urlText) {
        URI pageURI=null;
        try{
            pageURI=new URI(urlText);
        }catch(URISyntaxException exception){
            //donothing
        }
        return pageURI;
    }

    ActionListener al=(event)->{
    //public void actionPerformed(ActionEvent e) {
        Desktop desktop=Desktop.getDesktop();
        if(pageLink[current]!=null){
            try{
                desktop.browse(pageLink[current]);
                runner=null;
                System.exit(0);
            }catch(IOException ioException){
                //donothing
                System.out.println("open url error!");
            }
        }

    };

    @Override
    public void run() {
        Thread thisThread=Thread.currentThread();
        while(runner==thisThread){
            current++;
            if(current>2){
                current=0;
            }
            siteLabel.setText(pageTitle[current]);
            repaint();//don't understand yet
            try{
                Thread.sleep(1000);
            }catch(InterruptedException exception){
                //donothing
            }
        }

    }
    public static void main(String[] args) {
        new NewLinkRotator();
    }
}