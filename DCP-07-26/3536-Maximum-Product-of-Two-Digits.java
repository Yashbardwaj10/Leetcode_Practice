class Solution {
    public int maxProduct(int n) {
        String s = Integer.toString(n);
        int first = 0, second = 0; // first >= second, both are max digit values found
        
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit > first) {
                second = first;
                first = digit;
            } else if (digit > second) {
                second = digit;
            }
        }
        
        return first * second;
    }
}