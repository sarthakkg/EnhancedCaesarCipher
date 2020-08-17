// Honors Honors Contract Program
// Name: Sarthak Gupta
// Date: 4/18/2020
// StudentID: 1215940648
// Lecture: MWF 10:45
// Description: CaesarCipher class encrypts messages based on 1 key and 2 keys.

public class CaesarCipher {
	// encrypts input string by shifting over letters by numerical key
	public static String encryptOne(String input, int key) {
		String encrypted = input;
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = upperAlphabet.toLowerCase();
        
        String shiftedUpperAlphabet = upperAlphabet.substring(key) + upperAlphabet.substring(0, key);
        String shiftedLowerAlphabet = shiftedUpperAlphabet.toLowerCase();
                
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);

            if (Character.isUpperCase(currChar)) {
                int index = upperAlphabet.indexOf(currChar);
                if (index != -1) {
                    char newChar = shiftedUpperAlphabet.charAt(index);
                    String part1 = encrypted.substring(0, i);
    				String part2 = encrypted.substring(i+1);
    				encrypted = part1 + newChar + part2;
                }
            }
            
            if (Character.isLowerCase(currChar)) {
                int index = lowerAlphabet.indexOf(currChar);
                if (index != -1) {
                    char newChar = shiftedLowerAlphabet.charAt(index);
                    String part1 = encrypted.substring(0, i);
    				String part2 = encrypted.substring(i+1);
    				encrypted = part1 + newChar + part2;
                }
            }
        }
        return encrypted.toString();
	}
	
	// encrypts every odd character in string by first key and every even character in string by second key
	public static String encryptTwo(String input, int key1, int key2) {
		String encrypted = input;
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = upperAlphabet.toLowerCase();
        // for odd characters in string
        for (int i = 0; i < encrypted.length(); i+=2) {
            char currChar = encrypted.charAt(i);

            String shiftedUpperAlphabet1 = upperAlphabet.substring(key1) + upperAlphabet.substring(0, key1);
            String shiftedLowerAlphabet1 = shiftedUpperAlphabet1.toLowerCase();
            
            if (Character.isUpperCase(currChar)) {
                int index = upperAlphabet.indexOf(currChar);
                if (index != -1) {
                    char newChar = shiftedUpperAlphabet1.charAt(index);
                    String part1 = encrypted.substring(0, i);
    				String part2 = encrypted.substring(i+1);
    				encrypted = part1 + newChar + part2;
                }
            }
            
            if (Character.isLowerCase(currChar)) {
                int index = lowerAlphabet.indexOf(currChar);
                if (index != -1) {
                    char newChar = shiftedLowerAlphabet1.charAt(index);
                    String part1 = encrypted.substring(0, i);
    				String part2 = encrypted.substring(i+1);
    				encrypted = part1 + newChar + part2;
                }
            }
        }
        // for even characters in string
        for (int i = 1; i < encrypted.length(); i+=2) {
            char currChar = encrypted.charAt(i);

            String shiftedUpperAlphabet2 = upperAlphabet.substring(key2) + upperAlphabet.substring(0, key2);
            String shiftedLowerAlphabet2 = shiftedUpperAlphabet2.toLowerCase();
            
            if (Character.isUpperCase(currChar)) {
                int index = upperAlphabet.indexOf(currChar);
                if (index != -1) {
                    char newChar = shiftedUpperAlphabet2.charAt(index);
                    String part1 = encrypted.substring(0, i);
    				String part2 = encrypted.substring(i+1);
    				encrypted = part1 + newChar + part2;
                }
            }
            
            if (Character.isLowerCase(currChar)) {
                int index = lowerAlphabet.indexOf(currChar);
                if (index != -1) {
                    char newChar = shiftedLowerAlphabet2.charAt(index);
                    String part1 = encrypted.substring(0, i);
    				String part2 = encrypted.substring(i+1);
    				encrypted = part1 + newChar + part2;
                }
            }
        }
        return encrypted.toString();
	}
}