
class Solution {
    public int kthGrammar(int n, int k) {

        if (n == 1) {
            return 0;
        }

        // If k is even, take complement of parent
        if (k % 2 == 0) {
            return 1 - kthGrammar(n - 1, k / 2);
        }

        // If k is odd, same as parent
        return kthGrammar(n - 1, (k + 1) / 2);
    }
}
