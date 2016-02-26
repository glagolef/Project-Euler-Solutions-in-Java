/*
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, 
 * but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Nineteen_counting_sundays {
	final int THIRTY = 30;
	final int THIRTY_ONE = 31;
	final int TWENTY_EIGHT = 28;
	final int TWENTY_NINE = 29;
	public static void main(String[] args) {
		System.out.println(new Nineteen_counting_sundays().run());
	}
	private int run(){
		int day = 2;
		int sum=0;
		for(int year = 1901; year< 2001; year++){
			boolean leap = leapYear(year);
			sum += sundays(leap, day);
			day = leap?(day+366)%7:(day+365)%7;
		}
		return sum;
	}
	private boolean leapYear(int year){
		if (year%4==0){
			if(year%100==0){
				if(year%400==0)
					return true;
			return false;
			}
			return true;
		}
		return false;
	}
	private int sundays(boolean leap, int day_of_the_week){//31 = Jan Mar May Jul Aug Oct Dec; //30 = Apr Jun Sep Nov
		int days_in_months [] = { THIRTY_ONE,TWENTY_NINE,THIRTY_ONE,THIRTY,THIRTY_ONE,THIRTY,THIRTY_ONE,THIRTY_ONE,THIRTY,THIRTY_ONE,THIRTY,THIRTY_ONE};
		int sum=0;
		if(leap){
			 days_in_months[1] =  TWENTY_NINE;
		}else days_in_months[1] = TWENTY_EIGHT;
		for(int i=0; i<days_in_months.length; i++){
			if(day_of_the_week==0)
				sum++;
			day_of_the_week=(day_of_the_week + days_in_months[i])%7;
		}
		return sum;
	}
}
