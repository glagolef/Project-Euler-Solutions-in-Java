/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class _009_pythagrean_triplet {

	final int GRAND = 1000;
	public static void main(String[] args) {
		System.out.println(new _009_pythagrean_triplet().run());
	}
	public long run(){
		int a=0,b=0,c=0;
		int mult_a=0, mult_b=0, mult_c=0, sum_ab=0;
		for (c = 499; c>0; c--){
			mult_c=c*c;
			sum_ab=mult_c+1;
			for(b = c-1; mult_c <= sum_ab; b--){
				mult_b = b*b;
				a = GRAND-b-c;
				mult_a = a*a;
				sum_ab= mult_a + mult_b;
				if(sum_ab==mult_c)
					 return a*b*c;
			}
		}
		return 0;
	}
}
