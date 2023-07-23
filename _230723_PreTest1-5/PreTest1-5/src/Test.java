import java.util.*;

class Prime{

    // * 소수 판별하는 배열 (false 기준)
    // - index값이 <소수>이면 해당 인덱스에 <false> 저장,
    // 그렇지 않으면 true 저장.
    boolean[] prime;

    // # n 이하의 소수 생성 메서드
    public void makePrimes(int n) {
        prime = new boolean[n+1];
        prime[0] = prime[1] = true;

        if(n<2){
            return;
        }

        // 에라토스테네스의 체 가동
        // (소수가 아닌 인덱스는 체로 걸러졌다는 의미에서 true)
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (prime[i]==true){
                continue;
            }
            for(int j = 2; j<prime.length; j++){
                if (i*j > n) break;
                prime[i*j] = true;
            }
        }

        // 결과 출력
        System.out.printf("\n# %d이하의 소수들 : \n", n);
        for(int i = 0; i<prime.length; i++){
            if (prime[i]==false){
                System.out.print(i + " ");
            }
        }
    }

    // # n이 소수인지 아닌지 판별
    public void isPrime(int n){
        // 배열 prime 초기화
        prime = new boolean[n+1];
        prime[0] = prime[1] = true;
        if (n<2) return;

        // 에라스토테네스의 체 가동
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (prime[i]==true){
                continue;
            }
            for(int j = 2; j < prime.length; j++){
                if(i*j > n) break;
                prime[i*j] = true;
            }
        }

        // 결과 출력
        if (prime[n]==false){
            System.out.printf("\n# %d는 소수입니다.", n);
        } else {
            System.out.printf("\n# %d는 소수가 아닙니다.", n);
            System.out.printf("\n%d의 약수들 : \n", n);
            int[] divisors = this.makeDivisors(n);
            for(int divisor : divisors){
                System.out.print(divisor + " ");
            }
        }
    }

    // # n의 약수를 구하는 메서드
    private int[] makeDivisors(int n){
        ArrayList<Integer> divisors = new ArrayList<>();
        int[] result;

        int pair;
        int i = 0;
        while(true){
            i++;
            if (i > n) break;
            if (n%i == 0){
                pair = n/i;
                if (pair == i){
                    divisors.add(i);
                } else if (pair > i){
                    divisors.add(i);
                    divisors.add(pair);
                } else {
                    break;
                }
            }
        }
        divisors.sort(Comparator.naturalOrder());
        result = new int[divisors.size()];
        i = 0;
        for (int divisor : divisors) {
            result[i] = divisor;
            i++;
        }
        return result;
    }

}


public class Test {
    public static void main(String[] args) {
        Prime p = new Prime();

        // # n 이하의 소수 생성 메서드
        p.makePrimes(120);

        // # n이 소수인지 아닌지 판별
        p.isPrime(113);
        p.isPrime(81);

    }
}
