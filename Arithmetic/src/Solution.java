
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {-1,1,3,3,3,2,1,0};
		
		int start=-1; 
		int end=-1;
		int chai = -100;
		
		for(int i=0; i<A.length; i++) {
			if(chai == -100) {
				chai = A[i] * -1 + A[i+1];
				System.out.println(chai);
			}
			if(start == -1) {
				start = i;
			}
			if(A[i]*-1 - A[i+1]== chai) {
				end = i;
			}
			
			if(i-start>=2){
				System.out.printf("(%d, %d) ",start,i);
				chai = -100;
				start = i;
			}
			
		}
	}

}