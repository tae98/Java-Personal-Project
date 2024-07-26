package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmaticCalculator extends Calculator{
    private static Queue<Double> resultQueue;

    ArithmaticCalculator() {
        resultQueue = new LinkedList<>();
    }

    public static double calculate(char operator, double num1, double num2) throws CalculateException {
        double result = 0;

        switch(operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case'*':
                result = num1 * num2;
                break;
            case'/':
                if(num2 == 0){
                    throw new CalculateException(num2);
                }else{
                    result = num1/num2;
                    break;
                }
            default:
                throw new CalculateException(operator);
        }
        resultQueue.add(result);
        return result;

    }

    //getter메서드 for result
    public static Queue<Double> getResultQueue(){
        return resultQueue;
    }
    //setter메서드 for result
    public static void setResultQueue(Queue<Double> newResultQueue){
        resultQueue = newResultQueue;
    }
}
