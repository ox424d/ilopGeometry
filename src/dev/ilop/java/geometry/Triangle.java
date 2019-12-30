/*
 
@author mamaddiesel
@version 0.0
*/
package dev.ilop.java.geometry;




public class Triangle extends Polygon{
    
    public Triangle(Point[] vertex) {
        super(vertex);
        if(vertex.length!=3) throw new IllegalArgumentException("A Triangle has 3 vertices");
    }
    @Override
    public boolean isIn(Point p){
        boolean b=true;
        for(int i=0;i<3;i++){
            b=b&&(new Segment(vertex[i],vertex[(i+1)%3]).isSameSide(p,vertex[(i+2)%3]));
        }
        return b;
    }
    
    @Override
    public double area(){
        Segment base=new Segment(vertex[0],vertex[1]);
        return base.length()*(new Segment(vertex[2],base.image(vertex[2]))).length()/2;
    }
    
    
}
