
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        generate(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    void generate(String s, int index, List<String> temp,
                  List<List<String>> ans) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                temp.add(s.substring(index, i + 1));

                generate(s, i + 1, temp, ans);

                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
