package com.test.palindromeapi.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.palindromeapi.data.FileLoader;




@Service
public class PalindromeService {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private String file;
	FileLoader fl=new FileLoader();
	@Autowired
	PalindromeFactory pf;
	@PostConstruct
	public void loadFile() throws IOException {
		LOGGER.info("loadFile");
	file= fl.fileReader("https://janelwashere.com/files/bible_daily.txt");
	}

	public PalindromeData getPalindromeData() throws IOException {
		return pf.analyseText(file);
	}

}
