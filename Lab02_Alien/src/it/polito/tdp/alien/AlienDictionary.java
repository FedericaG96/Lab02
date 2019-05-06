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
		
		WordEnhanced w = new WordEnhanced (alienWord);
		for(WordEnhanced p : parole) {
			if(w.equals(p)==true) {
				return p.getTranslation();
			}
		}
		return null;
	}
	
	public void cancellaDizionario() {
		parole.clear();
	}

	public String translateWordWildCard(String alienWildCard) {
		
		// Utilizzo le regual expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere
		
		alienWildCard = alienWildCard.replaceAll("\\?", ".");
		int  matchCounter = 0;
		String risultato = "";
		//StringBuilder sb = new StringBuilder();
		
		for(WordEnhanced p : parole) {
			if(p.compareWild(alienWildCard)) {
				matchCounter++;
				risultato += p.getTranslation() + "\n";
			//	sb.append(p.getTranslation() + "\n");
			}
		}
		
		if (matchCounter != 0)
			//return sb.toString();
			return risultato;
		else
			return null;
	}
}
