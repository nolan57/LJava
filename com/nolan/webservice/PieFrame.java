package com.nolan.webservice;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;

public class PieFrame extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    int sliceNumber=0;
    ArrayList<PiePanel.PieSlice> slices;
    PiePanel piePanel;
    Thread paintThread;

    private void defaultSlice(PiePanel piePanel){
        for(int idx=0;idx<sliceNumber;idx++){
            int red=(int)(Math.random()*255);
            int green=(int)(Math.random()*255);
            int blue=(int)(Math.random()*255);
            float sliceSizes=(float)(Math.random()*100);
            slices.add(piePanel.new PieSlice(new Color(red,green,blue), sliceSizes));
        }
    }
    
    public void star(){
        if(paintThread==null){
            paintThread=new Thread(piePanel);
            paintThread.start();
            repaint();
        }
    }

    public PieFrame(int sliceNumber)throws Exception{
        super("Pie Slices");
        setLookAndFeel();
        setBackground(Color.GRAY);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        slices=new ArrayList<PiePanel.PieSlice>();
        //System.out.println(Math.pow(2,2));

        if(sliceNumber==0){
            throw new Exception("Error,no data to draw");
        }
        this.sliceNumber=sliceNumber;

        piePanel=new PiePanel();
        defaultSlice(piePanel);
        for (PiePanel.PieSlice pieSlice : slices) {
            piePanel.addPieSlice(pieSlice.sliceColor, pieSlice.size);
        }
        add(piePanel);
        /*
        if(paintThread==null){
            paintThread=new Thread(piePanel);
            paintThread.start();
            repaint();
        } */
    }
    public PieFrame(){
        super("Pie Slices");
        setLookAndFeel();
        setBackground(Color.GRAY);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        slices=new ArrayList<PiePanel.PieSlice>();  
        piePanel=new PiePanel();
        SetSlices setSlices=new SetSlices(piePanel);
        add(setSlices.getPiePanel());
        if(paintThread==null){
            paintThread=new Thread(this.piePanel);
            paintThread.start();
            repaint();
        }
    }

    private void setLookAndFeel() {
        try{
            UIManager.setLookAndFeel("com.sun.java.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exception){
            //donothing
        }
    }
    private class SetSlices{

        PiePanel piePanel;
        BufferedInputStream bin;

        public PiePanel getPiePanel(){
            return this.piePanel;
        }
        public PiePanel.PieSlice setSlice(PiePanel piePanel,int red,int green,int blue,float sliceSizes){
            PiePanel.PieSlice pp= piePanel.new PieSlice(new Color(red,green,blue), sliceSizes);
            slices.add(pp);
            return pp;
        }
        public String readConsoleIn() {
            StringBuilder stringBuilder=new StringBuilder();
            try{
                bin=new BufferedInputStream(System.in);
                int in=0;
                char inChar;
                do{
                    in=bin.read();
                    inChar=(char)in;
                    if((in!=-1)&(in!='\n')){
                        stringBuilder.append(inChar);
                    }
                }while((in!=-1)&(in!='\n'));
                //bin.close();
                return stringBuilder.toString();
            }catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
                return null;
            }
            
        }
        public SetSlices(PiePanel piePanel){
            boolean again=false;
            int red=0;
            int green=0;
            int blue=0;
            float size=0;
            this.piePanel=piePanel;
            do{
                System.out.print("Please set the slices number(should be a integer):");
                String snString=readConsoleIn();
                try{
                    sliceNumber=Integer.parseInt(snString);
                }catch(NumberFormatException nFormatException){
                    System.out.println("Not a int!");
                    again=true;
                }
                if(!(again)&(sliceNumber<=0)){
                    System.out.println("Not >0");
                    again=true;
                }
            }while(again);

            System.out.println("Now you should set "+sliceNumber+"slices data");
            for(int idx=0;idx<sliceNumber;idx++){
                again=false;
                /*do{
                    System.out.print("Please set the slice "+idx+" red number(should be a integer):");
                    String inString=readConsoleIn();
                    try{
                        red=Integer.parseInt(inString);
                    }catch(NumberFormatException nFormatException){
                        System.out.println("Not a int!");
                        again=true;
                    }
                    if(!(again)&((red<=0)||(red>255))){
                        System.out.println("Not >0 & <255");
                        again=true;
                    }
                }while(again);

                again=false;
                do{
                    System.out.print("Please set the slice "+idx+" green number(should be a integer):");
                    String inString=readConsoleIn();
                    try{
                        green=Integer.parseInt(inString);
                    }catch(NumberFormatException nFormatException){
                        System.out.println("Not a int!");
                        again=true;
                    }
                    if(!(again)&((green<=0)||(green>255))){
                        System.out.println("Not >0 & <255");
                        again=true;
                    }
                }while(again);
                again=false;
                do{
                    System.out.print("Please set the slice "+idx+" blue number(should be a integer):");
                    String inString=readConsoleIn();
                    try{
                        blue=Integer.parseInt(inString);
                    }catch(NumberFormatException nFormatException){
                        System.out.println("Not a int!");
                        again=true;
                    }
                    if(!(again)&((blue<=0)||(blue>255))){
                        System.out.println("Not >0 & <255");
                        again=true;
                    }
                }while(again);
                again=false;*/
                do{
                    System.out.print("Please set the slice "+idx+" size number(should be a float):");
                    String inString=readConsoleIn();
                    try{
                        size=Float.parseFloat(inString);
                    }catch(NumberFormatException nFormatException){
                        System.out.println("Not a int!");
                        again=true;
                    }
                    if(!(again)&(size<=0F)){
                        System.out.println("Not >0");
                        again=true;
                    }
                }while(again);
                red=(int)(Math.random()*255);
                green=(int)(Math.random()*255);
                blue=(int)(Math.random()*255);    
                try{
                        PiePanel.PieSlice pp=this.setSlice(piePanel, red, green, blue, size);
                        this.piePanel.addPieSlice(pp.sliceColor,pp.size);
                }catch(NullPointerException uNullPointerException){
                    System.out.println(uNullPointerException );
                }
            }
            try{
                bin.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
    public static void main(String[] args) {
        try{
            new PieFrame(3);
            //new PieFrame();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}