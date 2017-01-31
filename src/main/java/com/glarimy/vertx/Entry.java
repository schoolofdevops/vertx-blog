package com.glarimy.vertx;

import java.util.List;

public class Entry {
	private String word;
	private String meaning;
	private List<String> synonyms;

	public Entry(String word, String meaning, List<String> synonyms) {
		super();
		this.word = word;
		this.meaning = meaning;
		this.synonyms = synonyms;
	}

	public Entry() {
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public List<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}

	@Override
	public String toString() {
		return "Entry [word=" + word + ", meaning=" + meaning + ", synonyms=" + synonyms + "]";
	}

}