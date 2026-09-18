import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for (int index = 1; index < intervals.length; index++) {
            int nextStart = intervals[index][0];
            int nextEnd = intervals[index][1];

            if (nextStart <= currentEnd) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                mergedIntervals.add(new int[]{currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        mergedIntervals.add(new int[]{currentStart, currentEnd});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
