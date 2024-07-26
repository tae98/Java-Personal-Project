package calculator;

public class MinusOperator implements MasterOperator{
    @Override
    public double operate(double num1, double num2){
        return num1 - num2;
    }
}
