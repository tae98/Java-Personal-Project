package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmaticCalculator extends Calculator{
    private static Queue<Double> resultQueue;
    //오버라이딩 사용을위한 인터페이스 필드 추가
    static MasterOperator addOperator;
    static MasterOperator minusOperator;
    static MasterOperator multiplyOperator;
    static MasterOperator divideOperator;
    static MasterOperator modOperator;

    //모듈러 추가
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
        //오버라이딩된 메서드 사용
        switch(operator){
            case '+':
                result = addOperator.operate(num1, num2);
                break;
            case '-':
                result = minusOperator.operate(num1, num2);
                break;
            case'*':
                result = multiplyOperator.operate(num1,num2);
                break;
            case'/':
                if(num2 == 0){
                    throw new CalculateException(num2);
                }else{
                    result = divideOperator.operate(num1,num2);
                    break;
                }
            case '%':
                if(num2 == 0){
                    throw new CalculateException(num2);
                }else{
                    result = modOperator.operate(num1,num2);
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
