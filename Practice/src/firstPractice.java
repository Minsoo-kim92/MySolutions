import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
public class firstPractice {
/*	static void plusMinus(int[] arr){
        double[] pmz = {0,0,0};
        for(int i=0; i< arr.length; i++)
        {
            if(arr[i]>0){
                pmz[0]+=1;
            }else if(arr[i]<0){
                pmz[1]+=1;
            }else
                pmz[2]+=1;
        }
        for(int i=0; i< pmz.length; i++){
            System.out.printf("%.6f\n",pmz[i]/arr.length);
        }
    }
	 static void Stair(int n){
	        for(int row=1; row<n+1; row++){
	            for(int i=0; i<n-row;i++){
	                   System.out.printf(" ");
	            }
	            for(int j=0; j<row; j++){
	                    System.out.printf("#");
	            }
	                    System.out.println("");
	        }
	    }
	 
	 static long[] MiniMaxSum(int[] arr){
	
	        long min=1000000000000L, max=0;
	        long sum=0;
	        for(int i=0; i<arr.length; i++ ){
	            for(int j=0; j<arr.length; j++){
	                if(j != i){
	                    sum+=arr[j];
	                }
	            }
	            if(min>sum) min = sum;
	            if(max<sum) max = sum;
	            sum=0;
	        }
	        long[] results = {min,max};
	        return results;
	    }
	 static int hourglassSum(int[][] arr) {
		 int maxSum=-2000;
		 int sum;
		 for(int arr_i=0; arr_i<arr.length-2; arr_i++) {
			 for(int arr_j=0; arr_j<arr.length-2; arr_j++) {
				 //0 0 1 2 
				 //1   1 
				//2 0 1 2
				//
				 sum = (arr[arr_i][arr_j] + arr[arr_i][arr_j+1] + arr[arr_i][arr_j+2] +
				 			arr[arr_i+1][arr_j+1]+
				 arr[arr_i+2][arr_j] + arr[arr_i+2][arr_j+1] + arr[arr_i+2][arr_j+2]);
				 if(sum>maxSum) {
					 maxSum = sum;
				 }
			 }
		 }
		 return maxSum;
	 }
*/
	 static void appendSequence(int y,int N, int lastAnswer, MyArray[] seqList, int index) {
		 if(seqList[index]== null) {
			 //array null
			 seqList[index] = new MyArray(N);
			 seqList[index].append(y);
		 }
		 else
			 seqList[index].append(y);
		// seqList[index][] = y;
	}
	 static int getAnswer(int x,int y,int N,int lastAnswer, MyArray[] seqList, int index) {
		
		 if(seqList[index]==null) {
			 System.out.printf("");
		 }
		 int answer = seqList[index].getValue(y % seqList[index].getSize());
		
		 return answer;
	 }
    public static void main(String[] args) {

   	 	Scanner in = new Scanner(System.in);
    	 
    	 int lastAnswer= 0;
    	 int N = in.nextInt();
    	 int Q = in.nextInt();
    	 int q,x,y;
    	 int index;
    	 
    	 MyArray[] seqList = new MyArray[N];
    	 
    	 
    	 for(int i=0; i< Q; i++) {
    		 q = in.nextInt();
    		 x = in.nextInt();
    		 y = in.nextInt();
    		 index = ((x ^ lastAnswer)%N);
    		 if(q == 1) {
    			 appendSequence(y, N, lastAnswer, seqList, index);
    		 }else if(q == 2) {
    			 lastAnswer = getAnswer(x, y, N, lastAnswer, seqList, index);
    			 System.out.println(lastAnswer);
    		 }
    		 
    	 }
        
    }
	    
}
class MyArray {
	int index;
	int[] array = null;
	public MyArray(int arr_size) {
		index = 0;
	}
	public int getValue(int arr_index) {
		return array[arr_index];
	}
	public void append(int value) {
		if(array != null) {
			int[] tmp;
			tmp = new int[index+1];
			for(int i=0; i<array.length; i++)
				tmp[i] = array[i];
			tmp[index++] = value;
			array = tmp;
		}
		else {
			array = new int[1];
			array[index++] = value;
		}
	}
	public boolean isArrayNull() {
		return array == null;
	}
	public int getSize() {
		return index;
	}
}