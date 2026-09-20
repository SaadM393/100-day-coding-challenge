import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String source, String target) {
        if (source == null || target == null || source.length() < target.length() || target.isEmpty()) {
            return "";
        }

        Map<Character, Integer> requiredCounts = new HashMap<>();
        for (char character : target.toCharArray()) {
            requiredCounts.put(character, requiredCounts.getOrDefault(character, 0) + 1);
        }

        Map<Character, Integer> windowCounts = new HashMap<>();
        int formedCharacters = 0;
        int left = 0;
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < source.length(); right++) {
            char rightCharacter = source.charAt(right);
            windowCounts.put(rightCharacter, windowCounts.getOrDefault(rightCharacter, 0) + 1);

            if (requiredCounts.containsKey(rightCharacter)
                    && windowCounts.get(rightCharacter) <= requiredCounts.get(rightCharacter)) {
                formedCharacters++;
            }

            while (formedCharacters == target.length()) {
                int currentLength = right - left + 1;
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestStart = left;
                }

                char leftCharacter = source.charAt(left);
                windowCounts.put(leftCharacter, windowCounts.get(leftCharacter) - 1);

                if (requiredCounts.containsKey(leftCharacter)
                        && windowCounts.get(leftCharacter) < requiredCounts.get(leftCharacter)) {
                    formedCharacters--;
                }
                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE ? "" : source.substring(bestStart, bestStart + bestLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "aa"));
    }
}
