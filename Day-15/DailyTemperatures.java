import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> decreasingStack = new ArrayDeque<>();

        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            while (!decreasingStack.isEmpty()
                    && temperatures[currentDay] > temperatures[decreasingStack.peek()]) {
                int previousDay = decreasingStack.pop();
                answer[previousDay] = currentDay - previousDay;
            }

            decreasingStack.push(currentDay);
        }

        return answer;
    }
}
