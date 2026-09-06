import java.util.Arrays;

public class FirstAndLastPosition {

    static int findFirst(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int answer = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (numbers[middle] == target) {
                answer = middle;
                right = middle - 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return answer;
    }

    static int findLast(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int answer = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (numbers[middle] == target) {
                answer = middle;
                left = middle + 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return answer;
    }

    static int[] searchRange(int[] numbers, int target) {
        return new int[]{findFirst(numbers, target), findLast(numbers, target)};
    }

    public static void main(String[] args) {
        int[] numbers = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(numbers, target)));
    }
}
