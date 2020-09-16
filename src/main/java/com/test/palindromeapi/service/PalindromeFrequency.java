package com.test.palindromeapi.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class PalindromeFrequency {
	String palindrome;
	int freqency;
	public PalindromeFrequency(String palindrome, int freqency) {
		super();
		this.palindrome = palindrome;
		this.freqency = freqency;
	}
	public String getPalindrome() {
		return palindrome;
	}
	public void setPalindrome(String palindrome) {
		this.palindrome = palindrome;
	}
	public int getFreqency() {
		return freqency;
	}
	public void setFreqency(int freqency) {
		this.freqency = freqency;
	}
	
}
