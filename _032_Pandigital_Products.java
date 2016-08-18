import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class _032_Pandigital_Products {
	Hashtable<Integer, boolean[]> decim = new Hashtable<Integer, boolean[]>();
	Hashtable<Integer, boolean[]> centur = new Hashtable<Integer, boolean[]>();
	Hashtable<Integer, boolean[]> mille = new Hashtable<Integer, boolean[]>();
	public static void main(String[] args) {
		System.out.println(new _032_Pandigital_Products().run());
	}
	@SuppressWarnings("unused")
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
							boolean [] t3 = new boolean [9];
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
