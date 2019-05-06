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
	public String getTranslation() {
		String list = "";
		for(String s : translation) {
			list += s+"\n";
		}
		return list;
	}
	
	public void addTranslation(String translations) {
		if (!translation.contains(translations)) {
			translation.add(translations);
		}
	}
	
	public boolean compareWild(String alienWild) {
		if (alienWord.matches(alienWild))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
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
