/*
 
@author mamaddiesel
@version 0.0
*/
package dev.ilop.java.geometry;


import java.util.ArrayList;
import java.util.Arrays;


public abstract class Polygon extends Shape{
    protected final Point[] vertex;
    
    public Polygon(Point[] vertex){
        if (vertex.length<2) throw new IllegalArgumentException("Not Enough Points");
        for(Point p:vertex){
            if(p==null) throw new NullPointerException("Null point in vertices");
        }
        this.vertex= vertex.clone();
    }

    @Override
    public boolean isOn(Point p){
        Segment[] sides=getSides();
        for(Segment sd:sides){
            if(sd.isOn(p)) return true;
        }
        return false;
    }

    @Override
    public double perimeter() {
        Segment[] sides=getSides();
        double perim=0;
        for(Segment sd:sides){
            perim+=sd.length();
        }
        return perim;
    }

    
    public Segment[] getSides(){
        ArrayList<Segment> output=new ArrayList();
        for(int i=0;i<vertex.length;i++){
            output.add(new Segment(vertex[i],vertex[(i+1)%3]));
        }
        
        return output.toArray(new Segment[output.size()]);
    }
    
    //get the closest point on the polygon to the point p
    public Point closePoint(Point p){
        Segment[] sides=getSides();
        Point result, tempR;
        double d,tempD;
        result=sides[0].closePoint(p);
        d=sides[0].distance(p);
        for(int i=1;i<sides.length;i++){
            tempR=sides[i].closePoint(p);
            tempD=sides[i].distance(p);
            if(tempD<d){
                d=tempD;
                result=tempR;
            }
        }
        return result;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(vertex);
    }
}
