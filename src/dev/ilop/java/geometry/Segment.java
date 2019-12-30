/*
 
@author mamaddiesel
@version 0.0
*/
package dev.ilop.java.geometry;


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author 254494
 */
public class Segment extends InfiLine{

    public Segment(Point[] vertex) {
        super(vertex);
    }
    public Segment(Point p1,Point p2) {
        super( p1, p2);
    }
    
    @Override
    public boolean isOn(Point p){
        Point p1=vertex[0];
        Point p2=vertex[1];
        if(!super.isOn(p)) return false;
        return ((p.y>=p1.y&&p.y<=p2.y)||(p.y<=p1.y&&p.y>=p2.y));
    }
    
    public double length(){
        return sqrt(pow(vertex[1].x-vertex[0].x,2)+pow(vertex[1].y-vertex[0].y,2));
    }
    
    public Point closePoint(Point p){
        Point imagePoint=image(p);
        if(isOn(imagePoint)) return imagePoint;
        double d1,d2;
        d1=(new Segment(p,vertex[0])).length();
        d2=(new Segment(p,vertex[1])).length();
        return d1>d2?vertex[1]:vertex[0];
    }
    
    @Override
    public double distance(Point p){
        Point p2=closePoint(p);
        return sqrt(pow(p2.x-p.x,2)+pow(p2.y-p.y,2));
    }
    
}
