import java.io.*;
import java.util.Scanner;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	Scanner in = new Scanner(System.in);
    	int N;
    	String inputString;
    	int T = in.nextInt();
    	Solution s = new Solution();
    	MyStringArray a= new MyStringArray();
    	
    	for(int i=0; i<T; i++) {
    		N = in.nextInt();
    		inputString = in.next();
    		a.findCycle(inputString);
    	}
    }
}

class MyStringArray {
	int count;
	int flag;
	String cycle;
	String oldString;
	char[] newString;
	public MyStringArray(){
		flag =0;
		
	}
	
	public void findCycle(String input) {	
		newString = new char[input.length()];
		String subString;
		String oldString = input;
		cycle = input.substring(0,1);
		for(int cycle_start=0; cycle_start<input.length(); cycle_start++) {
			for(int cycle_size=cycle_start+1; (cycle.length()+cycle_start)<input.length(); cycle_size++) {
				
				
				//0123456789
				//abcdeabcde
				//abcde			
				//arr_j=5
				cycle = input.substring(cycle_start,cycle_size);
				System.out.println(cycle);
				for(int i=cycle_start; i+cycle.length()<input.length(); i+=cycle.length()) {
					if(input.substring(i,i+cycle.length()).equals(cycle)) {
						flag = 1;
						for(int j=cycle_start; j<cycle.length(); j++) {
							newString[j]+=1;
						}
						//System.out.println(newString.toString());
					}
				}
				
			}
			cycle = " ";
			if(flag ==1 )break;
			
		}//for
		
		
	}
	
}