package calculator;

public class AddOperator implements MasterOperator{
    @Override
    public double operate(double num1, double num2){
        return num1 + num2;
    }
}
