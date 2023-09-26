package com.myStudy.run;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 2023.09.24
 과제 진수 변환 프로그램작성
 진수를 받아서 원하는진수로 변환하기
 */

public class EssenceConversion {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입출력을 도와주는 함수
        System.out.println("몇 진수를 변환하시겠습니까?)");
        int N = Integer.parseInt(br.readLine());
        // integer.parseInt 문자열을 숫자로 변환
        System.out.println("수를 입력해 주세요. 10이상은 대문자를 입력하십시오.");
        String number = br.readLine();


        int decimal = toDecimal(N, number);
        // 먼저 입력 받은 각각의 진수를 10진법으로 바꿔준다.
        System.out.println("몇 진수로 바꾸시겠습니까?");
        int K = Integer.parseInt(br.readLine());

        String answer = conversionV(decimal, K);

        System.out.print("결과 : " + answer);
    }

    // N 진수를 10진수로 변환.
    public static int toDecimal(int N, String number) {

        int result = 0;

        if(N == 10) {
            // 입력이 10진법인 경우 바로 리턴
            return Integer.parseInt(number);
        }
        else if(N >= 2 && N <= 16){
            char[] num = number.toCharArray();
			/*
			 0부터 시작하여 진수와 곱해주고 각 자리 수 숫자를 더해준다.
			 그리고 그 결과를 다음 자리수로 갈 때 진수와 곱해주고 현재 자리수 값을 더해준다. 반복.
			 */
            for(int i=0; i<num.length; i++) {
                if(!errorCheck(num[i], N)) {
                    System.out.println("잘못된 입력입니다. 프로그램을 다시 실행하십시오.");
                    System.exit(0);

                }
                // 10이상의 숫자는 'A'를 빼고 +10을 해주면 된다.
                if(num[i] >= 'A') {
                    result = result * N + (num[i] - 'A' + 10);
                }
                else {
                    result = result * N + (num[i] - '0');
                }
            }
        }
        else {
            System.out.println("계산할 수 없는 진수입니다. 프로그램을 다시 실행하십시오.");
            System.exit(0);
        }

        return result;
    }

    // 10진수를 K 진수로 변환.
    public static String conversionV(int decimal, int K) {
        StringBuilder sb = new StringBuilder();

        int current = decimal;

        while(current > 0) {

            if(current % K < 10) {
                // N진법으로 나누었는데 10보다 작으면 바로 추가
                sb.append(current % K);
            }

            // 10이상은 알파벳으로 표기한다.
            else {
                // 10진수를 구해주는 법과 반대로 수행해주면 된다. 10이상의 수부터 표현할 수 있기 때문에 10을 빼주는 것이다.
                sb.append((char)(current % K - 10 + 'A'));
            }
            current /= K;
        }
        return sb.reverse().toString();
    }



    public static boolean errorCheck(char num, int notation) {
        // 주어진 진법 보다 높은 숫자가 입력으로 들어오면 오류.
        int n = 0;
        if(num >= 'A') {
            n = num - 'A' + 10;
        }
        else {
            n = num - '0';
        }

        return n < notation;
    }
}