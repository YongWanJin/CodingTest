
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/120896?language=java
// ### 한 번만 등장한 문자
// : 한 번만 등장한 문자를 사전 순으로 정렬
// * 해시 테이블 관련

// # 나의 풀이
// : Hash Table, Set, List 객체 사용
class Solution {
    public String solution(String s) {
        String answer = "";
        HashSet<String> keys = new HashSet<>();
        HashMap<String, Integer> hashTable = new HashMap<>();
        ArrayList<String> keysOnlyOne = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(String letter : s.split("")){
            if (keys.contains(letter)) continue;
            keys.add(letter);
        }
        for(String key : keys) {
            hashTable.put(key, 0);
        }

        for(String key : s.split("")) {
            if (hashTable.get(key) >= 2) continue;
            hashTable.put(key, hashTable.get(key)+1);
        }

        for(Map.Entry<String, Integer> entry : hashTable.entrySet()){
            if (entry.getValue() == 1) {
                keysOnlyOne.add(entry.getKey());
            }
        }

        if(keysOnlyOne.size()==0) return answer;
        keysOnlyOne.sort(Comparator.naturalOrder());
        for(String key : keysOnlyOne){
            sb.append(key);
        }
        answer = sb.toString();
        return answer;
    }
}

// # 다른 사람의 풀이1
// : char를 아스키코드로 변환하여 계산
//
// * 매우 빠른 속도 (0.04ms)
// : 문자를 다루지 않고 정수 계산만 하기 때문에 속도가 빠르다.
class Solution2 {
    public String solution(String s) {
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
//            System.out.println(c + " - 'a' = " + (c-'a'));
            alpha[c - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++){
            if(alpha[i] == 1) {
                answer.append( (char)(i + 'a') );
            }
        }
        return answer.toString();
    }
}

public class Exercise {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution("abcabcadc")); // d
        System.out.println(s.solution("abcd"));      // abcd
        System.out.println(s.solution("hello"));     // eho
        System.out.println(s.solution("aaabbbccc")); //
    }
}
