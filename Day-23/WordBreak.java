import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String text, List<String> dictionary) {
        Set<String> words = new HashSet<>(dictionary);
        boolean[] canBreak = new boolean[text.length() + 1];
        canBreak[0] = true;

        for (int end = 1; end <= text.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (canBreak[start] && words.contains(text.substring(start, end))) {
                    canBreak[end] = true;
                    break;
                }
            }
        }

        return canBreak[text.length()];
    }
}