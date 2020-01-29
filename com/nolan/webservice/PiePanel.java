package com.nolan.webservice;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class PiePanel extends JPanel implements Runnable{
    ArrayList<PieSlice> pieSlices;
    ArrayList<Arc2dDrawed> arc2dDraweds;;

    private int sliceCount=0;
    private float totalSliceSize=0;
    private float startPoint=0;
    private float centerOfPie;


    public PiePanel(){
        pieSlices=new ArrayList<>();
        arc2dDraweds=new ArrayList<>();
        setSize(500, 500);
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void addPieSlice(Color sliceColor,float size){
        pieSlices.add(new PieSlice(sliceColor, size));
        sliceCount++;
        totalSliceSize+=size;
        int frameHeight=getSize().height;
        int frameWidth=getSize().width;
        centerOfPie=Math.min(frameHeight,frameWidth);
    }
    
    public class PieSlice{
        Color sliceColor;
        float size=0;
        public PieSlice(Color sliceColor,float size){
            this.sliceColor=sliceColor;
            this.size=size;
        }
    }
    private class Arc2dDrawed{
        int stringX,stringY;
        int arcX,arcY;
        int sx,sy;
        int ex,ey;
        float sliceSize;
        float extent;
        Arc2D.Float sliceToDrawed;
        public Arc2dDrawed(Arc2D.Float sliceToDrawed,float sliceSize,float extent){
            this.sliceSize=sliceSize;
            this.sliceToDrawed=sliceToDrawed;
            this.extent=extent;
            Point2D endPoint=this.sliceToDrawed.getEndPoint();
            Point2D startPoint=this.sliceToDrawed.getStartPoint();

            double ax=startPoint.getX();
            double bx=endPoint.getX();
            double ox=centerOfPie;
            double ay=startPoint.getY();
            double by=endPoint.getY();
            double oy=centerOfPie;
            double R=centerOfPie;

            sx=(int)ax;
            sy=(int)ay;
            ex=(int)bx;
            ey=(int)by;

            double c1=(ax+bx)/2-ox;
            double c2=(ay+by)/2-oy;
            double d=Math.pow(c1,2)+Math.pow(c2,2);
            double e=Math.pow(R,2)/d;
            double E=Math.sqrt(e);

            //oy=-oy;
            this.arcX=(int)(E*(ax+bx)/2);
            this.arcY=(int)(E*(ay+by)/2);

            this.stringX=(int)((arcX+ox)/2);
            this.stringY=(int)((arcY+oy)/2);

        }
    }

    @Override
    public void paintComponent(Graphics graphicsComp){
        super.paintComponent(graphicsComp);
        Graphics2D graphicsComp2d=(Graphics2D)graphicsComp;

        float compWidth=(float)getSize().width;
        float compHeight=(float)getSize().height;
        float miner=Math.min(compHeight,compWidth);
        this.centerOfPie=miner/2;
        float leftUpX=0F;
        float leftUpY=0F;

        pieSlices.forEach(pieSlice->{
            float extent=pieSlice.size*360F/totalSliceSize;
            graphicsComp2d.setColor(pieSlice.sliceColor);
            Arc2D.Float sliceToDrawed=new Arc2D.Float(
                leftUpX,leftUpY,miner,miner,this.startPoint,extent,Arc2D.Float.PIE
            );
            if(arc2dDraweds.size()%sliceCount==0){
                arc2dDraweds.clear();
                //arc2dDraweds.clear();
            }
            arc2dDraweds.add(new Arc2dDrawed(sliceToDrawed,pieSlice.size,extent));    

            graphicsComp2d.fill(sliceToDrawed);
            this.startPoint+=extent;
        });
        System.out.println(arc2dDraweds.size());
        arc2dDraweds.forEach(arc2d->{
            System.out.println("center:("+centerOfPie+","+centerOfPie+")");
            System.out.println("arc mid points:("+arc2d.arcX+","+arc2d.arcY+")");
            graphicsComp2d.setColor(Color.BLACK);
            
            //graphicsComp2d.drawString((arc2d.sliceSize/totalSliceSize*100)+"%", arc2d.sx, arc2d.sy);
            //float rx=(arc2d.sx+arc2d.ex)/2;
            //System.out.println("extent:"+arc2d.extent);
            float rx=(arc2d.sx+arc2d.ex)/2;
            float ry=(arc2d.sy+arc2d.ey)/2;
            if(arc2d.extent>=180){
                System.out.println("extent>180!");
                Point dPoint=new Point((int)rx,(int)(ry));
                Point lineE1=new Point(arc2d.sx,arc2d.sy);
                Point lineE2=new Point(arc2d.ex,arc2d.ey);
                Point o=new Point((int)centerOfPie,(int)centerOfPie);
                Point rxy=DuiChenDL.duiChenDL(dPoint, lineE1, lineE2,o);

                rx=(float)rxy.x;
                ry=(float)rxy.y;
            }
            //graphicsComp2d.drawLine((int)(this.centerOfPie), (int)(this.centerOfPie), (int)(rx), (int)(ry));
            graphicsComp2d.drawString((arc2d.sliceSize/totalSliceSize*100)+"%", rx, ry);
            //graphicsComp2d.drawString("@", arc2d.arcX, arc2d.arcY);
        });
    }

    @Override
    public void run() {
        paintComponent(this.getGraphics().create(0, 0, 500, 500));
        //repaint();
    }
}