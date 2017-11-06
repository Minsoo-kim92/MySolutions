package renaming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Solution {
	public static void main(String[] args) {
		String tmp = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
				+"john.png, London, 2015-06-20 15:13:22\n"
				+"myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
				+"Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
				+"pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
				+"BOB.jpg, London, 2015-08-05 00:02:03\n"
				+"notredame.png, Paris, 2015-09-01 12:00:00\n"
				+"me.jpg, Warsaw, 2013-09-06 15:40:22\n"
				+"a.png, Warsaw, 2016-02-13 13:33:50\n"
				+"b.jpg, Warsaw, 2016-01-02 15:12:22\n"
				+"c.jpg, Warsaw, 2016-01-02 14:34:30\n"
				+"d.jpg, Warsaw, 2016-01-02 15:15:01\n"
				+"e.png, Warsaw, 2016-01-02 09:49:09\n"
				+"f.png, Warsaw, 2016-01-02 10:55:32\n"
				+"g.jpg, Warsaw, 2016-02-29 22:13:11";
	
	String[] prePhotos = tmp.split("\n");
	MyPhotoManager mpm = new MyPhotoManager(prePhotos.length);
	for(int i=0; i<prePhotos.length; i++) {
		String[] splitInfo = prePhotos[i].split(", ");
		
		mpm.AddPhoto(splitInfo[0],splitInfo[1],splitInfo[2]);	
		
	}
	//mpm.printAll();
	//mpm.printCity();
	System.out.print(mpm.RenameAll());
	
	}
}


class MyPhoto {
	String name;
	String city;
	String extension;
	Date time;
	String changedName;
	public MyPhoto(String _name, String _city, Date _time){
		String[] splitName = _name.split("\\."); 
		name = splitName[0];
		extension = splitName[1];
		city = _city;
		time = _time;
		
	}
	public String Renaming(String number) {
		changedName = city+number.toString()+"."+extension;
		
		return changedName;
	}
	public String getChangedName() {
		if(changedName!=null)
			return changedName;
		return null;
	}
	
	public void printInfo() {
		System.out.println(name  + extension + city + time.toString() +"\n" );
	}
	public Date getTime() {
		return time;
	}
	public String getCity() {
		return city;
	}
}
class MyPhotoManager{
	MyPhoto[] photos;
	int index;
	MyCityManager mcm;
	int cIndex;
	public MyPhotoManager(int n){
		photos = new MyPhoto[n];
		index = 0;
		cIndex=0;
		mcm = new MyCityManager();
	}
	public void AddPhoto(String _name, String _city, String _time) {
		Date time;
		try {
			time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(_time);
			photos[index++] = new MyPhoto(_name,_city, time);
			mcm.putCity(_city, time);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void printAll() {
		for(int i=0;i<index;i++) {
			photos[i].printInfo();
		}
	}
	public void printCity() {
		mcm.printAll();
	}
	public String RenameAll() {
		String s = "";
		for(int i=0; i<index; i++) {
			s = s.concat(photos[i].Renaming(mcm.getSeq(photos[i].getCity(),photos[i].getTime()))+"\n");
		}
		return s;
	}
}
class MyCity{
	String name;
	Date[] time;
	int index;
	public MyCity(String _name, Date _time) {
		name = _name;
		index =0;
		time = new Date[100];
		time[index++]  = _time;
	}
	public String GetName() {
		return name;
	}
	public void putTime(Date _time) {
		int i;
		for(i=0; i<index; i++) {
			if(time[i] == null) {
				time[i] = _time;
				return;
			}
			if( _time.getTime() < time[i].getTime()) {
				break;
			}
		}
		
		index++;
		for(int j=index; j>i ; j--) {
			time[j] = time[j-1];
		}
		time[i] = _time;
	}
	public String getSeq(Date _time) {
		String a="";
		for(int i=0; i<index; i++) {
			if(time[i].getTime() == _time.getTime()) {
				if (index > 9 && i >=9) {
					a = String.valueOf(i+1);	
				}else if(index > 9 && i<10) {
					a = "0" + String.valueOf(i+1);
				}else a = String.valueOf(i+1);
				
				return a;
			}
		}
		return null;
	}
	public void print() {
		for(int i=0; i<index; i++) {
			System.out.println(i+" " + name + " " + time[i].getTime());
		}
	}
}
class MyCityManager{
	MyCity[] cities;
	int index;
	public MyCityManager() {
		index = 0;
		cities = new MyCity[100];
	}
	public void putCity(String city,Date _time) {
	//	System.out.println(city);
		if(index == 0) {
			cities[index++] = new MyCity(city, _time);
			return ;
		}
		for(int i=0; i< index; i++) {
			if(cities[i].GetName().equals(city)) {
				cities[i].putTime(_time);
				return;
			}
		}
		cities[index++] = new MyCity(city,_time);
	}
	public void printAll() {
		for(int i=0; i<index; i++) {
			cities[i].print();
		}
	}
	
	public String getSeq(String city, Date _time) {
		for(int i=0; i< index; i++) {
			if(cities[i].GetName().equals(city)) {
				return cities[i].getSeq(_time);
			}
		}
		return null;
	}
	
}