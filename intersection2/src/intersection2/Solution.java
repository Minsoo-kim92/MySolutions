package intersection2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner s = new Scanner(System.in))
	    {
	      int n = s.nextInt();
	      int min = 100000000;
	      int max = 0;
	      int[]ary = new int[10000000];
	      Arrays.fill(ary, 0);
	      for(int i = 0; i < n; i++)
	      {
	        int a = s.nextInt();
	        int b = s.nextInt();
	        
	        
	        min = Math.min(min, a);
	        max = Math.max(max, b);
			//여기부터 작성해 주세요
	        
	        for(int j=a; j<=b; j++ ) {
	        	ary[j]+=1;
	        }
		  }
	      ary[max] = 0;
	      for(int i=0; i<= max; i++) {
	    	  System.out.printf("%d ", i);
	      }
	      System.out.println();
	      for(int i=0; i<= max; i++) {
	    	  System.out.printf("%d ",ary[i]);
	      }
	      System.out.println("");
	      int swc =0;
	      int i=min+1;
	      
	      int start = -1;
	      int end = -1;
	      
	      System.out.println("(-, "+min+")");
	      while(i!=max) { //section 찾기
	    	  if(start== -1 && ary[i] % 2 == 0) {
	    		  start = i;
	    	  }else if (start != -1 && ary[i] % 2 == 0 && ary[i+1] % 2 == 1) {
	    		  end = i;
	    		  swc = 0;
	    	  }else if(start== -1 && ary[i] % 2 == 1) {
	    		  start = i;
	    	  }else if (start != -1 && (ary[i] == 1  && ary[i+1] % 2 !=1)){
	    		  end = i;
	    		  swc = 1;
	    	  }
	    	
	    	  
	    	  if(start !=-1 && end != -1 && swc == 0 ) {
	    		  System.out.printf("[%d, %d]\n",start,end);
	    		  start = -1;
	    		  end = -1;
	    	  }else if (start !=-1 && end != -1 && swc == 1) {
	    		  System.out.printf("(%d, %d)\n",start,end);
	    		  start = -1;
	    		  end = -1;
	    	  }
	    	  i++;
	      }
	      System.out.printf("("+max+", +)");
		}
	}

}

