class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;

        // Array to store last index of each character.
        int[] map = new int[256];

        // Initialize all to -1 (meaning: character not seen before)
        for (int i = 0; i < 256; i++) map[i] = -1;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character was already seen, move left pointer
            if (map[ch] != -1) {
                left = Math.max(left, map[ch] + 1);
            }

            // Update last seen index
            map[ch] = right;

            // Calculate window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}