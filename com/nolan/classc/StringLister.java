package com.nolan.classc;

import java.util.*;

public class StringLister{

    String[] names = {"Spanky","Alfalfa","Buckwheat","Daria","Symie","Marianne","Scotty","Tommy","Chubby"};
    private ArrayList<String> strList=new ArrayList<String>();

    public StringLister(String[] morenames){
        //ArrayList<String> strList=new ArrayList<String>();
        for(int i=0;i<names.length;i++){
            //System.out.println(i+" name:"+names[i]);
            strList.add(names[i]);
        }
        for(int i=0;i<morenames.length;i++){
            strList.add(morenames[i]);
        }
        Collections.sort(strList);
        //for(String name:strList){
        //    System.out.println(name);
        //}
    }
    public ArrayList<String> getNames(){
        return strList;
    }

    public static void main(String[] args) {

        String[] argss={"One more","Two more","Three more","Four more","Five more"};
        StringLister sl=new StringLister(argss);
        ArrayList<String> names=sl.getNames();

        int i=0;
        for(String name:names){
            System.out.println(i+":"+name);
            i++;
        }
    }
}