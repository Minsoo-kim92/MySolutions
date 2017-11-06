import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] sparseArrays(String[] i_arry, String[] s_arry){
		
		int[] counts = new int[s_arry.length];
		Arrays.fill(counts, 0);
		for(int arr_i=0; arr_i<s_arry.length; arr_i++) {		//찾을 값
			for(int arr_j=0; arr_j<i_arry.length; arr_j++) {		//찾는 곳
				if(s_arry[arr_i].equals(i_arry[arr_j])) {
					counts[arr_i]++;
				}
			}
		}
		
		
		
		return counts;
	}
	public static void main(String[] args) {
			        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String[] i_string = new String[N];
		
		for(int arr_i=0; arr_i<N; arr_i++) {
			i_string[arr_i] = in.next();
		}
		
		int Q = in.nextInt();
		String[] f_string = new String[Q];
		
		for(int arr_i=0; arr_i<Q; arr_i++) {
			f_string[arr_i] = in.next();
		}
		
		int[] counts = sparseArrays(i_string, f_string);
		
		for(int arr_i=0; arr_i<counts.length; arr_i++) {
			System.out.println(counts[arr_i]);
		}
	}
}
