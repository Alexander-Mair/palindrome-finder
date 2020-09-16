package com.test.palindromeapi;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.palindromeapi.service.PalindromeData;
import com.test.palindromeapi.service.PalindromeFactory;

@SpringBootTest
class PalindromeApiApplicationTests {

	PalindromeFactory pf = new PalindromeFactory();
	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Test()
	void analyseTextGivesCorrectResultForEmptyString() {
		PalindromeData pd = pf.analyseText("");
		assertTrue(pd.getLongestPalidromes().isEmpty() && pd.getModalPalindromes().isEmpty()
				&& pd.getNoOfPalindromes() == 0 && pd.getPalindromeFrequency().isEmpty());

	}

	@Test()
	void analyseTextGivesCorrectResultForStringContainingNumbersAndSingleLetterWords() {
		PalindromeData pd = pf.analyseText("11 88 32 12121 I a");
		assertTrue(pd.getLongestPalidromes().isEmpty() && pd.getModalPalindromes().isEmpty()
				&& pd.getNoOfPalindromes() == 0 && pd.getPalindromeFrequency().isEmpty());

	}

	@Test
	void analyseTextFindsModalAndLongestPalindromes() {
		PalindromeData pd = pf.analyseText("level sexes did did bob bob");
		List<String> longestPalindromes = Arrays.asList("level", "sexes");
		List<String> modalPalindromes = Arrays.asList("did", "bob");
		assertTrue(pd.getLongestPalidromes().containsAll(longestPalindromes)
				&& pd.getModalPalindromes().containsAll(modalPalindromes));

	}

}
