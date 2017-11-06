package bitwise;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int getIntegerComplement(int n) {
		
		int[] binary =Binalize(n,2);
		
		/*for(int arr_i=0; arr_i<binary.length; arr_i++) {
			System.out.printf("%d", binary[arr_i]);
		}
		System.out.println("");*/
		for(int arr_i=0; arr_i<binary.length; arr_i++) {
			 
			if(binary[arr_i] == 1) {
				binary[arr_i]=0;
			}
			else
				binary[arr_i]=1;
		}/*
		for(int arr_i=0; arr_i<binary.length; arr_i++) {
			System.out.printf("%d", binary[arr_i]);
		}
		System.out.println("");*/
		int decimal =Decimalize(binary);
		//System.out.println("after decimalize"+ decimal);
		return decimal;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine());
        
        res = getIntegerComplement(_n);
        System.out.println(res);
        
	}
	static int[] Binalize(int value,int wlsqjq)									// 값을 받아 2진수 배열로 넘겨줌
	{
		int count = 1;
		int counting = value;
		while (counting >= wlsqjq && counting != 0)
		{
			counting = counting / wlsqjq;
			count++;
		}
		int after_binalize[] = new int[count];
		
		for (int a = count-1; value > 0; a--)
		{
			if (value % wlsqjq == 0) after_binalize[a] = 0;
			else after_binalize[a] = value%wlsqjq ;
			value = value / wlsqjq;
		}
		return after_binalize;
	}
	static int Decimalize(int[] binary) {
		int decimal=0;
		int binary_i=1;
		for(int arr_i=binary.length-1; arr_i>=0; arr_i--) {
			decimal += binary[arr_i] * binary_i;
			binary_i*=2;
		}
		return decimal;
	}
}
