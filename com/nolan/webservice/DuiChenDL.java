package com.nolan.webservice;

import java.awt.*;

public class DuiChenDL{

    public static Point duiChenDL(Point dPoint,Point lineE1,Point lineE2,Point o){
        int dPointX=dPoint.x;
        int dPointY=dPoint.y;

        int lineE1X=lineE1.x;
        int lineE1Y=lineE1.y;
        int lineE2X=lineE2.x;
        int lineE2Y=lineE2.y;
        //（((b*b-a*a)*x1-2*a*b*y1-2*a*c)/(a*a)+(b*b),((a*a-b*b)*y1-2*a*b*x1-2*b*c)/(a*a+b*b)）
        int a=lineE2Y-lineE1Y;
        int b=lineE1X-lineE2X;
        int c=lineE2X*lineE1Y-lineE1X*lineE2Y;
        c=-(b*o.y+a*o.x);


        int ddPointX=(int)(((b*b-a*a)*dPointX-2*a*b*dPointY-2*a*c)/(a*a+b*b));
        int ddPointY=(int)(((a*a-b*b)*dPointY-2*a*b*dPointX-2*b*c)/(a*a+b*b));

        return new Point(ddPointX,ddPointY);
    }
}
/* 
    a1x+b1y+c1=0;
    y=-(a1/b1)*x-c1/b1
    y=-(a1/b1)x+c
    c=y2+(a1/b1)*x1
    a1x+b1y-c*b1->c=-c*b1

 
    */