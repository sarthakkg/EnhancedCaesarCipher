// CaesarCipher Decryption
// Sarthak Gupta
// 4/18/2020
// CaesarBreaker deciphers encrypted messages based upon 1 and 2 keys.

public class CaesarBreaker {
	// counts the number of instances of each letter in the encrypted message and returns it in an array
	public static int[] countLetters(String message) {
		String alph = "abcdefghijklmnoqprstuvwxyz";
	    int[] counts = new int[26];
	    for (int k = 0; k < message.length(); k++){
	        char ch = Character.toLowerCase(message.charAt(k));
	        int dex = alph.indexOf(ch);
	        if (dex != -1){
	            counts[dex] += 1;
	        }
	    }
	    return counts;
	}
	
	// finds the index of the value with the greatest frequency
	public static int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
	
	// decrypts message based on one key
	public static String decrypt(String encrypted) {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        String decryptedMessage = CaesarCipher.encryptOne(encrypted, 26 - dkey);
        // accounts for extra "e"s in the message to ensure decryption works but doesn't show them
        if (decryptedMessage.charAt(decryptedMessage.length()-7) == decryptedMessage.charAt(decryptedMessage.length()-6))
	        if (decryptedMessage.charAt(decryptedMessage.length()-6) == decryptedMessage.charAt(decryptedMessage.length()-5))
	        	if (decryptedMessage.charAt(decryptedMessage.length()-5) == decryptedMessage.charAt(decryptedMessage.length()-4))
	        		if (decryptedMessage.charAt(decryptedMessage.length()-4) == decryptedMessage.charAt(decryptedMessage.length()-3))
	        			if (decryptedMessage.charAt(decryptedMessage.length()-3) == decryptedMessage.charAt(decryptedMessage.length()-2))
	        				if (decryptedMessage.charAt(decryptedMessage.length()-2) == decryptedMessage.charAt(decryptedMessage.length()-1))
        						decryptedMessage = decryptedMessage.substring(0, decryptedMessage.length()-7);
        return decryptedMessage;
    }
	
	// divides up a string into two strings based on the characters at odd positions and those at even positions to decrypt with 2 keys
	public static String halfOfString(String message, int start) {
        StringBuilder half = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            char c = message.charAt(i);
            half.append(c);
        }
        return half.toString();
    }
    
	// deciphers key based on the frequency of the most uses letter in the English alpahbet, "e"
    public static int decipherKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
    // decrypts the encrypted message using two different deciphered keys
    public static String decryptTwoStrings(String encrypted) {
        String string1 = halfOfString(encrypted, 0);
        String string2 = halfOfString(encrypted, 1);
        
        int key1 = decipherKey(string1);
        int key2 = decipherKey(string2);
        
        // accounts for extra "e"s in the message to ensure decryption works but doesn't show them
        String decryptedTwo = CaesarCipher.encryptTwo(encrypted, 26 - key1, 26 - key2);
        if (decryptedTwo.charAt(decryptedTwo.length()-7) == decryptedTwo.charAt(decryptedTwo.length()-6))
	        if (decryptedTwo.charAt(decryptedTwo.length()-6) == decryptedTwo.charAt(decryptedTwo.length()-5))
	        	if (decryptedTwo.charAt(decryptedTwo.length()-5) == decryptedTwo.charAt(decryptedTwo.length()-4))
	        		if (decryptedTwo.charAt(decryptedTwo.length()-4) == decryptedTwo.charAt(decryptedTwo.length()-3))
	        			if (decryptedTwo.charAt(decryptedTwo.length()-3) == decryptedTwo.charAt(decryptedTwo.length()-2))
	        				if (decryptedTwo.charAt(decryptedTwo.length()-2) == decryptedTwo.charAt(decryptedTwo.length()-1))
	        					decryptedTwo = decryptedTwo.substring(0, decryptedTwo.length()-7);
        return decryptedTwo;
    }   
}
