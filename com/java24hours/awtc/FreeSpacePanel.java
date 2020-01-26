package com.java24hours.awtc;

import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;

public class FreeSpacePanel extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel spaceLabel = new JLabel("Disk space:");
    JLabel space = new JLabel();

    public FreeSpacePanel(){
        super();
        add(spaceLabel);
        add(space);
        try{
            setValue();
        }catch (IOException xIoException){
            space.setText("ERROR");
        }
    }

    private final void setValue()throws IOException{
        //get the current file storage pool
        Path current = Paths.get("");
        FileStore store = Files.getFileStore(current);
        //find the free storage space
        long totalSpace = store.getTotalSpace();
        long freeSpace = store.getUsableSpace();
        //get this as percentage
        double percent = (double)freeSpace/(double)totalSpace*100;
        percent = (int)(percent*100)/(double)100;

        String sFreeSpace = toFourmateNumber(freeSpace, ',', 3);
        String sTotalSpace = toFourmateNumber(totalSpace, ',', 3);

        space.setText(sFreeSpace+" free out of "+sTotalSpace+" (" + percent +"% )");
    }

    private String toFourmateNumber(long number,char symbol,int offset) {
        
        String SNumber = String.valueOf(number);
        //Long LNumber = Long.valueOf(number);
        //String SNumber = LNumber.toString();
        int slen = SNumber.length();
        
        StringBuilder stringBuilder = new StringBuilder(SNumber);
        if(number<0){
            stringBuilder.deleteCharAt(0);
        }
        stringBuilder.reverse();

        //char[] charSeq = new char[slen];

        int aTimes = 0;
        for(int idx=0;idx<slen;idx++){
            if((idx>0)&(idx%offset==0)){
                idx += aTimes;
                aTimes++;
                stringBuilder.insert(idx,symbol);
            }
        }
        if(number<0){
            stringBuilder.append('-');
        }

        return stringBuilder.reverse().toString();

    }
}