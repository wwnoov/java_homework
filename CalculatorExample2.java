package com.myStudy.myClass.test;
import  java.util.*;

/**
 *  요구사항
  * 1. 계산기 클래스를 만들고
 * 2. 입력값 부호, 첫번째 값, 두번쨰 값을 입력하면 출력되는 PG
 * 3. 입력 형식 + 35 27
 * 4. 출력형식 35+27 = 62
 * */

public class CalculatorExample2 {
    public static void main(String[] args) {

        //Calculator2 객체 생성
        Calculator2 myCalc = new Calculator2();
        Scanner sc = new Scanner(System.in);

        System.out.println("부호 , 첫번째 값, 두번째 값을 입력하세요 ");
        String sign = sc.next();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        //메서드를 호출하여 리턴값을 대입
        if(sign.equals("+")) {
            System.out.println("결과 "+num1+" + "+num2+" = "+myCalc.plus(num1,num2));
        }
        else if(sign.equals("-")) {
            System.out.println("결과 "+num1+" - "+num2+" = "+myCalc.minus(num1,num2));
        }
        else if(sign.equals("*")) {
            System.out.println("결과 "+num1+" * "+num2+" = "+myCalc.multi(num1,num2));
        }
        else if(sign.equals("/")) {
            System.out.printf("결과 "+num1+" / "+num2+" = "+"%.2f",myCalc.divide(num1,num2));
            System.out.println();
        }
        else {
            System.out.println("오류 발생");
        }
    }
}