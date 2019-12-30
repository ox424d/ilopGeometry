/*
 
@author mamaddiesel
@version 0.0

Last edited: 2018-12-20
*/

/*
Class: Shape
Use: Abstract class for all closed shapes
*/
package dev.ilop.java.geometry;

public abstract class Shape {
    protected static final double EPSILON=1e-6;
    abstract public boolean isIn(Point p);
    abstract public boolean isOn(Point p);
    abstract public double perimeter();
    abstract public double area();
}
