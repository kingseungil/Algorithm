class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        
        for (char c : s.toCharArray()) {
            switch (c) {
                    case 'p','P' -> pCount++;
                    case 'y','Y' -> yCount++;
            }
        }
        
        if (pCount != yCount) {
            answer = false;
        }

        return answer;
    }
}