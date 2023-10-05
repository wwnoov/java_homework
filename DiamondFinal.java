package com.myStudy.esect;

public class DiamondFinal {
        // 홀수를 입력받아 그 크기만큼의 가운데정렬 마름모를 찍는 문제. 최종 풀이코드.
        public static void main(String[] args) {
            System.out.print("홀수를 입력하세요 : ");
            int n = new java.util.Scanner(System.in).nextInt(); // 홀수 입력받기
            for(int i=-n/2; i<=n/2; i++)    // n번 반복. 즉 한 줄에 한 번의 반복. 각 줄에서 abs(i)의 값은 왼쪽 공백의 개수와 같다.
                // String 클래스의 repeat 메소드 + Math 클래스의 abs()메소드를 사용해 풀이
                System.out.println(" ".repeat(Math.abs(i)) + "*".repeat(n - (2*Math.abs(i))));
        }
    }