class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            // Add half of the occurrences to the first half
            for (int j = 0; j < freq[i] / 2; j++) {
                firstHalf.append((char) ('a' + i));
            }

            // Store the middle character (if frequency is odd)
            if ((freq[i] & 1) == 1) {
                middle = String.valueOf((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(firstHalf);
        result.append(middle);
        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }
}