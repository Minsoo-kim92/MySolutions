package oneTimeSort;

public class Solution {
	static public boolean solution(int[] A) {
        // write your code in Java SE 8
		
		A[0] = 2;
		A[1] = 0;
		A[2] = 5;
		A[3] = 0;
		A[4] = 7;
		
		int i=0;
		int tmp=-100000000;
		for(i=0; i<A.length-1; i++) {
			if(A[i] > A[i+1]) {
				tmp = A[i]; 
				break;
			}
		}
		if (tmp == -100000000) return true;
		
		for(int j=i; i<A.length; j++) {
			if(tmp <A[j]) {
				A[i] = A[j-1];
				A[j-1] = tmp;
				break;
			}else if (j == A.length-1 && tmp>A[j]) {
				A[i] = A[j];
				A[j] = tmp;
				break;
			}
		}
		for(i=0; i< A.length-1; i++) {
			if(A[i] > A[i+1]) {
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= new int[5];;
		System.out.println(solution(A));
		for(int i=0; i< A.length;i++) {
			System.out.printf("%d", A[i]);
		}
	}

}
