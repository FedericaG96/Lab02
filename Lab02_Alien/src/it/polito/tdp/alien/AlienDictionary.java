/**
 * 
 */
package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> parole = new LinkedList<WordEnhanced>();
	private int numRis;

	public void addWord (String alienWord, String translation) {
		WordEnhanced w = new WordEnhanced(alienWord, translation);
		boolean trovato= false;
		for(WordEnhanced p : parole) {
			if(w.equals(p)==true) {
				p.addTranslation(translation);
				trovato = true;
			}
		}
		if(!trovato) {
			parole.add(w);
			w.addTranslation(translation);
		}
		
	}
	
	public String translateWord(String alienWord) {
		
		numRis = 0;
		if(alienWord.contains(".")) {
			
		}
		WordEnhanced w = new WordEnhanced (alienWord);
		for(WordEnhanced p : parole) {
			if(w.equals(p)==true) {
				return p.getTanslation();
			}
		}
		return null;
	}
	
	public void cancellaDizionario() {
		parole.clear();
	}
}
