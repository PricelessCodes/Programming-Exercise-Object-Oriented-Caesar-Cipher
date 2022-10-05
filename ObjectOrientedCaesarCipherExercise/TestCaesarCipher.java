
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class TestCaesarCipher {
    
    private int[] countLetters(String s)
    {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] alphabetCount = new int[26];
        
        for (int i = 0; i < s.length(); i++)
        {
            char ch = Character.toUpperCase(s.charAt(i));
            int idx = alphabet.indexOf(ch);
            
            if (idx != -1)
            {
                alphabetCount[idx]++;
            }
        }
        
        return alphabetCount;
    }
    
    private int maxIndex(int[] alphabetCount)
    {
        int max = -1;
        int index = -1;
        
        for (int i = 0; i < alphabetCount.length; i++)
        {
            if (alphabetCount[i] > max)
            {
                max = alphabetCount[i];
                index = i;
            }
        }
        
        return index;
    }
    
    private int breakCaesarCipher (String s)
    {
        int[] alphabetCount = countLetters(s);
        int index = maxIndex(alphabetCount);
        
        int key = index - 4;
        if (index < 4)
        {
            key = 4 - index;
        }
        
        return key;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 2;
        CaesarCipher cc = new CaesarCipher(key);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        
        key = breakCaesarCipher(encrypted);
        cc = new CaesarCipher(key);
        String decrypted = cc.decrypt(encrypted);
        System.out.println(decrypted);
    }
}
