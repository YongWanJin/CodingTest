
import java.util.*;

// # 1번 문제
class Solution {
    public String solution(String s) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String letter : s.split("")){
            hashMap.put(letter, 0);
        }
        for (String letter : s.split("")){
            hashMap.put(letter, hashMap.get(letter)+1);
        }

        Integer[] nums = hashMap.values().toArray(new Integer[0]);
        Arrays.sort(nums, Collections.reverseOrder());
        int maxNum = nums[0];

        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if (entry.getValue() == maxNum){
                list.add(entry.getKey());
            }
        }
        list.sort(Comparator.naturalOrder());
        answer = list.get(0);
        return answer;
    }
}

// # 2번 문제 : 소수 구하기
class Solution2 {
    public boolean solution(int n) {
        boolean answer = true;
        for(int i = 3; i<n; i = i+2){
            if (n%2 == 0){
                answer = false;
                break;
            }
            if (n%i == 0){
                answer = false;
                break;
            }
        }
        return answer;
    }
}


// # 3번 : 문자열 거꾸로 출력
// Stack 자료구조 활용
class Solution3 {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for(String letter : s.split("")){
            list.add(letter);
        }
        for(int i = list.size()-1; i>=0; i--){
            sb.append(list.get(i));
        }
        answer = sb.toString();
        return answer;
    }
}

// * 풀이2
// StringBuilder의 메서드 reverse 사용
class Solution3_2 {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(String letter : s.split("")){
            sb.append(letter);
        }
        sb.reverse();
        answer = sb.toString();
        return answer;
    }
}


// # 4번
class Solution4 {
    public int solution(int n) {
        int answer = 0;
        double root = Math.sqrt(n);
        if ( (root) % ((int) root) == 0 ) {
            answer = (int) root;
        }
        return answer;
    }
}


// # 5번
class Solution5 {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (String letter : s.split("")){
            if(letter == letter.toUpperCase()){
                sb.append(letter.toLowerCase());
            } else {
                sb.append(letter.toUpperCase());
            }
        }
        answer = sb.toString();
        return answer;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.solution("Naver"));

    }
}


// [ 풀면서 느낀점들 ]

// # 1번
// * Hash Table에서 가장 큰 value와 그에 대응되는 key값 찾는 로직
// 1) Hash Table 생성(key:문자  value:출현 빈도수)
// 2) value들 중 가장 큰 value 찾기
// value만 따로 추출하여 배열 생성 -> Arrays.sort() 매서드로 크기 순 정렬 -> 맨 첫번째 value 추출
// 3) Entry객체를 통해 해당 value에 대응하는 key값 찾기
// Entry객체의 value가 2)에서 추출한 값과 일치할때까지 for문 돌리기
// -> 일치하면, 해당 Entry객체의 key값을 조회


// # 2번
// 나의 코드로는 숫자가 너무 커지면(1 <= n <= 10000000) 계산 시간 너무 오래걸림.
// 어떻게 방법이 없을까?
//
// https://st-lab.tistory.com/81



// # 4번
// * 나는 어떤 아이디어를 사용하였나?
// 즉, 정수인지 아닌지를 어떻게 판별하였나?
// (판별할 수) ÷ (판별할 수의 정수 부분) 의 나머지가
// 0이다 => 정수
// 0이 아니다 => 실수