import java.util.PriorityQueue;

public class KthLargestElement {

    static int findKthLargest(int[] numbers, int k) {
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
