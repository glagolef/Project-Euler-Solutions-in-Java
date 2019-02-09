package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class _011_largest_product_in_grid {
/*
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20x20 grid?
 */
	final int TWENTY = 20;
	private String path = Util.PATH + "\\src\\";
	private String filename = "p011.txt";
	public static void main(String[] args) {

		System.out.println(new _011_largest_product_in_grid().run());
	}
	public long run(){
		StringBuilder sb = new StringBuilder();
		ArrayList<String> al = new ArrayList<>();
		String delim = " ";
		try {
			String tmp;
			BufferedReader br = new BufferedReader(new FileReader(path + filename));
			while ((tmp = br.readLine()) != null) {
				al.addAll(Arrays.asList(tmp.split(delim)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] grid = al.toArray(new String[0]);

		int largest_product = 0;
		
		int[][] num_grid = new int[TWENTY][TWENTY];
		for(int i=0; i<grid.length; i++){
			num_grid[i/TWENTY][i%TWENTY] = Integer.parseInt(grid[i]);
		}
		for(int i = 0; i < TWENTY; i++)
			for (int j = 0; j< TWENTY; j++){
				int lp = largestProduct(i,j,num_grid);
				largest_product = largest_product>lp?largest_product:lp;
			}
		
		
		return largest_product;
	}
	public int largestProduct(int posI, int posJ, int [][] num_grid){
		int lp, lpA = 1, lpB = 1, lpC = 1, lpD = 1;
		for(int i=0; i<4; i++){
			if(posJ+4<TWENTY){
				//right
				lpA*=num_grid[posI][posJ+i];
				if((posI+4)<TWENTY)
				//right diagonal
				lpB*=num_grid[posI+i][posJ+i];
			}
			if(posI+4<TWENTY){
				//down
				lpC*=num_grid[posI+i][posJ];
				if(posJ-4>=0)
				//left diagonal
				lpD*=num_grid[posI+i][posJ-i];
			}
		}
		int a = (lpA>lpB?lpA:lpB);
		int b = (lpC>lpD?lpC:lpD);
		lp= a>b?a:b;
		return lp;
	}
}
