package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmaticCalculator extends Calculator{
    private static Queue<Double> resultQueue;
    static AddOperator addOperator;
    static MinusOperator minusOperator;
    static MultiplyOperator multiplyOperator;
    static DivideOperator divideOperator;
    static ModOperator modOperator;

    ArithmaticCalculator() {
        resultQueue = new LinkedList<>();
        this.addOperator = new AddOperator();
        this.minusOperator = new MinusOperator();
        this. multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
        this.modOperator = new ModOperator();
    }

    public static double calculate(char operator, double num1, double num2) throws CalculateException {
        double result = 0;

        switch(operator){
            case '+':
                result = addOperator.add(num1, num2);
                break;
            case '-':
                result = minusOperator.minus(num1, num2);
                break;
            case'*':
                result = multiplyOperator.multiply(num1,num2);
                break;
            case'/':
                if(num2 == 0){
                    throw new CalculateException(num2);
                }else{
                    result = divideOperator.divide(num1,num2);
                    break;
                }
            case '%':
                if(num2 == 0){
                    throw new CalculateException(num2);
                }else{
                    result = modOperator.modulo(num1,num2);
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
