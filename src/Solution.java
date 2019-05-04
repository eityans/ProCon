

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;


public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		int W = Integer.parseInt(sc.next());
		
		int[] question = {1,2,3,4,5,6};
		
		for(int i=0; i<T; i++){
			
			
			long[] A = new long [W];
			//System.out.println(mod_6);
			for(int j=0;j<W;j++){
				System.out.println(question[j]);
				A[j] = Integer.parseInt(sc.next());
			}
			
			long R1 = (5*A[0] - 4*A[1] - 2*A[2] + A[5])/40;
			long R2 = A[1]-A[0]-2*R1;
			long R3 = A[2]-A[1]-4*R1;
			long R4 = A[3]-A[2]-8*R1-2*R2;
			long R5 = A[4]-A[3]-16*R1;
			long R6 = A[5]-A[4]-32*R1-4*R2-2*R3;
			
			//System.out.println("Case #"+(i+1)+": "+ans);
			System.out.println(""+R1+" "+R2+" "+R3+" "+R4+" "+R5+" "+R6+" ");
			int result = Integer.parseInt(sc.next());
			if(result == -1) return;
		}
		
		
		sc.close();
		return;
	}
	

	
}
