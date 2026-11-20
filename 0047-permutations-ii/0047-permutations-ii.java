
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        generate(nums, 0, set);

        return new ArrayList<>(set);
    }

    void generate(int[] nums, int index, Set<List<Integer>> set) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int x : nums) {
                list.add(x);
            }

            set.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            swap(nums, index, i);

            generate(nums, index + 1, set);

            swap(nums, index, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
