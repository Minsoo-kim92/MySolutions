package phoneBills;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

	public static int solution(String S) {
		String[] sprString = S.split("\n");
		int length = sprString.length;
		int charge;
	/*	for(int i=0; i<length; i++) {
			System.out.println(sprString[i]);
		}*/
		CallLogsManager clm = new CallLogsManager(length);
		
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		
		long duration=0;
		int num;
		for(int i=0; i< length; i++) {
			String[] logAndNum = sprString[i].split(",");

			try {
			      Date d1 = f.parse("00:00:00");
			      Date d2 = f.parse(logAndNum[0]);
			      long diff = d1.getTime() - d2.getTime();
			      long sec = -1*diff / 1000;
				duration = sec;
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String splitNum[] = logAndNum[1].split("-");
			num = Integer.parseInt((splitNum[0] + splitNum[1] + splitNum[2]));
			
			clm.putLog(duration	, num);
		}
		//clm.printAllLogs();
		
		
		CallLog longest = clm.getLongDurationLog();
		
		if(clm.isTied(longest.getDuration())) return 0;
		
		if(longest.getDuration() >= 360) {
			charge = (int) (longest.getDuration() / 60) * 150;
		}
		else 
			charge = (int) longest.getDuration() * 3;
		System.out.println("charge = " + charge);
		System.out.println(longest.getDuration() + " " + longest.getPhoneNum());
		
		return charge;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solution("00:05:00,400-234-090\n00:05:00,701-080-080\n00:05:00,400-234-090\n00:05:00,701-080-080");
		solution("00:04:59,400-234-090");
	}

}
class CallLog{
	long duration;
	int phoneNum;
	public CallLog(long duration, int phoneNum) {
		this.duration = duration;
		this.phoneNum = phoneNum;
	}
	
	public void addDuration(long duration) {
		this.duration += duration;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public long getDuration() {
		return duration;
	}
}

class CallLogsManager {
	CallLog[] cls;
	int index;
	public CallLogsManager(int size) {
		cls = new CallLog[size];
		index = 0;
	}
	public void putLog(long duration, int phoneNum) {
		if( index == 0) {
			cls[index++] = new CallLog(duration, phoneNum);
			return;
		}
		for(int i=0; i<index; i++) {
			if(cls[i].getPhoneNum() == phoneNum) {
				cls[i].addDuration(duration);
				return;
			}
		}
		cls[index++] = new CallLog(duration, phoneNum);
		return;
	}
	public CallLog getLongDurationLog() {
		long max=cls[0].getDuration();
		int longestIndex=0;
		if(index == 1) {
			return cls[longestIndex];
		}
		for(int i=0; i<index; i++) {
			if(max < cls[i].getDuration()) {
				max = cls[i].getDuration();
				longestIndex = i;
			}
		}
		return cls[longestIndex];
	}
	
	public boolean isTied(long longest) {
		if(index == 1) {
			return false;
		}
		for(int i=0; i<index; i++) {
			if(longest != cls[i].getDuration()) return false;
		}
		
		return true;
	}
	public void printAllLogs() {
		for(int i=0; i<index; i++) {
			System.out.println(cls[i].getDuration() + ", " + cls[i].getPhoneNum());
		}
	}
}