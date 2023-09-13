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
        List<Integer> list = generateNumbers(numbers);
        return getPrimes(0, list).size();
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

    private static Set<Integer> getPrimes(int acc, List<Integer> numbers) {
        Set<Integer> primes = new HashSet<>();
        if (isPrime(acc)) {
            primes.add(acc);
        }

        for (int i = 0; i < numbers.size(); i++) {
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            primes.addAll(getPrimes(nextAcc, nextNumbers));
        }
        return primes;
    }

    public static List<Integer> generateNumbers(String numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            list.add(numbers.charAt(i) - '0');
        }
        return list;
    }
}
