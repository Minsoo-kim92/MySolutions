
import java.util.Arrays;

import java.util.Scanner;
public class Solution {
	  public static void main(String[] args) {
			try(Scanner s = new Scanner(System.in))
			{
				int n = s.nextInt();
				int d = s.nextInt();
				int k = s.nextInt();
				int j = s.nextInt();
				
				//여기부터 작성해 주세요
                
				int[] ary = new int[n];
				Arrays.fill(ary, 1);
				int crntIndex=0;
				int cnt=0;
				int prizeWinner = 1;
				//방향만큼 전진, 0이면 넘어감
				//탈락자 =0
				//시작지점 정해줌
				
				while(n!=1) {

					//시계방향
					if(d==1) {
						for(int i=1; i<=k;) {    //탈락자 선정 하기 위해 전진
							
							if(crntIndex+1 == n) crntIndex = -1; 
							
							if(ary[crntIndex+1]==1) {// 정해진 만큼 전진.
								crntIndex++;
								i++;
							}else crntIndex++;
						}
					}
					else {
							for(int i=1; i<=k;) {    //탈락자 선정 하기 위해 전진
							
							if(crntIndex-1 == -1) crntIndex = n; 
							
							if(ary[crntIndex-1]==1) {// 정해진 만큼 전진.
								crntIndex--;
								i++;
								
							}else crntIndex--;
						}
					//반시계
					}
					ary[crntIndex] = 0; //탈락자 선정
					cnt++;
					k+=j;
					if(cnt+1 == n) break;
				}
				for(int i=0;; i++) {
					if(ary[i]==1) {
						System.out.print(i+1);
						break;
					}
				}
				
			}
	  }
}
