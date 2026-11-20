
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        generate(digits, 0, "", map, ans);

        return ans;
    }

    void generate(String digits, int index, String temp,
                  String[] map, List<String> ans) {

        if (index == digits.length()) {
            ans.add(temp);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            generate(digits, index + 1,
                     temp + letters.charAt(i), map, ans);
        }
    }
}
