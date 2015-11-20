/*
* Given the stacks of money in each house and the constraint that robbing the odd's houses will call the cops, find the maximum money you can rob.
*/
import java.util.*;

public class BestHouseToRob{
	public static void main(String[] args){
		int[] money = {50,1,1,100};
		rob(money);
	}
	public static void rob(int[] money){
		if(money == null || money.length == 0)
			System.out.println("Nothing to rob");
		else{
			int even = 0;
			int odd = 0;
			int max = 0;
			for(int i=0;i<money.length;i++){
				if (i % 2 == 0) {
					even += money[i];
					even = (even > odd ? even : odd );
				}else{
					odd += money[i];
					odd = (even>odd ? even : odd ) ;
				}
			}
			max = (even>odd ? even : odd ) ;
			System.out.println("Max amount robbed :"+max);
		}
	}
}
