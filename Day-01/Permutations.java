import java.util.*;

public class Permutations {

    static List<List<Integer>> ans = new ArrayList<>();

    static void fun(List<Integer> nums, List<Integer> temp) {
        if (nums.size() == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> remaining = new ArrayList<>(nums);
            List<Integer> current = new ArrayList<>(temp);

            current.add(remaining.get(i));
            remaining.remove(i);

            fun(remaining, current);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        fun(list, new ArrayList<>());
        System.out.println(ans);
    }
}
