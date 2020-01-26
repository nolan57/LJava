package com.java24hours;

import java.util.*;

class NameSorter{
    public static void main(String[] args) {
        String[] names={"Glimmer","Marvel","Rue","Clove",
                        "Thresh","Foxface","Cato","Peeta",
                        "Katniss"};
        System.out.print("The original order:\n");
        for(int i=0;i<names.length;i++){
            System.out.print(i+":"+names[i]+",");
        }
        System.out.println();
        Arrays.sort(names);
        System.out.print("The new order:\n");
        for (int i=0;i<names.length;i++){
            System.out.print(i+":"+names[i]+",");
        }
        System.out.println();

    }
}