import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String strNumbers = Arrays.stream(numbers)
                                  .mapToObj(String::valueOf)
                                  .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                                  .collect(Collectors.joining());
        if (strNumbers.startsWith("0")) {
            return "0";
        }
        return strNumbers;
    }
}