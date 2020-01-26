package com.java24hours;

class Wheel{
    public static void main(String[] args) {
        String[] phrase = {
            "A STITCH IN TIME SAVES NINE",
            "DON'T EAT YELLOW SNOW",
            "JUST DO IT",
            "EVERY GOOD BOY DOES FINE",
            "I WANT MY MTV",
            "I LIKE IKE",
            "PLAY IT AGAIN",
            "FROSTY THE SNOWMAN",
            "ONE MORE FOR THE ROAD",
            "HOME FIELD ADVANTAGE",
            "VALENTINE'S DAY MESSACRE",
            "GROVER CLEVELAND OHIO",
            "SPAGHETTI WESTING",
            "AQUA TEEN HUNGER FORCE",
            "IT'S A WONDERFUL LIFE"
        };
        int[] letterCount = new int[26];
        for (int count=0;count<phrase.length;count++){
            String current=phrase[count];
            char[] letters = current.toCharArray();
            for(int count2=0;count2<letters.length;count2++){
                char letter = letters[count2];
                if((letter>='A')&(letter<='Z')){
                    letterCount[letter-'A']++;
                }
            }
        }
        for(char alp='A';alp<='Z';alp++){
            System.out.print(alp+":"+letterCount[alp-'A']+",");
            if(alp=='M'){
                System.out.println();
            }
        }
        System.out.println();
    }
}