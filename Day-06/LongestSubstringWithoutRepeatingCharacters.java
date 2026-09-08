import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    static int lengthOfLongestSubstring(String text) {
        HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < text.length(); right++) {
            char currentCharacter = text.charAt(right);

            if (lastSeenIndex.containsKey(currentCharacter)) {
                left = Math.max(left, lastSeenIndex.get(currentCharacter) + 1);
            }

            lastSeenIndex.put(currentCharacter, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String text = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(text));
    }
}
