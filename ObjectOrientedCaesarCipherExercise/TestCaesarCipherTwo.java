
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class TestCaesarCipherTwo {
    
    public int[] countLetters(String s)
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
    
    public int maxIndex(int[] alphabetCount)
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
    
    public int getKey(String s)
    {
        int[] alphabetCount = countLetters(s);
        int index = maxIndex(alphabetCount);
        
        int key = index - 4;
        if (index < 4)
        {
            key = 26 - (4 - index);
        }
        
        return key;
    }
    
    public String halfOfString(String message, int start)
    {
        String half = "";
        
        for (int i = start; i < message.length(); i+=2)
        {
            half += message.charAt(i);
        }
        
        return half;
    }
    
    public String breakCaesarCipher(String encrypted)
    {
        String encrypted1 = halfOfString(encrypted, 0);
        String encrypted2 = halfOfString(encrypted, 1);
        int key1 = getKey(encrypted1);
        int key2 = getKey(encrypted2);
        
        CaesarCipherTwo cct = new CaesarCipherTwo(key1, key2);
        
        String decrypted = cct.decrypt(encrypted);
        
        
        
        return decrypted;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key1 = 17;
        int key2 = 3;
        CaesarCipherTwo cct = new CaesarCipherTwo(key1, key2);
        String encrypted = cct.encrypt(message);
        System.out.println(encrypted);
        
        System.out.println(breakCaesarCipher(encrypted));
    }
}
