import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null) {
            return result;
        }

        Arrays.sort(numbers);
        buildSubsets(0, numbers, new ArrayList<>(), result);
        return result;
    }

    private void buildSubsets(int startIndex, int[] numbers,
                              List<Integer> currentSubset,
                              List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));

        for (int index = startIndex; index < numbers.length; index++) {
            if (index > startIndex && numbers[index] == numbers[index - 1]) {
                continue;
            }

            currentSubset.add(numbers[index]);
            buildSubsets(index + 1, numbers, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
