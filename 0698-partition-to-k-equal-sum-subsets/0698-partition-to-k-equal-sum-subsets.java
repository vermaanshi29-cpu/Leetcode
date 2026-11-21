
import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int x : nums) {
            sum += x;
        }

        if (sum % k != 0) return false;

        int target = sum / k;

        Arrays.sort(nums);

        if (nums[nums.length - 1] > target) return false;

        boolean[] used = new boolean[nums.length];

        return solve(nums, used, k, 0, 0, target);
    }

    boolean solve(int[] nums, boolean[] used, int k, int start,
                  int currSum, int target) {

        if (k == 1) return true;

        if (currSum == target) {
            return solve(nums, used, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;

            if (currSum + nums[i] > target) continue;

            if (i > start && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;

            if (solve(nums, used, k, i + 1,
                      currSum + nums[i], target)) {
                return true;
            }

            used[i] = false;

            if (currSum == 0) return false;
        }

        return false;
    }
}
