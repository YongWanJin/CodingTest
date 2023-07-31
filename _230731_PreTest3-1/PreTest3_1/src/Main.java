// https://www.acmicpc.net/problem/1254
// 백준 1254번 : 팰린드롬 만들기

import java.util.*;
import java.io.*;

public class Main {

    // ### 팰린드롬 판별 메서드
    public static boolean isParied(String[] arr){
        int len = arr.length;
        for(int i = 0; i<len/2; i++){
            if (arr[i].equals(arr[len-1-i])){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len = s.length();
        String[] arr = new String[len];
        int a = 0;
        for(String letter : s.split("")){
            arr[a] = letter;
            a++;
        }

        // ### 이미 그 자체로 팰린드롬일때
        if (isParied(arr)){
            System.out.println(len);
            return;
        }

        // ### 그렇지 않을 때
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        for(int i = 0; i<list.size(); i++){
            list = new ArrayList<>(Arrays.asList(arr));
            for (int j = i; j >= 0; j--){
                list.add(list.get(j));
            }
            if(isParied(list.toArray(new String[0]))){
                System.out.println(list.size());
                break;
            }
        }
    }
}

// # for문에서도 무한루프에 걸릴 수 있다. 조심하자.
