
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        for (int mask = 0; mask < (1 << n); mask++) {

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }

            result.add(temp);
        }

        return result;
    }
}
