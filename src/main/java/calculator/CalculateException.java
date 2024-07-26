package calculator;

public class CalculateException extends Exception {
    public CalculateException(double num2){
        super("연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
    }

    public CalculateException(char operator){
        super("잘못된 연산 기호가 입력되었습니다. 입력된기호: " + operator);
    }
}
