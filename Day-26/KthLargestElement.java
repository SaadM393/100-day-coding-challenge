import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int number : numbers) {
            minHeap.offer(number);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(numbers, k));
    }
}
