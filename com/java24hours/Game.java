package com.java24hours;

class Game{
    public static void main(String[] args) {
        int total = 0;
        int score = 7;
        if(score == 7){
            System.out.println("your score a touchdown!");
        }
        if(score == 3){
            System.out.println("You kick a field goal!");
        }
        //total = total + score;
        total += score;
        System.out.println("Total score: "+total);
    }
}