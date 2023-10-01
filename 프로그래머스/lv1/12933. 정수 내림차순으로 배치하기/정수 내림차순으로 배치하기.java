import java.util.*;

class Solution {
    public long solution(long n) {
        List<Long> list = new ArrayList<>();

        int[] nints = String.valueOf(n).chars().map(c -> c - '0').toArray();

        for (int nint : nints) {
            list.add((long) nint);
        }

        list.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (Long aLong : list) {
            sb.append(aLong);
        }

        return Long.parseLong(sb.toString());
    }
}