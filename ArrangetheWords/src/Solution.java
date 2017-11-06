import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Solution {
	
    static String arrange(String sentence) {
    	
    	String[] splitSentence = sentence.split(" ");
    	String arrangedWords = "";
    	
    	int longestWordLength = 0;
    	
    	for(int arr_i=0; arr_i<splitSentence.length; arr_i++) {
    		if(longestWordLength < splitSentence[arr_i].length()) {
    			longestWordLength= splitSentence[arr_i].length();
    		}
    	}
    	
    	MyStringArray[] msa = new MyStringArray[longestWordLength];
    	
    	for(int arr_i=0,  index=0; arr_i<splitSentence.length; arr_i++) {
    		index =splitSentence[arr_i].length()-1;
    		if(msa[index] == null) {
    			msa[index] = new MyStringArray();
    			if(splitSentence[arr_i].contains(".")) {
    				splitSentence[arr_i]= splitSentence[arr_i].replace(".", "");
    			}
    			msa[index].append(splitSentence[arr_i]);
    		}
    		else {
    			if(splitSentence[arr_i].contains(".")) {
    				splitSentence[arr_i]= splitSentence[arr_i].replace(".", "");
    			}
    			msa[index].append(splitSentence[arr_i]);
    		}
    		
    	}
    /*	for(int arr_i=0; arr_i<msa.length; arr_i++) {
    		if(msa[arr_i]!=null)msa[arr_i].printAllString();
    	}*/
    	
    	for(int arr_i=0; arr_i<msa.length; arr_i++) {
    		if(msa[arr_i]!=null)
    			arrangedWords = msa[arr_i].concat(arrangedWords);
    	}
    	arrangedWords=arrangedWords.concat(".");

    	return arrangedWords;
    }
	
    /*static String[][] splitStrings(String sentence) {
    	
    	
    	return 
    }*/

static class MyStringArray {
	int index;
	String[] words;
	String regex;
	public MyStringArray() {
		index = 0;
		
		
	}
	public void append(String word) {
		if(words != null) {
			
			String[] tmp;
			tmp = new String[index+1];
			for(int i=0; i<words.length; i++)
				tmp[i] = words[i];
			tmp[index++] = word.toLowerCase();
			words = tmp;
		}
		else {
			words = new String[1];
			words[index++] = word.toLowerCase();
		}
	}
	public int getSize() {
		return index;
	}
	
	public String concat(String string) {
		String concatString= string;
		for(int i=0; i<words.length; i++) {
			if(concatString.length()==0) {
				words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
				concatString = words[i];
			}
			else
				concatString = concatString.concat(" "+ words[i]);
			
		}
		
		return concatString;
	}
}
    public static void main(String[] args) throws IOException {
    	
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String res;
        String sentence;
        try {
            sentence = in.nextLine();
        } catch (Exception e) {
            sentence = null;
        }

        res = arrange(sentence);
        bw.write(res);
        bw.newLine();

        bw.close();
    }
}