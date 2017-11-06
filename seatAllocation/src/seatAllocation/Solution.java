package seatAllocation;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stb
		
		String s ="";
		String[] splitMsg = s.split(" ");
		MySeatManager msm = new MySeatManager(2);
		if(s.length()!=0) {
			for(int i=0; i<splitMsg.length;i++) {
				msm.resevation(splitMsg[i]);
			}
		}
		msm.printAll();
		System.out.println(msm.find());
	}

}


class MySeat{
	int[] seat;
	public MySeat() {
		seat = new int[10];
		Arrays.fill(seat, 0);
	}
	
	public int findSeat() {
		int count=0;
		int seatable=0;
		for(int i=0; i< 3; i++) {
			if(seat[i] == 0) count ++;
		}
		if(count==3) {
			seatable++;
		}
		count = 0;
		for(int i=3; i< 7; i++) {
			if(seat[i] == 0) count ++;
			else count =0;
		}
		if(count>=3) {
			seatable++;
		}
		count =0;
		
		for(int i=7; i< 10; i++) {
			if(seat[i] == 0) count ++;
			else count =0;
		}
		if(count>=3) {
			seatable++;
		}
		
		return seatable;
	}
	public int setSeat(char c) {
		int index;
		if(c>=74) {
			index = c-66;
		}else index = c - 65;
		
		if(seat[index] == 1) {
			return 0;
		}else {
			seat[index] = 1;
			return 1;
		}
	}
	public void print() {
		for(int i=0;i<10; i++) {
			System.out.printf("%d",seat[i]); 
		}
	}
}

class MySeatManager{
	MySeat[] ms;
	public MySeatManager(int n){
		ms = new MySeat[n];
		for(int i=0; i<n; i++) {
			ms[i] = new MySeat();
		}
	}
	
	public void resevation(String s) {
		String a = s.substring(0,1);
		
		ms[Integer.parseInt(a)-1].setSeat(s.charAt(1));
	}
	
	public void printAll() {
		for(int i=0; i<ms.length; i++) {
			ms[i].print();
			System.out.println("");
		}
	}
	public int find() {
		int sum=0;
		for(int i=0; i<ms.length;i++) {
			sum+=ms[i].findSeat();
		}
		return sum;
	}
}
