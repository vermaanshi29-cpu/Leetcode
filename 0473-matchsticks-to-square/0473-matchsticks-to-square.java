
import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;

        long sum = 0;

        for (int x : matchsticks) {
            sum += x;
        }

        if (sum % 4 != 0) return false;

        long target = sum / 4;

        Arrays.sort(matchsticks);

        if (matchsticks[matchsticks.length - 1] > target)
            return false;

        long[] sides = new long[4];

        return solve(matchsticks, matchsticks.length - 1, sides, target);
    }

    boolean solve(int[] nums, int index, long[] sides, long target) {
        if (index < 0) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int curr = nums[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + curr > target) continue;

            if (i > 0 && sides[i] == sides[i - 1]) continue;

            sides[i] += curr;

            if (solve(nums, index - 1, sides, target))
                return true;

            sides[i] -= curr;

            if (sides[i] == 0) return false;
        }

        return false;
    }
}
