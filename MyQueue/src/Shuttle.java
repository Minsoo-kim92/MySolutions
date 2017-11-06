import java.sql.Time;
import java.time.LocalTime;

public class Shuttle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime startTime = LocalTime.of(9, 0);
		
		System.out.println(startTime);
	}

}

class MyQueue {
	int N;			//운행횟수
	int T;			// 운행 인터벌
	int M;			// 최대 운용수
	
	String[] timetable;
	int tableIndex=0;
	public MyQueue(int n,int t, int m){
		N = n;
		T = t;
		M = m;
	}
	public void putTable(String time) {
		if(timetable==null) {
			timetable = new String[tableIndex];
			timetable[tableIndex++] = time;
		}
		else {
			String[] tmp = new String[tableIndex++];
			for(int i=0; i<timetable.length;i++) {
				tmp[i] = timetable[i];
			}
			tmp[tableIndex] = time;
			timetable = tmp;
		}
	}
	
	
}