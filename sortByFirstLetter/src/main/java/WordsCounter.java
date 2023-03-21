import java.util.Arrays;
import java.util.Locale;
import java.util.TreeMap;

public class WordsCounter {

    private char firstLitWord;
    private char firstLitPreviousWord;
    private static final String REGEX_SYMBOLS = "[^\\w-'\\s]";
    private static final String REGEX_NUMBERS = "[0-9]";
    private static final String REGEX_SPLIT = "\\s+";
    private static final String INDENT = "   ";

    public String getWordsCount(String text) {
        if (text == null) {
            throw new IllegalStateException("Please input correct String, text can't be NULL");
        }

        return wordsCounting(text);
    }

    private String wordsCounting(String text) {
        String[] arrayWords = getStringToArray(text);
        TreeMap<String, Integer> wordsQuantity = new TreeMap<>();

        Arrays.stream(arrayWords).forEach(word -> {
            int quantity = wordsQuantity.getOrDefault(word, 0);
            wordsQuantity.put(word, quantity + 1);
        });

        wordsQuantity.forEach((word, quantity) -> {
            firstLitWord = word.toUpperCase(Locale.ROOT).charAt(0);
            if (firstLitWord == firstLitPreviousWord) {
                System.out.print(INDENT);
            } else {
                System.out.print(word.toUpperCase(Locale.ROOT).charAt(0) + ":" + " ");
                firstLitPreviousWord = firstLitWord;
            }
            System.out.println(word + " - " + quantity);
        });
        return wordsQuantity.toString();
    }

    private String[] getStringToArray(String text) {
        String processedText = text.replaceAll(REGEX_SYMBOLS, "");
        processedText = processedText.replaceAll(REGEX_NUMBERS, "");

        String[] words = processedText.toLowerCase(Locale.ROOT).split(REGEX_SPLIT);

        return words;
    }

}