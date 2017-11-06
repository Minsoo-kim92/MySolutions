package cacheHitRatio;

import java.util.Scanner;

public class cache {
	public static int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      
	      MyCacheManager mm = new MyCacheManager(cacheSize);
	      if(cacheSize == 0) {
	    	  answer = cities.length * 5;
	    	  return answer;
	      }
	      for(int i=0; i<cities.length; i++) {
	    	  mm.putIn(cities[i]);
	      }
	      
	     // System.out.println(mm.getRunningTime());
	      answer = mm.getRunningTime();
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] cities = new String[10];
		for(int i=0; i<10; i++ ) {
			
			cities[i] = sc.next();
		}
		
		solution(n,cities);
	}

}

class MyCache
{
	String name;
	int seq;
	public MyCache(String name,int seq) {
		this.name = name.toLowerCase();
		this.seq = seq;
	}

	public String getName() {
		return name;
	}
	public void setName(String name,int seq) {
		this.name = name.toLowerCase();
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
	
	public MyCacheManager(int size){
		maxSize = size;
		MyCaches = new MyCache[size];
		runningTime = 0;
		curSize = 0;
		seq = 0;
		lowest = 100002;
	}
	public void putIn(String name) {
		int index=0;
		int cacheSeq;
		if(maxSize > curSize) {			// miss
			MyCaches[curSize++] = new MyCache(name.toLowerCase(),seq++);
			System.out.println(seq);
			runningTime+=5;
			//printCaches();
			return ;
		}
		for(int i=0; i<maxSize; i++) {
			cacheSeq = MyCaches[i].getSeq();
			if(lowest > cacheSeq) {
				lowest = cacheSeq;
				index = i;
			}
			if(name.toLowerCase().equals(MyCaches[i].getName())) {
				runningTime++;
				MyCaches[i].setSeq(seq++);
				return;
			}
		}
		MyCaches[index].setName(name,seq++);
		//System.out.println(seq);
		runningTime+=5;
		lowest = 100002;
		//printCaches();
	}
	public int getRunningTime() {
		return runningTime;
	}
	private void printCaches() {
		for(int i=0; i< curSize; i++) {
			System.out.printf("%s ", MyCaches[i].getName());
		}
		System.out.println("");
	}
}