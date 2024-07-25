package calculator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //결과들을 저장할 queue 생성
        Queue<Integer> resultQueue = new LinkedList<>();

        //while문 반복 조건
        while(true){
            //연산 값 초기화
            int result =0;

            //연산을위한 숫자 인풋 저장
            System.out.print("첫 번쨰 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번쨰 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            //연산을위한 기호 저장
            System.out.print("사칙연산 기호를 입력하세요: ");
            String tmp =sc.next();
            char operator = tmp.charAt(0);

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

            //queue에 값을 저장
            resultQueue.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String removeTxt = sc.next();

            if(Objects.equals(removeTxt, "remove")){
                resultQueue.poll();
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiryTxt = sc.next();
            //inquiry가 입력됬을때 foreach문을 이용해 프린트
            if(Objects.equals(inquiryTxt, "inquiry")){
                for(int num: resultQueue){
                    System.out.println(num);
                }
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String endCommand = sc.next();
            if(Objects.equals(endCommand, "exit")){
                break;
            }



        }


    }
}
