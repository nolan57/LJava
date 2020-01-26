package com.java24hours.classc;

public class Point4D extends Point3D{

    public int t;

    public Point4D(int x,int y,int z,int t){
        super(x,y,z);
        if(t<0){
            System.out.println("Error,t can't be < 0");
            this.t=0;
            System.out.println("t is default 0");
        }else{
            this.t=t;
        }
    }
    public int getT(){
        return this.t;
    }
    public void setT(int t){
        if(t<0){
            System.out.println("Error,t can't be < 0");
            System.out.println("t now is "+this.t);
        }else{
            this.t=t;
        }
    }

    public void move(int x,int y,int z,int t){
        super.move(x,y,z);
        setT(t);
    }

    public void translate(int dx,int dy,int dz,int dt){
        super.translate(dx, dy, dz);
        this.t += dt;
    }

}