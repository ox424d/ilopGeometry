/*
 
@author mamaddiesel
@version 0.0
*/
package dev.ilop.java.geometry;


import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class InfiLine extends Shape{
    protected final Point[] vertex;
    
    InfiLine(Point[] vertex) {
        if(vertex.length!=2) throw new IllegalArgumentException("A Line needs 2 points");
        for(Point p:vertex){
            if(p==null) throw new NullPointerException("Null point in vertices");
        }
        this.vertex= vertex.clone();
    }
    InfiLine(Point p1,Point p2) {
        if(p1==null||p2==null) throw new NullPointerException("Null point in vertices");
        vertex = new Point[2];
        vertex[0]=p1;
        vertex[1]=p2;
    }
    
    public static InfiLine InfiLineBuilder(Point p, double m0){
        Point p2= new Point(p.x+10,m0*10+p.y);
        return new InfiLine(p,p2);
    }
    
    public static Point crossPoint(InfiLine l1,InfiLine l2){
        double x,y;
        if(abs(l1.m()-l2.m())<EPSILON) return new Point(Double.MAX_VALUE,Double.MAX_VALUE);
        
        x=(l2.y0()-l1.y0())/(l1.m()-l2.m());
        y=l1.m()*x+l1.y0();
        return new Point(x,y);
    }
    
    public Point[] getVertex(){
        return vertex.clone();
    }

    @Override
    public boolean isIn(Point p) {return false; }

    @Override
    public boolean isOn(Point p) {
        Point p1=vertex[0];
        Point p2=vertex[1];
        
        if(abs(p1.x-p2.x)<EPSILON) return (abs(p.x-p1.x)<EPSILON);
        return abs(m()*(p.x-p1.x)-(p.y-p1.y)) < EPSILON;
    }

    @Override
    public double perimeter() {return 0;}

    @Override
    public double area(){return 0;}
    
    public double m(){
        Point p1=vertex[0];
        Point p2=vertex[1];
        
        if(p1.x==p2.x) return Double.MAX_VALUE;
        return (p2.y-p1.y)/(p2.x-p1.x);
    }
    
    public boolean isSameSide(Point p1,Point p2){
        if(abs(vertex[0].x-vertex[1].x)<EPSILON) return (p1.x>vertex[0].x&&p2.x>vertex[0].x)||(p1.x<vertex[0].x&&p2.x<vertex[0].x);
        double y0p1,y0p2,y0p;
        y0p1=p1.y-m()*p1.x;
        y0p2=p2.y-m()*p2.x;
        y0p=y0();
        return (y0p1>y0p&&y0p2>y0p)||(y0p1<y0p&&p2.x<y0p);
    }
    //Y axis cross section
    public double y0(){
        return vertex[0].y-m()*vertex[0].x;
    }
    //Image of a point on the line
    public Point image(Point p){
        if(abs(vertex[0].x-vertex[1].x)<EPSILON) return new Point(vertex[0].x,p.y);
        if(abs(vertex[0].y-vertex[1].y)<EPSILON) return new Point(p.x,vertex[0].y);
        InfiLine cLine;
        cLine=InfiLineBuilder(p,-1/m());
        return crossPoint(this,cLine);
    }
    
    public double distance(Point p){
        Point p2=image(p);
        return sqrt(pow(p2.x-p.x,2)+pow(p2.y-p.y,2));
    }
    
}
