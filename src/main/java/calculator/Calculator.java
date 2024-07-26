package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    static Queue<Double> resultQueue = new LinkedList<>();

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

}
