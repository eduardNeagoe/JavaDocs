package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Eduard on 30.06.2016.
 */
public class Point {
    int xPos;
    int yPos;

    public Point(int x, int y) {
        xPos = x;
        yPos = y;
    }

    @Override
    public boolean equals(Object other){

        if(other == null){

            return false;
        }
        if(other instanceof  Point){
            Point anotherPoint = (Point) other;

            if(xPos == anotherPoint.xPos && yPos == anotherPoint.yPos){
                return true;
            }
        }
        return false;
    }
}
