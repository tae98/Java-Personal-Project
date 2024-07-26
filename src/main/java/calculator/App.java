package calculator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class App {

    static ArithmaticCalculator arithmaticCalculator = new ArithmaticCalculator();
    static CircleCalculator circleCalculator = new CircleCalculator();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = 0;
        double num2 = 0;
        int calcDecide = 0;
        double radius = 0;
        double result = 0;
        char operator;


        //반복문으로 실행
        while(true){
            System.out.println("원하시는 계산을 입력해주세요");
            System.out.println("사칙연산을 원하시면 : 1");
            System.out.println("원의 넓이를 계산하고 싶으면: 2");
            calcDecide = sc.nextInt();

            if(Objects.equals(calcDecide, 1)){
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
                    result = arithmaticCalculator.calculate(operator, num1, num2);
                    System.out.println(result);

                    //queue에저장된값제거
                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    String removeTxt = sc.next();

                    if(Objects.equals(removeTxt, "remove")){
                        arithmaticCalculator.getResultQueue().poll();
                    }
                    //queue에저장된값출력
                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    String inquiryTxt = sc.next();

                    //inquiry가 입력됬을때 inquiryQueue메서드 이용해 프린트
                    if(Objects.equals(inquiryTxt, "inquiry")){
                        arithmaticCalculator.inquiryQueue(arithmaticCalculator.getResultQueue());
                    }//예외처리
                }catch(CalculateException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(Objects.equals(calcDecide, 2)){
                //반지름을 입력받아 계산
                System.out.println("반지름의 값을 입력해주세요:");
                radius = sc.nextDouble();
                result = circleCalculator.circleCalculate(radius);
                System.out.println("결과: " + result);

                //계산된값을 해당 큐에 저장
                circleCalculator.getCircleQueue().add(result);

                //저장된 값들조회
                System.out.println("현제 저장된 원의 넓이 값:");
                circleCalculator.inquiryQueue(circleCalculator.getCircleQueue());
            }else{
                System.out.println("====================================");
                System.out.println("옵션의 없는값이 입력되었습니다, 다시입력해주세요");
                System.out.println("====================================");
                continue;
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String endCommand = sc.next();
            if(Objects.equals(endCommand, "exit")){
                break;
            }
        }
    }
}

