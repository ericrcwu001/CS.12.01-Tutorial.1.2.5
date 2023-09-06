public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) { // wordArr -> even-length array
        scrambledWords = mixedWords(wordArr);
    }

    private String recombine(String word1, String word2) {
        if (word1.contains(" ") || word2.contains(" ")) {
            throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
        }
        String word1Half = word1.substring(0, word1.length()/2);
        String word2Half = word2.substring(word2.length()/2, word2.length());
        return word1Half + word2Half;
    }

    private String[] mixedWords(String[] words) {
        if (words.length % 2 == 1) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        String[] ans = new String[words.length];
        for (int i = 0; i < words.length; i += 2) {
            ans[i] = recombine(words[i], words[i+1]);
            ans[i+1] = recombine(words[i+1], words[i]);
        }
        return ans;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}
