import java.util.*;

// 나의 풀이1
// : List -> Array 형변환을 stream을 거쳐서 함
// => Stream 객체를 거쳐서 그런지 성능이 아쉬움.(1~2ms 속도)
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if (arr[i]%divisor == 0) {
                nums.add(arr[i]);
            }
        }
        if(nums.size()==0){
            nums.add(-1);
        }

        Collections.sort(nums);
        answer = nums.stream().mapToInt(x->x).toArray();
        return answer;
    }
}

// 나의 풀이2
// : List -> Array 형변환을 for문 돌려서 함.
// => 나의 풀이1 보다 성능이 훨씬 좋다. (0.2 ~ 1ms 속도)
class Solution2 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if (arr[i]%divisor == 0) {
                nums.add(arr[i]);
            }
        }
        if(nums.size()==0){
            nums.add(-1);
        }

        Collections.sort(nums);
        answer = new int[nums.size()];
        for (int i = 0; i<answer.length; i++){
            answer[i] = nums.get(i);
        }
        return answer;
    }
}

// 다른 사람의 풀이1
// : 가장 간단한 코드
class SolutionAnother1 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if (answer.length==0) answer = new int[] {-1};
        Arrays.sort(answer);
        return answer;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a1 = {5, 9, 7, 10};
        System.out.println(Arrays.toString(s.solution(a1, 5)));
        int[] a2 = {2, 36, 1, 3};
        System.out.println(Arrays.toString(s.solution(a2, 1)));
        int[] a3 = {3, 2, 6};
        System.out.println(Arrays.toString(s.solution(a3, 10)));
    }
}

// [ 느낀 점 ]

// List -> Array 형변환은 역시 무식하게 for문 돌려서 하는게 속도 제일 좋다.