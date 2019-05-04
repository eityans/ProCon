import java.util.Arrays;
import java.util.Scanner;


public class ARC004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ARC004
		//https://arc004.contest.atcoder.jp/tasks/arc004_1
		Scanner sc = new Scanner(System.in);
		// ®”‚Ì“ü—Í
		int ans = 0;
		int N = Integer.parseInt(sc.next());
		int K = Integer.parseInt(sc.next());
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i] = Integer.parseInt(sc.next());
		}
		int deci = (int)Math.ceil( Math.log(K)/Math.log(2) );
		
		
		for(int i=deci;i>=0;i--){
			if((ans + Math.pow(2.0, (double)deci)) <= K){
				ans = ans + (int)Math.pow(2.0, (double)deci);
			}
		}
		System.out.println(ans);
	}
	
	public static int judge(int[] A,int deci){
		int count_1 = 0;
		int count_0 = 0;
		for(int i=0; i<A.length; i++){
			if (A[i]/Math.pow(2.0, (double)deci)>=1){
				count_1++;
			}else{
				count_0++;
			}
		}
		if(count_1>count_0){
			return 1;
		}else{
			return 0;
		}
	}
}
