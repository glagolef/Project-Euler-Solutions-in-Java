import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, 
 * is the 938th name in the list. So, COLIN would obtain a score of 938 x 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */
public class _022_names_scores {

	public static void main(String[] args) {
		System.out.println(new _022_names_scores().run());
	}
	private int run(){
		String fileName = "p022_names.txt";
    	List<String> namesList=new ArrayList<String>();
        int sum = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner s = new Scanner(bufferedReader);
            while(s.hasNext()) {
            	s.useDelimiter(",");
            	namesList.add(s.next().replaceAll("\"", ""));
            }   
            Collections.sort(namesList);
            s.close();     
            for(int i = 0; i<namesList.size();i++)
            	sum+=nameScore(namesList.get(i), i);
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
		return sum;
	}
	private static int nameScore(String name, int position){
		int sum=0;
		for(int i= 0; i<name.length();i++)
			sum += (int) name.charAt(i)-'@';
		return sum*(position+1);
	}
}