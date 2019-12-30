/*
 
@author ox424d
@version 0.0

Last edited: 2018-12-20
*/

/*
Class: Point3D
Use: holds a 3 dimetional point
*/

package dev.ilop.java.geometry;

public class Point3D extends Point{
    public final double z;
    Point3D(double x,double y, Double z){
        super(x,y);
        this.z=z;
    }
    public double[] getxyz(){
        double[] xyz=new double[3];
        xyz[0]=x;
        xyz[1]=y;
        xyz[2]=z;
        return xyz;
    }
    public boolean equals(Point3D p){
        return false;
    }
    
    @Override
    public int compareTo(Point3D t) {
        if(super.compareTo(t)!=0)return -1;
        if(t.z==z) return 0;
        return -1;
    }
}
