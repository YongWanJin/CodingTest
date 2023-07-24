// https://school.programmers.co.kr/learn/courses/30/lessons/120908
// 문제4 - 문자열 안에 문자열
// 문자열

import java.util.regex.*;

// # 나의 풀이 1 : 정규표현식 객체 사용
// * 걸리는 시간 : 0.10 ~ 1.68ms
class Solution {
    public int solution(String str1, String str2) {
        Pattern pat = Pattern.compile(str2);
        Matcher mat = pat.matcher(str1);
        if(mat.find()){
            return 1;
        } else {
            return 2;
        }
    }
}

// # 나의 풀이 2 : 정규표현식 대신 StringBuilder 객체 사용해서 풀기
// * 걸리는 시간 : 0.02 ~ 0.07 ms
class Solution2 {
    public int solution(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);
        if (sb1.indexOf(str2) == -1){
            return 2;
        } else {
            return 1;
        }
    }
}

// # 다른 사람의 풀이 : 한줄로 해결
// * 걸리는 시간 : 0.02 ~ 0.07 ms
class SolutionAnother {
    public int solution(String str1, String str2) {
        return (str1.contains(str2) ? 1 : 2);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution("ab6CDE443fgh22iJKlmn1o", "6CD")); // 1
        System.out.println(s.solution("ppprrrogrammers", "pppp"));  // 2
        System.out.println(s.solution("AbcAbcA", "AAA"));           // 2
    }
}
