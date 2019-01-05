package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.*;

/**
 * We shall say that an n-digit number is pandigital
 * if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254,
 * containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way
 * so be sure to only include it once in your sum.
 */
public class _032_Pandigital_Products {
	Hashtable<Integer, boolean[]> decim = new Hashtable<Integer, boolean[]>();
	Hashtable<Integer, boolean[]> centur = new Hashtable<Integer, boolean[]>();
	Hashtable<Integer, boolean[]> mille = new Hashtable<Integer, boolean[]>();
	public static void main(String[] args) {
		System.out.println(new _032_Pandigital_Products().run());
		System.out.println(new _032_Pandigital_Products().cleanerSolution());
	}
	private int run(){
		int result = 0;
		for(int i=1; i<10; i++){
			for(int j=1; j<10; j++){
				if(i==j)
					continue;
				int dec_val=i*10+j;
				boolean[] t1 = new boolean [9];
				t1[i-1]=true;
				t1[j-1]=true;
				decim.put(dec_val, t1);
				boolean x[] = decim.get(12);
				for(int k =1; k<10; k++){
					if (k==i || k==j )
						continue;
					int cen_val = dec_val*10+k;
					boolean [] t2 = new boolean [9];
					t2=t1.clone();
					t2[k-1]=true;
					centur.put(cen_val, t2);
					for(int l=1; l<10; l++)
						if(l!=k && l!=j && l!= i){
							int mil_val = cen_val*10+l;
							boolean [] t3;
							t3=t2.clone();
							t3[l-1]=true;
							mille.put(mil_val,t3);
						}	
					}
				}
			}
		Set<Integer> set = new HashSet<Integer>();
		for(int i =12; i<=98; i++){
			if(!decim.containsKey(i))
				continue;
			for (int j =123; j<= 987; j++){
				if(!centur.containsKey(j))
					continue;
				int ixj = i*j; 
				if(!mille.containsKey(ixj))
					continue;
				if(pandigital(decim.get(i),centur.get(j), mille.get(ixj)))
					set.add(ixj);
			}
			
		}
		for(int i=1; i<10; i++)
			for(int j=1234; j<=9876; j++){
				if(!mille.containsKey(j))
					continue;
				int ij = i*j;
				if(!mille.containsKey(ij))
					continue;
				boolean [] i_bool = new boolean[9];
				i_bool[i-1]=true;
				
				if(pandigital(i_bool,mille.get(j), mille.get(ij)))
					set.add(ij);
			}
		Object[] results = set.toArray();
		for(int i=0; i<results.length; i++)
			result+=(int)results[i];	
		return result;
	}
	public boolean pandigital(boolean[] two_digit, boolean[] three_digit, boolean[] four_digit){
		for(int i=0; i<9; i++)
			if(!(two_digit[i] || three_digit[i] || four_digit[i]))
				return false;
		return true;
	}

    public int cleanerSolution(){
        int result =0;
        for (int product = 9876 ; product >= 1234; product --){
            if(!Util.isPandigitalIncomplete(product)){
                continue;
            }
            boolean added = false;
            for ( int a = 1; a<=98 && !added; a++){
                if(product % a!=0 || !Util.isPandigitalIncomplete(a)){
                    continue;
                }
                int b = product/a;
                if(!Util.isPandigitalIncomplete(b)){
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(product).append(a).append(b);
                if(Util.isPandigital(sb)){
                    result += product;
                    added = true;
                }
            }
        }
        return result;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
