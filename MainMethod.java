// Caesar Cipher
// Sarthak Gupta
// 4/18/2020

// Description: Main method creates the JavaFX GUI based program. 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MainMethod extends Application {

	private TabPane tabPane;
	
	private GridPane encryptBox;
	
	private TextArea enteredText;
	private TextField enteredKey1;
	private TextField enteredKey2;
	
	private Label encryptedInst1;
	private TextArea encryptedText1;
	private Label encryptedInst2;
	private TextArea encryptedText2;

	private GridPane decryptBox;
	
	private TextArea enteredDText;
	
	private Label decryptMessage;
	
	private Label decryptedInst1;
	private TextArea decryptedText1;
	private Label decryptedInst2;
	private TextArea decryptedText2;
	
	private Label redError;
	
	int encryptButtonCount;
	
	int decryptButtonCount;
	
	public void start(Stage stage) {
		StackPane root = new StackPane();

		// for two tabs ("Encrypt a message" and "Decrypt a message")
		tabPane = new TabPane();

		// for first tab
		Tab tab1 = new Tab();
		tab1.setText("Encrypt a message");
		
		// GridPane layout for first tab
		encryptBox = new GridPane();
		
		// error handling message
		redError = new Label("");
		redError.setTextFill(Color.RED);
		encryptBox.add(redError, 0, 0);
		
		// user enters text here
		Label enterText = new Label("Enter text to encrypt: ");
		enterText.setTextFill(Color.ORANGE);
		encryptBox.add(enterText, 0, 1);
		enteredText = new TextArea();
		enteredText.setWrapText(true);
		encryptBox.add(enteredText, 1, 1);
		
		// user enters integer here
		Label enterKey = new Label("Enter integer key for encryption: ");
		enterKey.setTextFill(Color.TURQUOISE);
		encryptBox.add(enterKey, 0, 2);
		enteredKey1 = new TextField();
		encryptBox.add(enteredKey1, 1, 2);
		
		// user enters optional integer here
		Label enterKey2 = new Label("Enter 2nd integer key for 2 key encryption (for higher security): ");
		enterKey2.setTextFill(Color.DODGERBLUE);
		encryptBox.add(enterKey2, 0, 3);
		enteredKey2 = new TextField();
		encryptBox.add(enteredKey2, 1, 3);
		
		// button to start encryption
		Button encryptButton = new Button("Encrypt");
		encryptButton.setOnAction(new EncryptionButtonHandler());
		encryptBox.add(encryptButton, 1, 4);
		
		// encrypted text with 1 key prints here
		encryptedInst1 = new Label();
		encryptBox.add(encryptedInst1, 0, 5);
		encryptedText1 = new TextArea();
		encryptedText1.setWrapText(true);
		
		// encrypted text with 2 keys prints here
		encryptedInst2 = new Label();
		encryptBox.add(encryptedInst2, 0, 6);
		encryptedText2 = new TextArea();
		encryptedText2.setWrapText(true);
		
		// adds padding around the larger encryptBox
		encryptBox.setPadding(new Insets(10, 40, 40, 10));
				
		// sets margins between labels, textFields, and textAreas
		encryptBox.setHgap(6);
		encryptBox.setVgap(6);
		
		// attached the GridPane encryptBox to the first tab
		tab1.setContent(encryptBox);
		
		// for second tab
		Tab tab2 = new Tab();
		tab2.setText("Decrypt a Message");

		// GridPane layout for second pane
		decryptBox = new GridPane();
		
		// user enters encrypted text here
		Label enterDText = new Label("Enter text to decrypt: ");
		enterDText.setTextFill(Color.CORAL);
		decryptBox.add(enterDText, 0, 0);
		enteredDText = new TextArea();
		enteredDText.setWrapText(true);
		decryptBox.add(enteredDText, 1, 0);
		
		// adds padding around the larger box
		decryptBox.setPadding(new Insets(10, 40, 40, 10));
		
		// sets margins between labels, textFields, and textAreas
		decryptBox.setHgap(6);
		decryptBox.setVgap(6);
				
		// adds decryptButton
		Button decryptButton = new Button("Decrypt");
		decryptButton.setOnAction(new DecryptionButtonHandler());
		decryptBox.add(decryptButton, 1, 1);
		
		// user info decrypt message
		decryptMessage = new Label("One of the following decoded messages will be your original message.");
		decryptMessage.setTextFill(Color.VIOLET);
		
		// decrypted text with 1 key prints here
		decryptedInst1 = new Label();
		decryptBox.add(decryptedInst1, 0, 2);
		decryptedText1 = new TextArea();
		decryptedText1.setWrapText(true);
		
		// decrypted text with 2 keys prints here
		decryptedInst2 = new Label();
		decryptBox.add(decryptedInst2, 0, 3);
		decryptedText2 = new TextArea();
		decryptedText2.setWrapText(true);
		
		// assigns decryptBox to tab2
		tab2.setContent(decryptBox);
		
		// makes first tab default
		tabPane.getSelectionModel().select(0);
		
		// adds both tabs to tabPane
		tabPane.getTabs().addAll(tab1, tab2);

		// adds tabPane to the bigger StackPane
		root.getChildren().add(tabPane);

		// creates a scene window and names it
		Scene scene = new Scene(root, 950, 720);
		stage.setTitle("Caesar Cipher");
		stage.setScene(scene);
		stage.show();
	}
	
	// handler class for the Encrypt button
	private class EncryptionButtonHandler implements EventHandler<ActionEvent> {
		// handle method for the Encrypt button
		public void handle(ActionEvent event) {
			String textToEncrypt = enteredText.getText();
			try {
				int keyToUse1 = Integer.parseInt(enteredKey1.getText());
				String enteredKey2Text = enteredKey2.getText();
				if (enteredKey2Text.equals("")) enteredKey2.setText("0");
				int keyToUse2 = Integer.parseInt(enteredKey2.getText());
				
				if (keyToUse1 < 0 || keyToUse1 > 26)
					redError.setText("For key 1, please enter an integer between 0 and 26.");
				else if (keyToUse2 < 0 || keyToUse2 > 26)
					redError.setText("For key 2, please enter an integer between 0 and 26.");
				
				else if (textToEncrypt=="") {
					redError.setText("Please enter a string to encrypt");
				}
				
				else {
					encryptButtonCount++;
					
					redError.setText("");
					
					if (encryptButtonCount == 1) {
						encryptBox.add(encryptedText1, 1, 5);
						encryptBox.add(encryptedText2, 1, 6);
					}
					
					//String encryptedString1 = CaesarCipher.encryptOne(textToEncrypt+"eeeeeee", keyToUse1);
					String encryptedString1 = CaesarCipher.encryptOne(textToEncrypt, keyToUse1);
					encryptedInst1.setText("Your encrypted message with a key of " + keyToUse1 + " is: ");
					encryptedText1.setText(encryptedString1);
					
					//String encryptedString2 = CaesarCipher.encryptTwo(textToEncrypt+"eeeeeee", keyToUse1, keyToUse2);
					String encryptedString2 = CaesarCipher.encryptTwo(textToEncrypt, keyToUse1, keyToUse2);
					encryptedInst2.setText("Your encrypted message with a key of " + keyToUse1 + " and " + keyToUse2 + " is: ");
					encryptedText2.setText(encryptedString2);
				}
			}
			catch (NumberFormatException ex) {
				redError.setText("Please enter an integer for keys to encrypt.");
				encryptedInst1.setText("");
				encryptedInst2.setText("");
				
				encryptedText1.setText("");
				encryptedText2.setText("");
			}
		}
	}
	
	// handler class for the Decrypt button
	private class DecryptionButtonHandler implements EventHandler<ActionEvent> {
		// handle method for the Decrypt button
		public void handle(ActionEvent event) {
			String textToDecrypt = enteredDText.getText();

			decryptButtonCount++;
			if (decryptButtonCount == 1) {
				decryptBox.add(decryptMessage, 0, 1);
				decryptBox.add(decryptedText1, 1, 2);
				decryptBox.add(decryptedText2, 1, 3);
			}
			
			String decryptedString1 = CaesarBreaker.decrypt(textToDecrypt);
			decryptedInst1.setText("Your decrypted message with one key is: ");
			decryptedText1.setText(decryptedString1);
			
			String decryptedString2 = CaesarBreaker.decryptTwoStrings(textToDecrypt);
			decryptedInst2.setText("Your decrypted message with two keys is: ");
			decryptedText2.setText(decryptedString2);
		}
	}
	
	// main launches the program
	public static void main(String[] args) {
		launch(args);
	}
}
