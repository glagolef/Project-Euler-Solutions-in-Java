package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Each character on a computer is assigned a unique code and the preferred standard is ASCII
 * For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 *
 * A modern encryption method is to take a text file, convert the bytes to ASCII,
 * then XOR each byte with a given value, taken from a secret key.
 * The advantage with the XOR function is that using the same encryption key on the cipher text,
 * restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 *
 * For unbreakable encryption, the key is the same length as the plain text message,
 * and the key is made up of random bytes. The user would keep the encrypted message
 * and the encryption key in different locations, and without both "halves", it is impossible to decrypt the message.
 *
 * Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
 * If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
 * The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
 *
 * Your task has been made easy, as the encryption key consists of three lower case characters.
 * Using p059_cipher.txt, a file containing the encrypted ASCII codes,
 * and the knowledge that the plain text must contain common English words,
 * decrypt the message and find the sum of the ASCII values in the original text.
 *
 */
public class _059_XORDecryption {
    private String path = Util.PATH + "\\src\\";
    private String filename = "p059_cipher.txt";
    private String delim = ",";
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Util.println("Result = " + new _059_XORDecryption().run());
        long end = System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }

    public int run() {
        ArrayList<String> psw = new ArrayList<>();
        generatePasswords(psw);
        ArrayList<String> al = new ArrayList<>();
        populateALWithEncryptedMsg(al);
        String result = decryptXORMsgWithWord( al, psw, "Euler");//"God" for p059_2
//        Util.println(result);
        return getSumOfChars(result);
    }
    private String decryptXORMsgWithWord(ArrayList<String> al, ArrayList<String> psw, String word){
        StringBuilder sb = new StringBuilder(al.size());
        for (String password : psw) {
            int count = 0;
            for (String c : al) {
                int crypt = Integer.valueOf(c);
                char pswChar = password.charAt(count);
                char decrypt = decryptXOR(pswChar, crypt );
                if(!isCharLegit(decrypt))
                    break;
                sb.append(decrypt);
                count = count == 2 ? 0 : count + 1;
            }
            if(sb.length() == al.size() && sb.toString().contains(word)) {
                String result = sb.toString();
                return result;
            }
            sb.delete(0,sb.length());
        }
        return null;
    }
    private void populateALWithEncryptedMsg(ArrayList<String> al){
        try {
            String tmp;
            BufferedReader br = new BufferedReader(new FileReader(path + filename));
            while ((tmp = br.readLine()) != null) {
                al.addAll(Arrays.asList(tmp.split(delim)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int getSumOfChars(String str){
        int result =0;
        for(char c : str.toCharArray()){
            result += (int)c;
        }
        return result;
    }
    private boolean isCharLegit(char c){
        return (c >=32 && c <=125);
    }
    private char decryptXOR(int key, int crypt){
        return (char) ((byte)crypt ^ (byte)key);
    }

    private void generatePasswords(ArrayList<String> psw){
        int firstLetter = 97;
        int lastLetter = firstLetter + 25;
        StringBuilder tmp = new StringBuilder();
        for( int x = firstLetter; x <= lastLetter; x ++) {
            tmp.append((char)x);
            for (int y = firstLetter; y <= lastLetter; y++) {
                tmp.append((char)y);
                for (int z = firstLetter; z <= lastLetter; z++) {
                    tmp.append((char) z);
                    psw.add(tmp.toString());
                    tmp.deleteCharAt(2);
                }
                tmp.deleteCharAt(1);
            }
            tmp.deleteCharAt(0);
        }
    }
}
