import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] myArray = new int[10];
		int i=0;
		while(sc.hasNext()) {
			myArray[i++] = sc.nextInt();
			if(i==10) break;
		}
		
		myArray = copy(myArray, i);
		
		MyQueue[] mq = new MyQueue[10];
		for(int j=0; j<mq.length; j++) {
			mq[j] = new MyQueue(10);
		}
		//초기화
		
		for(int j=0; j<myArray.length; j++) {				//1의 자릿수
			mq[myArray[j]%10].enQueue(myArray[j]);
		}
		i=0;
		for(int j=0; j<mq.length; j++) {				//myarray=dequeue
			while(!mq[j].isEmpty()) {
				myArray[i++] = mq[j].deQueue();
			}
		}
		for(int j=0; j<myArray.length; j++) {				//10의 자릿수
			mq[myArray[j]/10].enQueue(myArray[j]);
		}
		
		//System.out.println("");
		//for(i =0; i<myArray.length; i++)
		//	System.out.printf("%d ", myArray[i]);
		System.out.println("\n"+minMax(mq));
		
	}
	
	
	
	static int[] copy(int[] arr, int i) {
		int[] tmp = new int[i];
		for(int j=0; j<i; j++) {
			tmp[j] = arr[j];
		}
		return tmp;
	}
	
	static long minMax(MyQueue[] mq) {
		String stringValue="";
		long minMax[] = {0,0};
		for(int i=mq.length-1; i>1; i--) {
			while(!mq[0].isEmpty() && mq[0].maxPeak()*10 + mq[0].maxPeak() >mq[i].maxPeak() && !mq[i].isMaxEmpty()) {
						stringValue = stringValue.concat(String.valueOf(mq[0].maxDeQueue()));
			}	
			while(!mq[i].isMaxEmpty()) {
				if(!mq[0].isEmpty() && mq[0].maxPeak()*10 + mq[0].maxPeak() >mq[i].maxPeak() &&  !mq[i].isMaxEmpty()) {
					stringValue = stringValue.concat(String.valueOf(mq[0].maxDeQueue()));
				}
				stringValue = stringValue.concat(String.valueOf(mq[i].maxDeQueue()));
			}
		}
		while(!mq[1].isMaxEmpty()) {
			stringValue = stringValue.concat(String.valueOf(mq[1].maxDeQueue()));
		}
		while(!mq[0].isMaxEmpty()) {
			stringValue = stringValue.concat(String.valueOf(mq[0].maxDeQueue()));
		}
		
		minMax[1] = Long.valueOf(stringValue);
		
		stringValue = "";
		while(!mq[1].isEmpty()) {
			stringValue = stringValue.concat(String.valueOf(mq[1].deQueue()));
		}
		for(int i=2; i<mq.length; i++) {
			while(!mq[0].isEmpty() && mq[0].peak()*10 + mq[0].peak() < mq[i].peak()){
				stringValue = stringValue.concat(String.valueOf(mq[0].deQueue()));
			}
			while(!mq[i].isEmpty()) {
				if(!mq[0].isEmpty() && mq[0].peak()*10 + mq[0].peak() < mq[i].peak()) {
					stringValue = stringValue.concat(String.valueOf(mq[0].deQueue()));
				}
				stringValue = stringValue.concat(String.valueOf(mq[i].deQueue()));
			}
		}
		while(!mq[0].isEmpty()) {
				stringValue = stringValue.concat(String.valueOf(mq[0].deQueue()));
		}
				
		minMax[0] = Long.valueOf(stringValue);
		
		System.out.printf("max : %d \n min : %d", minMax[1], minMax[0]);
		return minMax[0]+minMax[1];
		
	}
}
class MyQueue {
	private int[] queue;
	private int index;
	private int maxIndex;
	public MyQueue(int size) {
		queue = new int[size];
		index = 0;
	}
	public void enQueue(int value) {
		queue[index++] = value;
		maxIndex = index;
	}
	public int deQueue() {
		if(index==0) {
			System.out.println("Queue is empty");
			return -1;
		}else if(index ==1) {
			int tmp = queue[0];
			queue[--index]=0;
			maxIndex=index;
			return tmp;
		}
		int tmp = queue[0];
		for(int i=0; i<index-1; i++) {
			queue[i] = queue[i+1];
		}
		queue[--index] = 0;
		maxIndex=index;
		return tmp;
	}
	public int maxDeQueue() {
		return queue[--maxIndex];
	}
	public boolean isEmpty() {
		return index==0;
	}
	public boolean isMaxEmpty() {
		return maxIndex==0;
	}
	public int maxPeak() {
		if(maxIndex==0) {
			return 0;
		}
		return queue[maxIndex-1];
	}
	public int peak() {
		return queue[0];
	}
}