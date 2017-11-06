import java.util.Scanner;
public class MyItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] items = {1,2,3,4,5,6};
		int[] dropItems = new int[100];
		int i=0;
		while(sc.hasNext()) {
			dropItems[i++] = sc.nextInt();
			if(i==9) break;
		}
		int[] tmp = new int[i];
		for(int j=0; j<i; j++)
			tmp[j] = dropItems[j];
		dropItems = tmp;
		
		solution(3,dropItems);
		
	}

	public static int solution(int cacheSize, int[] items) {
	      int answer = 0;
	      
	      MyCacheManager mm = new MyCacheManager(cacheSize);
	     /* if(cacheSize == 0) {
	    	  answer = cities.length * 5;
	    	  return answer;
	      }*/
	      for(int i=0; i<items.length; i++) {
	    	  mm.putIn(items[i]);
	      }
	      if(mm.count == 0) {
	    	  System.out.println(mm.count);
	      }
	     // System.out.println(mm.getRunningTime());
	      
	      return answer;
	  }
}


	

class MyCache
{
	int item;
	int seq;
	public MyCache(int item,int seq) {
		this.item =item;
		this.seq = seq;
	}

	public int getName() {
		return item;
	}
	public void setName(int item,int seq) {
		this.item =item;
		this.seq = seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq; 
	}
}

class MyCacheManager {
	MyCache[] MyCaches;
	int maxSize;
	int curSize;
	int runningTime;
	int lowest;
	int seq;
	int count;
	
	public MyCacheManager(int size){
		maxSize = size;
		MyCaches = new MyCache[size];
		curSize = 0;
		seq = 0;
		lowest = 100002;
		count=0;
	}
	public void putIn(int item) {
		int index=0;
		int cacheSeq;
		if(maxSize > curSize) {			// miss
			MyCaches[curSize++] = new MyCache(item,seq++);
			//System.out.println("처음 들어가는 아이템" + item);
			//printCaches();
			return ;
		}
		for(int i=0; i<maxSize; i++) {
			cacheSeq = MyCaches[i].getSeq();
			if(lowest > cacheSeq) {
				lowest = cacheSeq;
				index = i;
			}
			if(item == MyCaches[i].getName()) {
				MyCaches[i].setSeq(seq++);
				//System.out.println("히트 "+ MyCaches[i].getName());
				lowest = 100002;
				return;
			}
		}
		System.out.println(MyCaches[index].getName());
		MyCaches[index].setName(item,seq++);
		count++;
		//System.out.println(seq);
		lowest = 100002;
		//printCaches();
	}
}