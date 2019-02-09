package Project_Euler_Solutions_in_Java._32_63;
import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.HashSet;

public class _033_Digit_cancelling_fractions {

	public static void main(String[] args) {
		System.out.println(new _033_Digit_cancelling_fractions().run());
	}
	private int run(){
		int result = 0;
		int num, den;
		//to store the 4 solutions
		int[][]results = new int [4][2];
		HashSet<Double> res = new HashSet<Double>();
		int fin_res[] = {1,1};
		//current position in above array
		int cur_res=0;
		
		for (int i=12; i<98; i++){
			if(i%10==0)
				continue;
			for(int j=11; j<99; j++){
				if(j%10==0 || i==j)
					continue;
				if(i<j){
					num = i;
					den = j;
				}else {
					num = j;
					den = i;
				}
				double num_div_den = (double)num/den;
//				if( num_div_den== 0.5)
//					continue;
				if(num/10==den%10 && num_div_den==(double)(num%10)/(den/10)){
					if(!res.contains(num_div_den)){
						res.add(num_div_den);						
						results[cur_res][0]=(int)num;
						results[cur_res][1]=(int)den;
						cur_res++;
						fin_res[0]*=num;
						fin_res[1]*=den;
					}
				}
				if(num%10==den/10 && num_div_den==(double)(num/10)/(den%10)){
					if(!res.contains(num_div_den)){
						res.add(num_div_den);
						results[cur_res][0]=(int)num;
						results[cur_res][1]=(int)den;
						cur_res++;
						fin_res[0]*=num;
						fin_res[1]*=den;
					}
				}
			}
	}
		int gcd = Util.getGCD(fin_res[0], fin_res[1]);
		return fin_res[1]/gcd;
	}


}
