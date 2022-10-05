
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2)
    {
        //Write down the alphabet
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        mainKey1 = key1;
        
        shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        mainKey2 = key2;
    }

    public String encrypt(String input)
    {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            if(idx != -1)
            {
                char newChar;
                if (i % 2 == 0)
                {
                    //Get the idxth character of shiftedAlphabet (newChar)
                    newChar = shiftedAlphabet1.charAt(idx);
                }
                else
                {
                    //Get the idxth character of shiftedAlphabet (newChar)
                    newChar = shiftedAlphabet2.charAt(idx);
                }
                //Replace the ith character of encrypted with newChar
                if (Character.isUpperCase(currChar))
                {
                    encrypted.setCharAt(i, newChar);
                }
                else
                {
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String decrypt(String encrypted)
    {
        CaesarCipherTwo cct = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        String decrypted = cct.encrypt(encrypted);
        
        return decrypted;
    }
}
