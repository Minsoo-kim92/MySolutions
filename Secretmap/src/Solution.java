import java.util.*;
public class Solution {
	public static String[] sm(int n, int[] arr1, int[] arr2) {
		

		String[] scMap = new String[n];
		int[][]binaries = new int[n][n];

	
		for(int i=0; i<n; i++) {
			binaries[i]=Binalize(n,arr1[i] | arr2[i],2);
			for(int j=0; j<n; j++) {
				if(binaries[i][j]==1) {
					if(scMap[i] ==null  ) {
						scMap[i] = "#";
					}
					else 
						scMap[i]=scMap[i].concat("#");
				}
				else  {
					if(scMap[i] ==null ) {
						scMap[i] = " ";
					}
					else 
						scMap[i]=scMap[i].concat(" ");
				}
			}
		}
		for(int i=0; i<n; i++) {
			System.out.println(scMap[i]);
		}
		return scMap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int[]arr1 = new int[n];
		int[]arr2 = new int[n];
		for(int i=0; i<n; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			arr2[i] = sc.nextInt();
		}
		
		sm(n,arr1,arr2);
		
	}
	static int[] Binalize(int n, int value,int wlsqjq)									// 값을 받아 2진수 배열로 넘겨줌
	{
		int count = 1;
		int counting = value;
		while (counting >= wlsqjq && counting != 0)
		{
			counting = counting / wlsqjq;
			count++;
		}
		int after_binalize[] = new int[n];
		
		for (int a = n-1; value > 0; a--)
		{
			if (value % wlsqjq == 0) after_binalize[a] = 0;
			else after_binalize[a] = value%wlsqjq ;
			value = value / wlsqjq;
		}
		return after_binalize;
	}
}

