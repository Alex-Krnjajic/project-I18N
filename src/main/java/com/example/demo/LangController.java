package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
//Controller
@RestController
public class LangController {
	@Autowired
	private MessageSource messageSource;
//I18N 
	@GetMapping(path = "/I18N", produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloWorldInternationalized(String word, String word2, Boolean add,
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		String neWord = messageSource.getMessage(word, null, "no data", locale);
		String pattern = "{'in':'%s', 'out':'%s'}"; //JSON format
		
		if(add) {
			addWords append = new addWords();
			append.WritePropertiesFile(word, word2);//adds the two words to the 
			neWord = word2;							//messages_se.properties
		}
		
		try {
			return String.format(pattern, word, neWord);
		}
		catch (Exception e) {
			e.toString();
			System.out.println(e);
			return "error";
		}
		
	}
}