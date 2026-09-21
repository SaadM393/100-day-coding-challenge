import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        Set<Integer> values = new HashSet<>();
        for (int number : numbers) {
            values.add(number);
        }

        int longestLength = 0;

        for (int number : values) {
            if (!values.contains(number - 1)) {
                int currentNumber = number;
                int currentLength = 1;

                while (values.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentLength++;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
