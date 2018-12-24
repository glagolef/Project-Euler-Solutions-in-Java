package Project_Euler_Solutions_in_Java._01_31;
import java.math.BigInteger;
import java.util.LinkedList;
public class _029_Distinct_Powers {		
	//to-do -> redo with hash set. Key, value. 
	private LinkedList simpll = new LinkedList();
	final int HUNDRED = 100;
	public static void main(String[] args) {
		System.out.println(new _029_Distinct_Powers().simpleMethod());	
	}
	private int simpleMethod(){
		for(int a = 2; a <= 100; a++){
			for(int b = 2; b <= 100; b++){
				BigInteger calc = new BigInteger(Integer.toString(a));
				calc = calc.pow(b);
				if(!simpll.contains(calc))
					simpll.addFirst(calc);
			}
		}
		display_all_links(simpll);
		return simpll.size();
	}

	public void display_all_links(LinkedList a){
		System.out.println(a);
	}
	public class Link {
		public BigInteger num;
		public Link next;
		public Link(BigInteger calc){
			this.num = calc;
		}
	}
}

