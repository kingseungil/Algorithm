import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filePath = System.getProperty("os.name").startsWith("Linux") ? "/dev/stdin" : System.getProperty("user.dir") + "/test.txt";

        ArrayList<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int t = Integer.parseInt(input.get(0));

        for (int i = 1; i <= t; i++) {
            ArrayList<Integer> fibo = generateFibonacci(Integer.parseInt(input.get(i)));
            ArrayList<Integer> result = findMinimumCases(fibo, Integer.parseInt(input.get(i)));
            result.sort(Integer::compareTo);
            System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    public static ArrayList<Integer> generateFibonacci(int num) {
        ArrayList<Integer> fibo = new ArrayList<>(Arrays.asList(0, 1));

        while (fibo.get(fibo.size() - 1) <= num) {
            int nextFibo = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2);
            fibo.add(nextFibo);
        }
        return new ArrayList<>(fibo.subList(0, fibo.size() - 1));
    }

    public static ArrayList<Integer> findMinimumCases(ArrayList<Integer> array, int num) {
        int currentNum = num;
        ArrayList<Integer> resultArray = new ArrayList<>();

        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i) <= currentNum) {
                resultArray.add(array.get(i));
                currentNum -= array.get(i);
                if (currentNum == 0) {
                    break;
                }
            }
        }

        return resultArray;
    }
}
