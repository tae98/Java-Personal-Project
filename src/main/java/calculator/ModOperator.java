package calculator;

public class ModOperator implements MasterOperator {
    @Override
    public double operate(double num1, double num2){
        return num1%num2;
    }
}
