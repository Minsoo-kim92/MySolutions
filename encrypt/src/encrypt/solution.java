package encrypt;

import java.util.Scanner;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String order = sc.next();
		
		char[] secretWord = sc.next().toCharArray();
		
		int n = sc.nextInt();
		
		char[] word = sc.next().toCharArray();
		int[] newWord = new int[word.length];
		//System.out.printf("%c, %c ",  word[0],secretWord[0]);
		
		if(order.equals("encrypt")) {
			for(int i=0; i<word.length; i++) {
				int a = (secretWord[i]-97 + word[i]);
				if(a>122) a -=26;
				newWord[i] =a; 
			}
			for(int i=n; i<newWord.length+n;i++) {
				if(i>=newWord.length) {
					System.out.printf("%c",newWord[i-newWord.length]);
				}else
					System.out.printf("%c",newWord[i]);
			}
			}
		else {
			for(int i=0; i<word.length; i++) {
				int a = (word[i]-(secretWord[i]-97));
				if(a<96) a +=26;
				newWord[i] =a; 
			}
			for(int i=n; i<newWord.length+n;i++) {
				if(i>=newWord.length) {
					System.out.printf("%c",newWord[i-newWord.length]);
				}else
					System.out.printf("%c",newWord[i]);
			}
			}
			
		}
			
		
	}


/// ((¿ø·¡ ¾ËÆÄºª - 97) + (´õÇÒ ¾ËÆÄºª )-97)*n))%26