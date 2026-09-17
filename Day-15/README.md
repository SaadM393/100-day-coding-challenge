# Day 15 - Daily Temperatures

## Problem Title
Daily Temperatures (LeetCode 739)

## Problem Statement
Given an array `temperatures` where `temperatures[i]` is the temperature on day `i`, return an array `answer` such that `answer[i]` is the number of days you have to wait after day `i` to get a warmer temperature. If no future day has a warmer temperature, `answer[i]` should be `0`.

## Example Input
```text
[73, 74, 75, 71, 69, 72, 76, 73]
```

## Example Output
```text
[1, 1, 4, 2, 1, 1, 0, 0]
```

## Explanation
- Day 0 has temperature `73`; the next warmer day is day 1, so the answer is `1`.
- Day 2 has temperature `75`; the next warmer day is day 6, so the answer is `4`.
- Day 6 has temperature `76`; there is no warmer future day, so the answer is `0`.

The key difficulty is that for each day we need the first future temperature that is greater. A brute-force solution may repeatedly scan the same future days. Instead, we maintain unresolved days in a stack.

## Approach
1. Create an answer array filled with `0`.
2. Use a stack of day indices whose warmer day has not been found yet.
3. Traverse the temperatures from left to right.
4. While the current temperature is warmer than the temperature at the stack top:
   - Remove that earlier day from the stack.
   - The waiting time is `currentDay - previousDay`.
5. Push the current day onto the stack.
6. Any indices left in the stack never find a warmer future day, so their answers remain `0`.

The stack stores temperatures in decreasing order from bottom to top. This is the **monotonic decreasing stack** pattern.

## Java Solution Reference
See [`DailyTemperatures.java`](./DailyTemperatures.java).

```java
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
```

## Time Complexity
`O(N)` because every day index is pushed onto the stack once and popped at most once.

## Space Complexity
`O(N)` for the stack and the output array. The auxiliary stack itself uses `O(N)` space.

## Key Learning / Pattern
- Monotonic stack
- Next greater element pattern
- Store indices when distance or position matters
- Resolve multiple previous elements when a larger value appears
- Avoid repeated forward scanning with amortized `O(1)` stack operations