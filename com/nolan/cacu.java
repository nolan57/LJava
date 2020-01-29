package com.nolan;

class cacu{
    public static void main(String[] args) {
        int[] cacus=new int[400];

        int number=0;
        int i=0;
        while(i<400){
            if(number%13==0){
                cacus[i]=number;
                i++;
            }
            number++;
        }
        for(int j=0;j<400;j++){
            System.out.print((j+1)+":"+cacus[j]+" ");
            if(j%30==0){
                System.out.println();
            }
        }
    }
}