package com.nolan.datastructure;

import java.util.*;
//import com.java24hours.classc.Point3D;
import java.awt.*;

public class BattlePoints{
    ArrayList<Point> targePoints;
    ArrayList<Point> mapPoints;
    HashMap<String,Integer> mapSize;
    private int targePointsNumber;
    private HashMap<Point,Integer> shootLayout;

    public BattlePoints(int xlimit,int ylimit,int targePointsNumber){
        shootLayout=new HashMap<Point,Integer>();
        this.targePointsNumber=targePointsNumber;
        targePoints=new ArrayList<Point>();
        for(int i=0;i<targePointsNumber;i++){
            int targePointsX=(int)(Math.random()*xlimit);
            int targePointsY=(int)(Math.random()*ylimit);
            //System.out.print("( "+targePointsX+","+targePointsY+" )");
            targePoints.add(new Point(targePointsX,targePointsY));
        }
        System.out.println("The TargetPoint are :");
        for (Point point : targePoints) {
            System.out.println("( "+point.x+","+point.y+" )");
        }        
        setMapSize(xlimit, ylimit);
    }

    public void setMapSize(int x,int y){
        mapSize=new HashMap<String,Integer>(2);
        mapSize.put("x", x);
        mapSize.put("y", y);
    }
    public void setMap(HashMap<String,Integer> mapSize){
        int x=mapSize.get("x").intValue();
        int y=mapSize.get("y").intValue();
        int mapPointsNumber=x*y;
        this.mapPoints=new ArrayList<>(mapPointsNumber);
    }

    public void showMap(String mapPointMark,String targetPointMark){
        //print x labels
        int xlimit=mapSize.get("x").intValue();
        int ylimit=mapSize.get("y").intValue();
        System.out.println();
        System.out.print("xy");
        for(int xl=0;xl<xlimit;xl++){
            System.out.print(" "+xl);
            if(xl+1==xlimit){
                System.out.println();
            }
        }
        //print y lables and point mark
        for(int i=0;i<ylimit;i++){
            System.out.println();
            System.out.print(i+"  ");
            for(int j=0;j<xlimit;j++){
                boolean isTargetPoint=false;
                for(Point point:targePoints){
                    if((point.x==j)&(point.y==i)){
                        isTargetPoint=true;
                        break;
                    }
                }
                    if(isTargetPoint){
                        System.out.print(targetPointMark+" ");
                    }else{
                        System.out.print(mapPointMark+" ");
                    }
                }

            }
        System.out.println();
    } 


    public void showHitLayout(){
        //print x labels
        int xlimit=this.mapSize.get("x").intValue();
        int ylimit=this.mapSize.get("y").intValue();
        System.out.println();
        System.out.print("xy");
        for(int xl=0;xl<xlimit;xl++){
            System.out.print(" "+xl);
            if(xl+1==xlimit){
                System.out.println();
            }
        }
        //print y lables and point mark
        //Integer shoots=null;

        for(int i=0;i<ylimit;i++){
            System.out.println();
            System.out.print(i+"  ");
            for(int j=0;j<xlimit;j++){
                boolean isHitPoint=false;
                for(Point point:shootLayout.keySet()){
                    if((point.x==j)&(point.y==i)){
                        isHitPoint=true;
                        break;
                    }
                }
                    if(isHitPoint){
                        System.out.print(shootLayout.get(new Point(j,i)).intValue()+" ");
                    }else{
                        System.out.print("@ ");
                    }
                }

            }
        System.out.println();
    }    
    public Point shoot(){
        int xlimit=mapSize.get("x").intValue();
        int ylimit=mapSize.get("y").intValue();
        int x=(int)(Math.random()*xlimit);
        int y=(int)(Math.random()*ylimit);
        Point shootPoint=new Point(x,y);
        if(shootLayout.containsKey(shootPoint)){
            int value=shootLayout.get(shootPoint).intValue();
            value++;
            shootLayout.replace(shootPoint, value);
        }else{
            shootLayout.put(shootPoint,1);
        }
        return shootPoint;
    }
    public boolean hitTheTarget(Point shootPoint){
        if(targePoints.contains(shootPoint)){
            targePoints.remove(shootPoint);
            System.out.println("Hit the target at ( "+shootPoint.x+","+shootPoint.y+" )");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int xlimit=10;
        int ylimit=10;
        int targePointsNumber=3;
        BattlePoints battlePoints=new BattlePoints(xlimit, ylimit, targePointsNumber);
        //battlePoints.setMap(battlePoints.mapSize);
        battlePoints.showMap("@", "X");
        int hitNumber=0;
        int shootNumber=0;
        do{
            System.out.println("SHOOT!");
            shootNumber++;
            if(battlePoints.hitTheTarget(battlePoints.shoot())){
                hitNumber++;
            }
        }while(hitNumber != targePointsNumber);
        System.out.println(targePointsNumber+" targets have been killed by "+shootNumber+" shoots!");
        float avgShootsToDead=(float)shootNumber/(float)targePointsNumber;
        if(avgShootsToDead==1)
            {System.out.println("Fuck,so cool!");}
        else{
            if(avgShootsToDead>=10){System.out.println("Suck!");}
                else{System.out.println("Not bad...");}
        }
        battlePoints.showHitLayout();
        battlePoints.showMap("@", "X");
    }

}