import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class ARC004A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ARC004
		//https://arc004.contest.atcoder.jp/tasks/arc004_1
		Scanner sc = new Scanner(System.in);
		// ®”‚Ì“ü—Í
		double ans = 0;
		int N = Integer.parseInt(sc.next());
		int[][] dots = new int[N][2];
		for(int i=0; i<N; i++){
			dots[i][0] = Integer.parseInt(sc.next());
			dots[i][1] = Integer.parseInt(sc.next());
		}
		for(int i=0; i<N; i++){
			for(int j=i+1; j<N; j++){
				double newlength = length(dots[i],dots[j]);
				if(ans < newlength)ans = newlength;
			}
		}
		
		System.out.println(ans);
	}
	
	public static double length(int[] dot1, int[] dot2){
		return Math.sqrt((dot1[0]-dot2[0])*(dot1[0]-dot2[0]) + (dot1[1]-dot2[1])*(dot1[1]-dot2[1]));
	}
	
}
