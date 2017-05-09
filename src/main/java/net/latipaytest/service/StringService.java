package net.latipaytest.service;

import org.springframework.stereotype.Service;

import net.latipaytest.util.StringHandler;

/**
 * @author adriano
 */
@Service
public class StringService {

	private static final String template = "The letters are: ‘%s’. The most frequent letter is ‘%s’, and the frequency is %s";
	
	public String process(String input) {
        StringHandler handler = new StringHandler(input);

        return String.format(template, handler.getLetters(), handler.getMostFrequentChar(), handler.getFrequency());
    }
}
