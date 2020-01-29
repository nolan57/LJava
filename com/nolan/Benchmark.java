package com.nolan;

class Benchmark{
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 1000;
        long index = 0L;

        while(true){
            //double x = Math.sqrt(index);
            long now = System.currentTimeMillis();
            if(now > endTime){
                System.out.println(index+" loop in one seconds");
                break;
            }
            index++;
        }
        //System.out.println(index+" loop in one seconds");
    }

}