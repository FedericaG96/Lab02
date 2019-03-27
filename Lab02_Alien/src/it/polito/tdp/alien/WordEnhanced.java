package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {


	private String alienWord;
	private LinkedList<String> translation = new LinkedList<String>();
	private String traduzione;
	
	public WordEnhanced(String alienWord,String translation) {
		this.alienWord = alienWord;
		this.traduzione= translation;
	}
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public String getAlienWord() {
		return alienWord;
	}
	public String getTanslation() {
		String list = "";
		for(String s : translation) {
			list += s+"\n";
		}
		return list;
	}
	
	public void addTranslation(String translations) {
		translation.add(translations);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
}
