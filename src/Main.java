

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] A = new int[N];
		int count = 0;
		int[] B = new int[N];
		for(int i=0;i<N;i++){
			A[i] = Integer.parseInt(sc.next());
			if(A[i]<0)count++;
			B[i] = Math.abs(A[i]);
		}
		
		Arrays.sort(B);
		long ans = 0;
		if(count%2 == 0){
			for(int i=0; i<N; i++)
				ans += (long)B[i];
		}else{
			ans -= B[0];
			for(int i=1; i<N; i++)
				ans += (long)B[i];
		}
		
		
		



		System.out.println(ans);
		
		
		sc.close();
	}
	
}
