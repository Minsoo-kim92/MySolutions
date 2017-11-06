import java.util.Scanner;
import java.math.*;
public class Solution {
	static int dart(String dartResult) {
		int answer=0;
		int lastPoint=-2;
		int multiple=0;
		int prize = 0;
		int prizeCount = 0;
	
		for(int i=dartResult.length(); i>0; i--) {
			switch(dartResult.substring(i-1, i)) {
			case "S":
				multiple = 1;
				break;
			case "D":
				multiple = 2;
				break;
			case "T":
				multiple = 3;
				break;
			case "*":
				if(prizeCount != 0) {
					prizeCount++;
					prize *=2;
				}
				else {
					prize = 2;
					prizeCount =2;
				}
				break;
			case "#":
				if(prizeCount != 0) {
					prize *= -1;
				}
				else {
					prize = -1;
					prizeCount = 1;
				}
				break;
			default:
				if(i>2) {
					if(dartResult.substring(i-2,i).equals("10")) {
						lastPoint = 10;
						i--;
					}
					else {
						lastPoint = Integer.parseInt(dartResult.substring(i-1,i));
					}
						
				}else { 
					lastPoint = Integer.parseInt(dartResult.substring(i-1,i));
				}
					
			}
			
			if(lastPoint >= 0 && multiple != 0) {
				if(prizeCount > 0)
				{
					
					answer += pow(lastPoint,multiple) * prize ;
					System.out.println(pow(lastPoint,multiple) * prize);
					prizeCount--;
				}
				else {
					answer += pow(lastPoint,multiple) ;
					System.out.println(pow(lastPoint,multiple));
				}
				
				lastPoint = -1;
				multiple = 0;
				//System.out.println(answer);
			}
			
		}
		
		
		return answer;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		dart(sc.nextLine());

	}
	static int pow(int a, int b) {
		int result=a;
		for(int i=0; i<b-1; i++)
			result *=a;
		return result;
	}
}
	
	

