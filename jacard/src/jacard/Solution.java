package jacard;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			String str1 = sc.next();
			String str2 = sc.next();
			
			MySetManager mu = new MySetManager(str1, str2);
			
	}
}

class MySet{
	String element;
	int count;
	
	public MySet(String element) {
		this.element = element;
		count = 1;
	}
	public String getElement() {
		return element;
	}
	public void addCount() {
		count++;
	}
	public void print() {
		System.out.println(element + " " + count);
	}
}
class MySetManager{
	String[] myStr1;
	String[] myStr2;
	MySet[] mySet;
	int setIndex;
	String regex;
	Pattern p;
	public MySetManager(String str1, String str2) {
		setIndex = 0;
		regex = "^([A-Za-z]*$)";
		p = Pattern.compile(regex);
		int i=0;
		while(true) {
			if(i + 1 == str1.length())break;
			String tmp =str1.substring(i, i+2).toLowerCase();
			if(myStr1!=null) {
				if(p.matcher(tmp).find()) {
					myStr1 = putString(myStr1, tmp);
				}
			}else {
				myStr1 = new String[1];
				if(p.matcher(tmp).find()) {
					myStr1[i] = tmp;
				}
			}
			i++;
		}
		i=0;
		while(true){
			if(i +1 == str2.length())break;
			String tmp =str2.substring(i, i+2).toLowerCase();
			if(myStr2!=null) {
				if(p.matcher(tmp).find()) {
					myStr2 = putString(myStr2, tmp);
				}
			}else {
				myStr2 = new String[1];
				if(p.matcher(tmp).find()) {
					myStr2[i] = tmp;
				}
			}
			i++;
		}
		for(int j=0; j<myStr1.length; j++)
		{
			System.out.printf("%s ",myStr1[j]);
		}
		for(int j=0; j<myStr2.length; j++)
		{
			System.out.printf("%s ",myStr2[j]);
		}
		findUnion();
		System.out.println("");
		makeUnion();
			
	}
	public void findUnion() {
		
		if(myStr1.length > myStr2.length) {
			putIn(myStr1,myStr2);
		}
		else
			putIn(myStr2,myStr1);
	}
	public void putIn(String[] str1, String[] str2) {
		
		First : for(int i=0; i<str1.length; i++) {
			Second :for(int j=0; j<str2.length; j++) {
				if(str1[i].equals(str2[j])) {
					if(mySet==null) {
						mySet = new MySet[1];
						mySet[setIndex++] = new MySet(myStr1[0]);
						break;
					}else {
						MySet[] tmp = new MySet[mySet.length+1];
						for(int arr_i=0; arr_i<mySet.length; arr_i++) {
							tmp[arr_i] = mySet[arr_i];
							if(mySet[arr_i].getElement().equals(str1[i])){
								mySet[arr_i].addCount();
								break Second;
							}
						}
						tmp[setIndex++] = new MySet(str1[i]);
						mySet = tmp;
						break;
					}
				}
				else {
					
				}
					
			}
		}
	}
	public String[] makeUnion() {
		String[] tmp = new String[myStr1.length + myStr2.length];
		String tmp2;
		for(int i=0; i< myStr1.length; i++) {
			tmp[i] = myStr1[i];
		}
		for(int j=myStr1.length; j< myStr2.length+myStr1.length; j++) {
			tmp[j] = myStr2[j-myStr1.length];
		}
		
		for(int i=0; i<tmp.length; i++) {
			for(int j=0; j<tmp.length; j++) {
				
			}
		}
		
		System.out.printf("%s ", tmp[i]);
		
		return tmp;
	}
	public String[] putString(String[] stringArray, String str) {
		int i;
		
		String[] tmp = new String[stringArray.length+1];
		for(i=0; i<stringArray.length; i++)
			tmp[i] = stringArray[i];
		
		tmp[i] = str;
		return tmp;
	}
	public void print() {
		for(int i=0; i< mySet.length; i++) {
			mySet[i].print();
		}
	}
}