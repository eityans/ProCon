

import java.util.Scanner;


public class DP_E {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int D = Integer.parseInt(sc.next());
		char[] N = sc.next().toCharArray();
		int keta = N.length;
		long[][][] dp = new long[keta+1][2][D];
		dp[0][0][0] = 1;
		long INF = 1_000_000_007L;
		
		for(int i=0;i<keta;i++){
			for(int limit=0; limit<2; limit++){		//0:§ŒÀ—L‚èA1:§ŒÀ‚È‚µ
				for(int d=0; d<D; d++){
					int nd = N[i]-'0';	//i”Ô–Ú‚Ì”
					for(int l=0; l<=((limit==0) ? nd : 9);l++){
						int nl = (limit==0 && l==nd)?0:1;
						int d_i = (d+l)%D;
						dp[i+1][nl][d_i] += dp[i][limit][d]%INF;
					}
				}
			}
		}
		
		
		System.out.println(dp[keta][0][0]%INF+dp[keta][1][0]%INF-1);
		
		
		sc.close();
	}
	
}
