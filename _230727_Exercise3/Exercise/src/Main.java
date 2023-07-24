// https://www.acmicpc.net/problem/5613
// 문제 3 - 계산기 프로그램
// 구현

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        int num1;
        int num2;
        String opr ;
        int result;

        // 최초의 수 입력
        input = br.readLine();
        num1 = Integer.parseInt(input);
        result = num1;
        while(true){
            // 연산자 입력
            input = br.readLine();
            opr = input;
            if (opr.equals("=")){
                System.out.println(result);
                break;
            } else if (opr.equals("/") && num1<0){
                continue;
            }
            // 그 다음 수 입력
            input = br.readLine();
            num2 = Integer.parseInt(input);
            if (opr.equals("+")) {
                result = num1 + num2;
            } else if (opr.equals("-")){
                result = num1 - num2;
            } else if (opr.equals("*")){
                result = num1 * num2;
            } else if (opr.equals("/")){
                result = num1 / num2;
            }
            num1 = result;
        }
    }
}
