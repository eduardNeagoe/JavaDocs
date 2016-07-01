package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.immutable.ImmutableClass;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Eduard on 30.06.2016.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles circles = new Circles();
        circles.getAreaDef();
        System.out.println("circles.getAreaPub():The default circle area is:"+circles.getAreaPub());

//        Canvas canvas = new Canvas();
//        Circle circle= new Circle();
//        canvas.getArea(circle);


        Shape shape = new Circle(10);
        System.out.println(shape.area());

        ShapeBehaviour shapeBehaviour = new Square(10);
        System.out.println(shapeBehaviour.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

//      ImmutableClass immutableClass = new ImmutableClass();
//      immutableClass.atr1 = 5;

    }


}
