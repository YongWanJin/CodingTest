
// https://school.programmers.co.kr/learn/courses/30/lessons/120844?language=java
// 문제2 - 배열 회전시키기
// : 배열

import java.util.*;

// 나의 풀이1
// : 배열의 입출력 사용 (index 사용)
// * 속도는 0.02ms ~ 0.03ms대 나옴
class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        int len = numbers.length;
        answer = new int[len];
        if (direction.equals("right")) {
            answer[0] = numbers[len-1];
            for(int i = 1; i<len; i++){
                answer[i] = numbers[i-1];
            }
        } else {
            for(int i = 0; i<len-1; i++){
                answer[i] = numbers[i+1];
            }
            answer[answer.length-1] = numbers[0];
        }
        return answer;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n1 = {1, 2, 3};
        String d1 = "right";
        System.out.println(Arrays.toString(s.solution(n1, d1)));
        int[] n2 = {4, 455, 6, 4, -1, 45, 6};
        String d2 = "left";
        System.out.println(Arrays.toString(s.solution(n2, d2)));
    }
}
