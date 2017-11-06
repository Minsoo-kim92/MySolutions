package intersection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		try(Scanner s = new Scanner(System.in))
		{
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			int x3 = s.nextInt();
			int y3 = s.nextInt();
			int x4 = s.nextInt();
			int y4 = s.nextInt();
			int x5 = s.nextInt();
			int y5 = s.nextInt();
			int x6 = s.nextInt();
			int y6 = s.nextInt();
			int sum=0;
			//������� �ۼ��� �ּ���
			int xSize;
			int ySize;
			
			xSize = Math.max(Math.max(x2, x4),x6);
			ySize = Math.max(Math.max(y2, y4),y6);
			
			int[][] ary = new int[++xSize][++ySize];
			for(int i=0; i<xSize; i++) {
				Arrays.fill(ary[i], 0);
			}
			
			//1�� ���� �� 1�� ä��
			for(int i=x1; i<x2;i++) {
				for(int j=y1; j<y2;j++) {
					ary[i][j] = 1;
				}
			}
				
			//2������ 0 ���� ä��
			for(int i=x3; i<x4;i++) {
				for(int j=y3; j<y4;j++) {
					ary[i][j] = 0;
				}
			}
				
			//3������ 0 ���� ä��
			for(int i=x5; i<x6;i++) {
				for(int j=y5; j<y6;j++) {
					ary[i][j] = 0;
				}
			}
			
			PrintWriter pw = new PrintWriter("out.txt");
			
			
			for(int i=0; i<xSize;i++) {
				for(int j=0; j<ySize;j++) {
					if(ary[i][j] == 1) {
						sum++;
						
					}
					pw.print(ary[i][j] + " ");
				}
				pw.println();
			}
			pw.close();
			System.out.println(sum);
		}
	}

}