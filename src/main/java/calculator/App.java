package calculator;
import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번쨰 숫자를 입력하세요: ");
        int num1 = sc.nextInt();

        System.out.print("두 번쨰 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        String tmp =sc.next();
        char operator = tmp.charAt(0);

        int result =0;

        boolean flag = true;
        while(flag == true){

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
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                        break;
                    }else{
                        result = num1/num2;
                        break;
                    }
            }
            System.out.println("결과: " + result);




        }


    }
}
