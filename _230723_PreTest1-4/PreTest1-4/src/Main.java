import java.util.*;

// # 1번 문제 : 아스키 코드를 문자열로 치환하는 기능 구현
class Solution {
    public String solution(int[] arr) {
        String answer = "";
        char letter;
        for(int num : arr){
            letter = (char) num;
            answer += Character.toString(letter);
        }
        return answer;
    }
}

// # 2번 문제 : 이진수 숫자들을 전부 차례대로 XOR 연산
class Solution2 {
    public int solution(String[] arr) {
        int answer = 0;
        final int DIGIT = 7;
        int num1 = Integer.parseInt(arr[0], 2);
        answer = num1;
        int num2 = 0;
        for(int i = 1; i<arr.length; i++){
            num2 = Integer.parseInt(arr[i], 2);
            answer = num1 ^ num2;
            num1 = answer;
        }
        return answer;
    }
}

// 3번 문제 : 양의 약수가 몇개인지 구하기
// 처음 풀이 : n이 큰 수가 나올때 엄청 오래걸림.
// (제약 사항 : 0 < n <= 100000000)
class Solution3 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++){
            if (n%i == 0){
                answer += 1;
            }
        }
        return answer;
    }
}
// 두번째 풀이 : 모든 수를 나누는 것이 아니라, 반만 시도.
// => 300ms에서 30ms대로 확 줄음.
class Solution3_2 {
    public int solution(int n) {
        int answer = 0;
        int pair;
        int i = 0;
        while(true){
            i++;
            if (i==n+1) break;
            if(n%i == 0){
                pair = n/i;
                if (pair < i){
                    break;
                } else if (pair == i) {
                    answer += 1;
                } else {
                    answer += 2;
                }
            }
        }
        return answer;
    }
}

// # 4번 : 16진수 -> 2진수
class Solution4{
    public String solution(String s) {
        String answer = "";
        int num;
        num = Integer.parseInt(s, 16);
        answer = Integer.toString(num, 2);
        return answer;
    }
}

// # 5번 : 문자열 배열의 원소들을 콤마로 합쳐서 하나의 문자열로 변환
// * 첫번째 풀이 : 오래걸림 (10ms대)
class Solution5 {
    public String solution(String[] arr) {
        String answer = "";
        for(String word : arr) {
            answer += word + ",";
        }
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}

// * 두번째 풀이
// : String 대신 StringBuilder 객체 사용
class Solution5_2 {
    public String solution(String[] arr) {
        String answer = "";
        StringBuilder temp = new StringBuilder();
        for(String word : arr) {
            temp.append(word);
            temp.append(",");
        }
        answer = temp.deleteCharAt(temp.length()-1).toString();
//        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution5_2 s = new Solution5_2();
//        int[] arr = {71, 111, 111, 103, 108, 101};
//        String[] arr = {"10110"};
        String[] arr = {"naver", "kakao", "abcd efg", "A, B, C", "google"};
        System.out.println(s.solution(arr));

    }
}

// [ 풀면서 배운점 & 궁금한 점 ]

// # 1번 문제
// * 아스키 코드 표 : https://stepbystep1.tistory.com/10
// * JAVA에서 문자(char)를 아스키 코드로 변환하는 방법 : https://devyoseph.tistory.com/43
// * 그렇다면 거꾸로 아스키 코드에서 문자(char)로 변환하는 방법은?
// int a = 71;
// char c = (char) a;
// System.out.println(c); // 문자 'G' 출력

// # 2번 문제
// * 이거 백준 '행성X3' 문제였는데... 아니었음. 더 간단한 문제였음.
// * 제약 사항을 잘 볼 것!
// 제약 사항 중 0 < arr.length <= 100이 있음.
// 즉, 입력받은 이진수 숫자가 1개일때에도 작동 되어야한다는 소리.
// 여기까지 고려해야 정답을 맞힐 수 있다.

// # 3번 문제
// * 잘한 점 : pair 변수를 도입하는 아이디어 좋았음!

// # 5번 문제
// * 『이펙티브 자바』, 「아이템 63」, p.366.
// 문자열을 연결할 때, String 객체에 연산자 +를 쓰는 것은 피할것. (시간복잡도가 O(n^2)임.)
// 대신 StringBuilder 객체의 매서드 append를 사용하면 속도가 훨씬 빠름.
