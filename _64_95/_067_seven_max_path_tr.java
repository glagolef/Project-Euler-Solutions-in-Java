package Project_Euler_Solutions_in_Java._64_95;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.io.*;
import java.util.Scanner;
public class _067_seven_max_path_tr {
		private int [][] triangle;
		public _067_seven_max_path_tr(){
			    String path = Util.PATH + "\\src\\";
			 	String fileName = "p067_triangle.txt";
		        String line;
		        triangle = new int [100][100];
		        try {
		            FileReader fileReader = new FileReader(path + fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            int n = 0;
		            while((line = bufferedReader.readLine()) != null) {
		                System.out.println(line);
		                Scanner s = new Scanner(line);
		                for(int i=0; i<=n; i++)
		                	triangle[n][i] = s.nextInt();
		                n++;
		            }   
		            bufferedReader.close();         
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + fileName + "'");                
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" + fileName + "'");                  
		        }
		}
		public static void main(String[] args) {
			System.out.println(new _067_seven_max_path_tr().run());
		}
		private int run(){
				int n = triangle.length-1;
				int answer = addBottom(n, triangle[n], triangle[n-1]);
			return answer;
		}
		private int addBottom(int n, int[] last, int[] second_last){
			for(int i=0; i<second_last.length-1;i++)
				if(last[i]>=last[i+1])
					second_last[i]+=last[i];
				else second_last[i]+=last[i+1];
			if(n>1)
				return addBottom(n-1, second_last, triangle[n-2]);
			return second_last[0];
		}
	}