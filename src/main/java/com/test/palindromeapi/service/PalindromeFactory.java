package com.test.palindromeapi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PalindromeFactory {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	 
	public PalindromeData analyseText(String sentence) {
		
		LOGGER.info("analyseText started");
		List<String> palindromes = extractWordsFromSentence(sentence);
		HashSet<String> uniquePalindromes=new HashSet<String>();
		List<PalindromeFrequency> pfList=new ArrayList<PalindromeFrequency>();
		for(String p:palindromes) {
			uniquePalindromes.add(p);
		}
		for(String up:uniquePalindromes) {
			int upFrequency=0;
			pfList.add(new PalindromeFrequency(up, upFrequency));
			for(String p:palindromes) {
				if(p.equals(up)) {
					upFrequency++;
					pfList.get(pfList.size()-1).setFreqency(upFrequency);
					LOGGER.info(up+": "+upFrequency);
					
				}
			}
		}
		int maxFreq=0;
		for(PalindromeFrequency pf:pfList) {
			if(pf.getFreqency()>maxFreq) {
				maxFreq=pf.getFreqency();
			}
			
		}
		List<String>modalPalindromes=new ArrayList<String>();
		for(PalindromeFrequency pf:pfList) {
			if(pf.getFreqency()==maxFreq) {
				modalPalindromes.add(pf.getPalindrome());
			}
			
		}
		List<String> longestPalindromes=new ArrayList<String>();
		int maxLen=0;
		for(String up:uniquePalindromes) {
			if(up.length()>maxLen) {
				maxLen=up.length();
			}
		}
		for(String up:uniquePalindromes) {
			if(up.length()==maxLen) {
				longestPalindromes.add(up);
			}
		}
		return new PalindromeData(palindromes.size(),longestPalindromes, modalPalindromes, pfList );
	}
	
	
	
	
	private List<String> extractWordsFromSentence(String sentence) {
		LOGGER.info("extractWordsFromSentence started");
		sentence = sentence.replaceAll("/(?=[a-zA-Z])", " ");

		String[] words = sentence.split(" |\n");
		List<String> trimmedWords = new ArrayList<String>();
		for (String word : words) {
			
			while (word.matches("^[^a-zA-Z�$].*$|^.*[^a-zA-Z%]$") && !word.matches("^[&+-=]$")) {
				word = word.replaceAll("^[^a-zA-Z�$]|[^a-zA-Z%]$", "");
				

			}

			if (word.length() > 1 && isPalindrome(word)) {
				
				String trimmedWord = word;
				trimmedWords.add(trimmedWord);
			}
		}
		return trimmedWords;
	}

	private static boolean isPalindrome(String origString) {
		
		StringBuilder origSB = new StringBuilder(origString);
		String reverseString = new StringBuilder(origString).reverse().toString();
		// Check palindrome string
		return origSB.toString().equalsIgnoreCase(reverseString.toString());

	}
}
