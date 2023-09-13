import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Problem     소수 찾기 (lv2)
 * @Url         https://programmers.co.kr/learn/courses/30/lessons/42839
 * @Date        2023-09-13
 */
class Solution {
    public static int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        List<Integer> list = generateNumbers(numbers);
        getPrimes(0, list, primes);
        return primes.size();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

   /**
     * @param acc     누적된 숫자
     * @param numbers 남은 숫자
     * @param primes  소수를 담을 Set
     */
    private static void getPrimes(int acc, List<Integer> numbers, Set<Integer> primes) {
        if (isPrime(acc)) { // 소수인 경우
            primes.add(acc);
        }

        for (int i = 0; i < numbers.size(); i++) { // 남은 숫자들을 하나씩 더해본다.
            int nextAcc = acc * 10 + numbers.get(i); // 누적된 숫자에 다음 숫자를 더한다.
            List<Integer> nextNumbers = new ArrayList<>(numbers); // 남은 숫자들을 복사한다.
            nextNumbers.remove(i); // 더한 숫자를 제거한다. (중복 방지)
            getPrimes(nextAcc, nextNumbers, primes); // 방금 사용한 숫자를 제외한 남은 숫자들로 재귀 호출
        }
    }

    public static List<Integer> generateNumbers(String numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            list.add(numbers.charAt(i) - '0');
        }
        return list;
    }
}
