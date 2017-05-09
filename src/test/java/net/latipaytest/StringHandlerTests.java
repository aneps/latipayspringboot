package net.latipaytest;

import static org.junit.Assert.assertEquals;
import net.latipaytest.util.StringHandler;

import org.junit.Before;
import org.junit.Test;

/**
 * @author adriano
 */
public class StringHandlerTests {

    private String defaultInput = "as-dA@e32ar4As9";
    private String onlyInvalidCharInput = "123123(*&^(&*^*";
    StringHandler handler;

    @Before
    public void setUp(){
        handler = new StringHandler(defaultInput);
    }

    @Test
    public void testOnlyLetters(){
        assertEquals("Only the letters from the string are expected","asdAearAs", handler.getLetters());
        assertEquals("Expect empty string when only invalid characters","", new StringHandler(onlyInvalidCharInput).getLetters());
    }

    @Test
    public void testMostFrequentChar(){
        assertEquals("The most frequent char must be returned. In this case must be 'a'", "a", handler.getMostFrequentChar());
        assertEquals("Expect empty string when only invalid characters","", new StringHandler(onlyInvalidCharInput).getMostFrequentChar());
    }

    @Test
    public void testFrequency(){
        assertEquals("4 occur is expected from the default input", Long.valueOf(4), handler.getFrequency());
        assertEquals("No occur is expected when the value is invalid", Long.valueOf(0), new StringHandler(onlyInvalidCharInput).getFrequency());
    }
}
