import java.util.Scanner;

public class Solution {

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
