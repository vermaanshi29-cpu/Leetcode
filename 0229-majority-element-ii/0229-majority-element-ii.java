
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean alreadyAdded = false;

            for (int j = 0; j < ans.size(); j++) {
                if (ans.get(j) == nums[i]) {
                    alreadyAdded = true;
                    break;
                }
            }

            if (alreadyAdded) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}
