package com.test.palindromeapi.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.palindromeapi.service.PalindromeData;
import com.test.palindromeapi.service.PalindromeService;

@RestController
@RequestMapping("/palindrome")
public class Controller {
	
@Autowired
	PalindromeService ps;
final Logger LOGGER = LoggerFactory.getLogger(getClass());
@RequestMapping(method = RequestMethod.GET)
@ResponseBody PalindromeData sendPalindromeData() throws IOException{
	LOGGER.info("sendPalindromeData");
	PalindromeData pd= ps.getPalindromeData();
	return pd;
}

}
