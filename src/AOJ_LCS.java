import java.util.Scanner;
 
 
public class AOJ_LCS {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		for(int tr=0; tr<T; tr++){
			char[] X = sc.next().toCharArray();
			char[] Y = sc.next().toCharArray();
			int X_len = X.length;
			int Y_len = Y.length;
			int[][] dp = new int[X_len+1][Y_len+1];
			
			for(int x=0; x<X_len; x++){
				for(int y=0; y<Y_len; y++){
					if(X[x] == Y[y]){
						dp[x+1][y+1] = dp[x][y]+1;
					}else{
						dp[x+1][y+1] = Math.max(dp[x+1][y],dp[x][y+1]);
					}
				}
			}
			System.out.println(dp[X_len][Y_len]);
		}
		sc.close();
	}
	
	
	
}