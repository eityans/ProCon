import java.io.PrintWriter;

import input.FastScanner;

//	cf.	 https://drken1215.hatenablog.com/entry/2018/06/08/210000
public class Combination {	
	
	public static void main(String[] args) throws Exception {
		
		COMinit();

		out.println(COM(4,2));
		out.flush();
	}
	
	static FastScanner scan = new FastScanner();
	static PrintWriter out = new PrintWriter(System.out);			 

	static long MOD = 1_000_000_007;

	static boolean isPreprocessing = false;	//二項係数を計算するための前処理を行っているかどうかのフラグ
	static int MAX = 666667;				//MAXまで階乗やそれらの逆元のテーブルを保持する。
	static long[] fac;	//fac[i] := i! % MOD
	static long[] inv;	//inv[i] := mod. MODにおける i の逆元
	static long[] finv;	//finv[i] := mod. MODにおける i! の逆元(invの累積"積")

	
	//二項係数用の前処理
	static void COMinit(){
		//二項係数演算用前処理
		fac = new long[MAX+1];
		fac[0] = 1L;
		fac[1] = 1L;
		inv = new long[MAX+1];
		inv[1] = 1L;
		finv = new long[MAX+1];
		finv[0] = 1L;
		finv[1] = 1L;
		for(int i=2;i<MAX;i++){
			fac[i] = fac[i-1] * i % MOD;
			inv[i] = MOD - inv[(int)(MOD%i)] * (MOD/i) % MOD;
			finv[i] = finv[i-1] * inv[i] % MOD;
		}
		isPreprocessing = true;
	}
	
	//二項係数i_C_jをMODで割った余りを返す
	static long COM(int i, int j){
		if(i<j)return 0;
		if(i<0 || j<0)return 0;
		if(!isPreprocessing)COMinit();
		return fac[i] * (finv[j] * finv[i-j] % MOD) % MOD;
	}
}