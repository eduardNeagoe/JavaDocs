package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Eduard on 30.06.2016.
 */
public class Square extends Shape{
    private int side;

    public Square(int side){
        this.side = side;
    }

    public double area(){
        return side*side;
    }
}
