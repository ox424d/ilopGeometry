/*
 
@author mamaddiesel
@version 0.0
*/
package dev.ilop.java.geometry;


public class Point implements Comparable<Point3D>{
    public final double x,y;
    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    
    public double[] getxy(){
        double[] xy=new double[2];
        xy[0]=x;
        xy[1]=y;
        
        return xy;
    }

    @Override
    public int compareTo(Point3D t) {
        if(t.x==x&&t.y==y) return 0;
        return -1;
    }
    
    public String toString(){
        return String.format("(%1.3f,%1.3f)", x,y);
    }
}
