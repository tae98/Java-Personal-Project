package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class CircleCalculator extends Calculator{
    private static Queue<Double> circleQueue;

    CircleCalculator() {
        circleQueue = new LinkedList<>();
    }

    public static double circleCalculate(double radius){
        double area = 0;
        area = PI * Math.pow(radius,2);
        return area;
    }
    public static Queue<Double> getCircleQueue(){
        return circleQueue;
    }

    public static void setCircleQueue(Queue<Double> newCircleQueue){
        circleQueue = newCircleQueue;
    }
}
