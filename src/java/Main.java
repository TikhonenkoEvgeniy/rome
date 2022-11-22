import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean isTerminate = false;
        System.out.println("Input the number from 1 to 3000 (q - quiet from application):");
        while (!isTerminate) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String value = reader.readLine();
            if (value.equalsIgnoreCase("q")) { isTerminate = true; }
            else System.out.println(convert(Integer.parseInt(value)));
        }
    }

    private static String convert(int x) {
        int[] numbers = new int[] {1000, 500, 100, 50, 10, 5, 1};
        int[] numbers2 = new int[] {900, 400, 90, 40, 9, 4};
        String[] romes = new String[] {"M", "D", "C", "L", "X", "V", "I"};
        String[] romes2 = new String[] {"DM", "CD", "XC", "XL", "IX", "IV"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (x == 0) break;
            if (x < numbers[i]) {
                if (x >= numbers2[i]) {
                    x = x - numbers2[i];
                    result.append(romes2[i]);
                }
                continue;
            }
            int temp = x / numbers[i];
            result.append(repeat(romes[i], temp));
            x = x - temp * numbers[i];
        }
        return result.toString();
    }

    private static String repeat(String letter, int count) {
        return String.valueOf(letter).repeat(Math.max(0, count));
    }
}
