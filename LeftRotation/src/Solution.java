import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] leftRotation(int[] a, int d) {
        // Complete this function
    	int[] tmp = new int[a.length];
    	
    	for(int arr_i=d; arr_i<d+a.length; arr_i++) {
    		if(arr_i >= a.length) {
    			tmp[arr_i-d] = a[arr_i-a.length];
    		}else
    		tmp[arr_i-d] = a[arr_i]; 
    	}
    	return tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
