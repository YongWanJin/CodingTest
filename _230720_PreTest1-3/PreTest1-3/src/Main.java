import java.util.*;
import java.util.regex.*;

// 문제1
class Solution1 {
    public String solution(String s) {
        String answer = "";
        ArrayList<String> stack = new ArrayList<>();
        stack.add(s.substring(0, 1));
        s = s.substring(1);
        int top = 0;
        for(String letter : s.split("")){
            top++;
            if( top - 1 < 0){
                stack.add(letter);
            } else if(letter.equals(stack.get(top-1))){
                stack.remove(top-1);
                top = top-2;
            } else {
                stack.add(letter);
            }
        }
        answer = stack.toString().replaceAll("\\W", "");
        return answer;
    }
}


// 문제2
class Solution2 {
    public int solution(String S) {
        int answer = 0;
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> first = new ArrayList<>(Arrays.asList("(", "{", "[", "<"));
        ArrayList<String> last = new ArrayList<>(Arrays.asList(")", "}", "]", ">"));
        for(int i = 0; i<4; i++){
            hashMap.put(first.get(i), last.get(i));
            hashMap.put(last.get(i), first.get(i));
        }

        ArrayList<String> stack = new ArrayList<>();
        boolean flag = true;
        int top = -1;
        for(String bracekt : S.split("")){
            if(first.contains(bracekt)){
                stack.add(bracekt);
                top++;
            } else {
                if(top<0){
                    flag = false;
                    break;
                } else {
                    if(stack.get(top).equals(hashMap.get(bracekt))){
                        stack.remove(top);
                        top = top-1;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (flag) answer = 1;
        return answer;
    }
}


// 문제3
class Solution3 {
    public int solution(String S) {
        int answer = 1;
        String letters = S;
        while(true){
            ArrayList<String> stack = new ArrayList<>();
            int beforeLen = letters.length();
//            System.out.println(letters + "  ");
            int top = -1;
            for(String letter : letters.split("")){
//                System.out.print(letter + "  ");
                if(top==-1){
                    stack.add(letter);
//                    System.out.print(stack + "\n");
                    top++;
                } else if (stack.get(top).equals(letter)) {
                    stack.remove(top);
//                    System.out.print(stack + "\n");
                    top--;
                } else {
                    stack.add(letter);
//                    System.out.print(stack + "\n");
                    top++;
                }
            }
//            System.out.print(stack + "\n");
            int afterLen = stack.size();
            if (afterLen == 0) {
                break;
            } else {
                letters = "";
                for(String letter : stack) {
                    letters += letter;
                }
                if (beforeLen == afterLen) {
                    answer = 0;
                    break;
                }
            }
        }
        return answer;
    }
}


// 문제4
// 가장 고전했던 문제
class Solution4 {
    public int solution(String s) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        System.out.println(list);
        ArrayList<String> nums = new ArrayList<>(Arrays.asList(
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        ));

        int i = 0;
        String num = "";
        String opr = "";
        while(true){
            if (i == list.size()) break;
            if ((i==0)&&(list.get(0).equals("-"))){
//                System.out.println("1번조건");
                num += "-";
                i++;
            } else if(nums.contains(list.get(i))){
//                System.out.println("2번조건");
                while(true){
                    num += list.get(i);
                    i++;
                    if (i == list.size()){
                        answer = Integer.parseInt(num);
                        break;
                    }
                    if (!nums.contains(list.get(i))){
                        answer = Integer.parseInt(num);
                        break;
                    }
                }
            } else {
//                System.out.println("3번조건");
                opr = list.get(i);
                num = "";
                i++;
                while(true){
                    num += list.get(i);
                    i++;
                    if((i==list.size())) {
                        break;
                    }
                    if(!nums.contains(list.get(i))){
                        break;
                    }
                }
                if (opr.equals("+")){
                    answer += Integer.parseInt(num);
                } else {
                    answer -= Integer.parseInt(num);
                }
            }
        }
        return answer;
    }
}


// 문제5
// 너무 오래걸리는데? (10ms ~ 20ms)
class Solution5 {
    public String solution(String[] bj, String[] one, String[] two) {
        String answer = "";
        String winner = "";
        int price = 0;

        HashSet<String> bjSet = new HashSet<>(Arrays.asList(bj));
        HashSet<String> oneSet = new HashSet<>(Arrays.asList(one));
        HashSet<String> twoSet = new HashSet<>(Arrays.asList(two));
        HashSet<String> winnerSet = new HashSet<>(bjSet);
        winnerSet.removeAll(oneSet);
        winnerSet.removeAll(twoSet);
        winner = winnerSet.toString().replace("[", "").replace("]", "");

        price = 150*one.length + 300*two.length + 450;

        answer = price + "만원(" + winner + ")";
        return answer;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.solution("10+50-40+10-10"));  // 20
    }
}

// [ 풀면서 느꼈던 점 ]

// # 1번
// * Stack 자료구조 사용할때, top의 시작위치는 항상 -1부터.
// 그래야 나중에 pop() 구현할때 비교적 쉽게 구현할 수 있다.

// # 2번
// * Hash Table과 Stack 자료구조를 동시에 사용할 아이디어 꽤 좋았음!

// # 3번
// * 문제 1번에서 깨달은 것을 바로 적용한 것 좋았음!
// * 변수 이름 헷갈리지 말것.
// - 버그가 발생했던 주요 이유 : 다른 엉뚱한 변수를 쓰고있었는데 그 사실을 미처 발견하지 못함.

// # 4번
// * 나중에 보니 이것도 stack의 관점에서 구현할 수 있었음.
// * 변수 이름 헷갈리지 말것. 3번과 같은 현상을 겪었음.

// # 5번
// * 통과는 했다만... 정말 이렇게 간단하게 구하는 문제인가?
// 이 문제 출제 의도가 도대체 뭐지?
// * java의 정규표현식과 적용 방법에 대해 제대로 공부해둬야겠다.
// - 불필요한 문자열 처리를 위해
// replace를 여러번 쓰자니 번거롭고, for문을 쓰자니 효율이 떨어지는듯.
