package net.latipaytest.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author adriano
 */
public class StringHandler {

    private final String content;
    private Long frequency;
    private Character mostFrequentChar;
    private String letters;

    public StringHandler(String content) {
        this.content = content;
        process();
    }

    private void process() {
        processLetters();
        processFrequency();
    }

    private void processFrequency() {
        HashMap<Character, Long> charCount = new HashMap<Character, Long>();

        for (char character : letters.toLowerCase().toCharArray()) {
            Long charFrequency = charCount.get(character) == null ? 0L : charCount.get(character);

            charCount.put(character, charFrequency + 1);
        }

        if (!charCount.isEmpty()) {
            Map.Entry<Character, Long> mostFrequentEntry = Collections.max(charCount.entrySet(), Map.Entry.comparingByValue());

            this.mostFrequentChar = mostFrequentEntry.getKey();
            this.frequency = mostFrequentEntry.getValue();
        }

    }

    private void processLetters() {
        this.letters = extractLetters();
    }

    private String extractLetters() {
        return content.replaceAll("[^a-zA-Z]+", "");
    }

    public String getContent() {
        return content;
    }

    public Long getFrequency() {
        return Optional.ofNullable(frequency).orElse(0L);
    }

    public String getMostFrequentChar() {
        return Optional.ofNullable(mostFrequentChar).map(character -> character.toString()).orElse("");
    }

    public String getLetters() {
        return letters;
    }
}
