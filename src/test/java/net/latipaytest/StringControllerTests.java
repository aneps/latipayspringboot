package net.latipaytest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author adriano
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StringControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMessageGet() throws Exception {
        this.mockMvc.perform(get("/checkFrequency").param("inputStr", "as-dA@e32ar4As9"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("The letters are: ‘asdAearAs’. The most frequent letter is ‘a’, and the frequency is 4"));
    }

    @Test
    public void testMessagePost() throws Exception {
        String jsonAsString = new JSONObject().put("inputStr", "as-dA@e32ar4As9").toString();

        this.mockMvc.perform(post("/checkFrequency").content(jsonAsString))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("The letters are: ‘asdAearAs’. The most frequent letter is ‘a’, and the frequency is 4"));
    }

}
