package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * By converting each letter in a word to a number corresponding to its alphabetical position
 * and adding these values we form a word value.
 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
 * If the word value is a triangle number then we shall call the word a triangle word.
 */
public class _042_Coded_Triangle_Numbers {
    public final int ASCII_PREFIX = 64;
    public HashSet<Integer> triangleNumbers;
    public double largestNumber;
    public static void main(String[] args) {

    util.Util.print(new _042_Coded_Triangle_Numbers().run());
}
    public _042_Coded_Triangle_Numbers(){
        triangleNumbers = new HashSet<>();
        largestNumber = 0;
    }
    public int run () {
        String path = Util.PATH + "\\_32_63\\";
        Util.print(path);
        String filename = "p042_words.txt";
        String delim = ",";
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path + filename));
            sb.append(br.readLine());
            String[] words = sb.toString().replaceAll("\"","").split(delim);
            int results = 0;
            for(String word : words){
                results += isWordTCodedTriangleNumber(word) ? 1 : 0;
            }
            return results;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


        return 0;
    }
    public boolean isWordTCodedTriangleNumber(String word){
        int acc = 0;
        for ( char c : word.toUpperCase().toCharArray()){
            acc += (int) c - ASCII_PREFIX;
        }
        return isNumberTriangular(acc);
    }
    //lazy implementation
    public boolean isNumberTriangular(int num){
        if(num > largestNumber){
            for (int largestN = triangleNumbers.size() + 1; num > largestNumber; largestN ++){
                largestNumber = (double) (largestN * (largestN + 1)) / 2;
                triangleNumbers.add((int)largestNumber);
            }
            return num == largestNumber;
        }
        return triangleNumbers.contains(num);
    }

}
