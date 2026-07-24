import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> values = new HashSet<>();
        for (int x : nums) values.add(x);
        int[] a = new int[values.size()];
        int idx = 0;
        for (int x : values) a[idx++] = x;
        HashSet<Integer> ans = new HashSet<>();
        int m = a.length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                for (int k = j; k < m; k++) {
                    ans.add(a[i] ^ a[j] ^ a[k]);
                }
            }
        }
        return ans.size();
    }
}