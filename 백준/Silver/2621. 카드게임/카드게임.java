import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static Card[] cards = new Card[5];
    static int[] colorCount = new int[4]; // R, B, Y, G
    static int[] numberCount = new int[9];

    public static void main(String[] args) throws IOException {
        FastReader rd = new FastReader();
        for (int i = 0; i < 5; i++) {
            char color = rd.next().charAt(0);
            int number = rd.nextInt();
            cards[i] = new Card(color, number);
        }

        for (Card card : cards) {
            switch (card.color) {
                case 'R':
                    colorCount[0]++;
                    break;
                case 'B':
                    colorCount[1]++;
                    break;
                case 'Y':
                    colorCount[2]++;
                    break;
                case 'G':
                    colorCount[3]++;
                    break;
            }
            numberCount[card.number - 1]++;
        }
        Arrays.sort(cards);

        int max = Integer.MIN_VALUE;

        // 1. 모두 같은 색이면서 숫자가 연속적일 때
        if (isSameColor() && isSequence()) {
            max = cards[4].number + 900;
        }

        // 2. 4장의 숫자가 같은 경우
        for (int i = 0; i < numberCount.length; i++) {
            if (numberCount[i] == 4) {
                max = Math.max(max, (i + 1) + 800);
                break;
            }
        }

        // 3. 3장의 숫자가 같고 나머지 2장도 숫자가 같은 경우
        int three = 0;
        int two = 0;
        for (int i = 0; i < numberCount.length; i++) {
            if (numberCount[i] == 3) {
                three = i + 1;
            }
            if (numberCount[i] == 2) {
                two = i + 1;
            }
        }
        if (three != 0 && two != 0) {
            max = Math.max(max, three * 10 + two + 700);
        }

        // 4. 5장이 모두 같은 색
        if (isSameColor()) {
            max = Math.max(max, cards[4].number + 600);
        }

        // 5. 5장의 숫자가 연속적일 때
        if (isSequence()) {
            max = Math.max(max, cards[4].number + 500);
        }

        // 6. 3장의 숫자가 같을 때
        for (int i = 0; i < numberCount.length; i++) {
            if (numberCount[i] == 3) {
                max = Math.max(max, (i + 1) + 400);
                break;
            }
        }

        // 7. 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때
        int first = 0;
        int second = 0;
        for (int i = 0; i < numberCount.length; i++) {
            if (numberCount[i] == 2) {
                if (first == 0) {
                    first = i + 1;
                } else {
                    second = i + 1;
                }
            }
        }

        if (first != 0 && second != 0) {
            max = Math.max(max, second * 10 + first + 300);
        }

        // 8. 2장의 숫자가 같을 때
        for (int i = 0; i < numberCount.length; i++) {
            if (numberCount[i] == 2) {
                max = Math.max(max, (i + 1) + 200);
                break;
            }
        }

        // 9. 나머지
        max = Math.max(max, cards[4].number + 100);

        System.out.println(max);
    }


    private static boolean isSameColor() {
        return Arrays.stream(colorCount).anyMatch(count -> count == 5);
    }

    private static boolean isSequence() {
        for (int i = 0; i < 4; i++) {
            if (cards[i].number + 1 != cards[i + 1].number) {
                return false;
            }
        }
        return true;
    }


    static class Card implements Comparable<Card> {

        char color;
        int number;

        public Card(char color, int number) {
            this.color = color;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "color=" + color +
                    ", number=" + number +
                    '}';
        }

        @Override
        public int compareTo(Card o) {
            return this.number - o.number;
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
