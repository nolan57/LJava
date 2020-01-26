package com.java24hours.classc;

import java.awt.*;

public class Point3D extends Point{
    public int z;
    public Point3D(int x,int y,int z){
        super(x,y);
        this.z=z;
    }
    public Point3D(){
        super(0,0);
        this.z=0;
    }

    public void move(int x,int y,int z){
        super.move(x, y);
        this.z=z;
    }
    public void translate(int dx,int dy,int dz) {
        super.translate(dx, dy);
        this.z += dz;
    }
    public int getZ(){
        return z;
    }

}