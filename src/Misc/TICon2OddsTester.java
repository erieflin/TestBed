package Misc;

import java.util.Random;

public class TICon2OddsTester {
	public static void main(String[] args){
		for(int i = 0; i < 10; ++i){
			double odds = .5 + (.01 * i);
			int count =0;
			for(int j =0; j<100; ++j){
				int result = test(10000000,1000,odds);
				if(result!=0){
					//System.out.println(result);
					count++;
				}
			}
			System.out.println(count + ": successful out of 100 for unbreaking odds " + odds * 100 + " %");
			if(count >= 100){
				break;
			}
		}
	}
	public static int test(int tries, int max, double preventOdds){
		int count = max;
		for (int i = 0; i < tries; ++i) {
			if (new Random().nextFloat() >= preventOdds) {
				
				if(count>0){
					count--;	
				}else{
					return count;
				}
			}
			if (new Random().nextFloat() <= .1) {
				if(count+5 < max){
					count += 5;
				}else{
					count = max;
				}
			}
		}
		return count;
	}
}
