package calculator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class App {

    Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = 0;
        double num2 = 0;
        char operator;


        //반복문으로 실행
        while(true){
            System.out.print("첫 번쨰 숫자를 입력하세요: ");
            num1 = sc.nextInt();
            System.out.print("두 번쨰 숫자를 입력하세요: ");
            num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            String tmp =sc.next();
            operator = tmp.charAt(0);
            //예외처리를위한 try문
            try{
                //Calculator 클래스의 메서들를활용
                Calculator.calculate(operator, num1, num2);

                //queue에저장된값제거
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String removeTxt = sc.next();

                if(Objects.equals(removeTxt, "remove")){
                    Calculator.getResultQueue().poll();
                }
                //queue에저장된값출력
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiryTxt = sc.next();
                //inquiry가 입력됬을때 foreach문을 이용해 프린트
                if(Objects.equals(inquiryTxt, "inquiry")){
                    for(double num: Calculator.getResultQueue()){
                        System.out.println(num);
                    }
                }

                //반복문 탈출
                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
                String endCommand = sc.next();
                if(Objects.equals(endCommand, "exit")){
                    break;
                }
            //예외처리
            }catch(CalculateException e){
                System.out.println(e.getMessage());
            }

        }
    }
}

