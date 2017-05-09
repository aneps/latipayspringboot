package net.latipaytest.controller;

import net.latipaytest.service.StringService;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author adriano
 */
@RestController
public class StringController {

	@Autowired
	private StringService stringService;
	
    @RequestMapping("/checkFrequency")
    public @ResponseBody String checkFrequency(@RequestParam("inputStr") String input) {
        return stringService.process(input);
    }

    @PostMapping("/checkFrequency")
    public @ResponseBody String checkFrequencyPost(@RequestBody String input) throws JSONException {
        return stringService.process(new JSONObject(input).getString("inputStr"));
    }
}