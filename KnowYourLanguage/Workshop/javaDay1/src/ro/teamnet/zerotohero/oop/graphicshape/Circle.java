package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Eduard on 30.0S6.2016.
 */
public class Circle extends Shape{
    private double xPos;
    private double yPos;
    private double radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;
    }
    public Circle(double xPos){
        this.xPos = xPos;
    }
    public Circle(double xPos, double yPos){
        this.yPos = yPos;
        this.xPos = xPos;
    }
    public Circle(double xPos, double yPos,double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI*radius*radius;
    }

    @Override
    public String toString(){
        return "center = ("+xPos+","+yPos+") and radius = "+radius;
    }

    public void fillColour(){
        System.out.println(super.getColor());
    }
    public void fillColour(int color){
        super.setColor(color);
        System.out.println("The circle color is now "+color);
    }
    public void fillColour(float saturation){
        super.setSaturation(saturation);
    }
}
