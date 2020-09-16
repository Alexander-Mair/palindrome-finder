package com.test.palindromeapi.service;

import java.util.List;

public class PalindromeData {
	private int noOfPalindromes;
	private List<String> longestPalidromes;
	private List<String> modalPalindromes;
	public PalindromeData(int noOfPalindromes, List<String> longestPalidromes, List<String> modalPalindromes,
			List<PalindromeFrequency> pfList) {
		super();
		this.noOfPalindromes = noOfPalindromes;
		this.longestPalidromes = longestPalidromes;
		this.modalPalindromes = modalPalindromes;
		this.pfList = pfList;
	}

	

	private List<PalindromeFrequency> pfList;

	

	public int getNoOfPalindromes() {
		return noOfPalindromes;
	}

	public void setNoOfPalindromes(int noOfPalindromes) {
		this.noOfPalindromes = noOfPalindromes;
	}

	public List<PalindromeFrequency> getPalindromeFrequency() {
		return pfList;
	}

	public void setPalindromeFrequency(List<PalindromeFrequency> pfList) {
		this.pfList = pfList;
	}

	public List<String> getLongestPalidromes() {
		return longestPalidromes;
	}

	public void setLongestPalidromes(List<String> longestPalidromes) {
		this.longestPalidromes = longestPalidromes;
	}

	public List<String> getModalPalindromes() {
		return modalPalindromes;
	}

	public void setModalPalindromes(List<String> modalPalindromes) {
		this.modalPalindromes = modalPalindromes;
	}
	
	
	
	
	

}
