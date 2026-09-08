import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        
        // Map to store the last seen index of each character
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character was seen before and is within the current window, move the left pointer
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // Update the last seen position of the character
            charIndexMap.put(currentChar, right);

            // Calculate the window size and update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}