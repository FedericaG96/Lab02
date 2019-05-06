package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private String[] paroleAgg;
	private AlienDictionary alienDictionary = new AlienDictionary();
	
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	paroleAgg = txtWord.getText().split(" ");
    	String alienWord ;
    	String translation;
    	
    	txtWord.clear();
    	txtResult.clear();
    	
    	if(paroleAgg.length == 2) {
    		alienWord = paroleAgg[0].toLowerCase();
    		translation = paroleAgg[1].toLowerCase();
    	
    		if(alienWord.matches("[a-zA-Z]*")&& translation.matches("[a-zA-Z]*")) {
    			alienDictionary.addWord(alienWord, translation);
    			txtResult.setText("La parola: " + alienWord + " traduzione: " + translation + " è stata inserita.");
    		}
    		else {
    			txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
    		}
    	}
    	else if (paroleAgg.length == 1){
    		alienWord = paroleAgg[0].toLowerCase();
    		String traduzione;
    		
    		if (!alienWord.matches("[a-zA-Z?]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}
    		
    		if(alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {
    			// Traduzione con WildCard
    			traduzione = alienDictionary.translateWordWildCard(alienWord);
    		}
    		else {
    			// Traduzione classica
    			traduzione = alienDictionary.translateWord(alienWord);
    		}
    		
    		if (traduzione != null) {
    			txtResult.setText(traduzione);
    		}
    		else {
    			txtResult.setText("Parola non presente nel dizionario!");
    		}
    	}
    }
        
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    	alienDictionary.cancellaDizionario();
    }
    
}
