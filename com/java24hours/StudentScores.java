package com.java24hours;

class StudentScores{
    public static void main(String[] args) {
        float[][] studentScores={
            {10,9,8,7,10},
            {9,9,7,7,5},
            {7,8,8,7,10},
            {10,10,6,9,9},
            {5,5,9,9,7}
        };

        int students=studentScores.length;
        System.out.println("The number of students is "+students);
        float[] avgScores = new float[students];
        for (int i=0;i<students;i++){
            float acc1=0;
            for(int j=0;j<studentScores[i].length;j++){
                acc1 += studentScores[i][j];
            }
            avgScores[i]=acc1/studentScores[i].length;
            System.out.println("Student "+i+" avg score is :"+avgScores[i] );
        }
        
        float acc2=0;
        for (int k=0;k<avgScores.length;k++){
            acc2 += avgScores[k];
        }

        System.out.println("Total avg score is :"+ acc2/avgScores.length);
    }
}