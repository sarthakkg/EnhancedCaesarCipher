# EnhancedCaesarCipher

CaesarCipher is a Java GUI program to encrypt text with 1 key or 2 keys.

It can also decrypt an encrypted message without knowing the keys that were used to encrypt it.

Both the sender and receiver of the encrypted message can use this program to communicate a confidential message.
<br/>
<br/>
## Requirements

Java SE Development Kit 8
<br/>
<br/>
## Description for Encryption (For Users Who Would Like to Encrypt A Confidential Message)

### Single Key Encryption

Pick an integer, *n*, to encrypt the message. All of the letters in the message will be shifted over *n* places in the English alphabet.

For example, a message of "How are you?" will become "Krz duh brx?" if shifted over by a key of n=3.
<br/>

### Double Key Encryption (more secure)

Pick two integers, *m* and *n*, to encrypt the message. All of the characters at even placeholders will be shifted over *m* places and
the characters at odd placeholders will be shifted over by *n* places in the English alphabet.
<br/>
<br/>
## Description for Decryption (For Users Who Would Like to Decrypt A Confidential Message)

Enter the encrypted message you would like to decrypt. You do not have to know the key or keys used to decrypt the message.

The GUI program will try to decrypt the message through both 1-key and 2-keys.

The program will show you your original message.
<br/>
<br/>
## Hack for Decryption
The program relies on using the statistical frequencies of commonly used letters in the English language to deciper a key
that was originally used to encrypt the message. It then applies the deciphered key to reverse encrypt it. It will show
the original message by deciphering the original message with both 1-key decryption and 2-key decryption.
