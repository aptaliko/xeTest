package classifiedcounter.services;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Classified {

	private String text;

	private int numOfWords;

	private String amount;

	public String getText() {
		return text;
	}

	@JsonSetter("Text")
	public void setText(String text) {
		this.text = text;
	}

	public int getNumOfWords() {
		return numOfWords;
	}

	@JsonSetter("Words")
	public void setNumOfWords(int numOfWords) {
		this.numOfWords = numOfWords;
	}

	public String getAmount() {
		return amount;
	}

	@JsonSetter("Amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}
}