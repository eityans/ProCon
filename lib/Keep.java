import java.util.*;
public class Keep {
  //2つのint配列を連結させる
	static int[] joinArray(int[] A, int[] B){
		int[] tmp = new int[A.length + B.length];
		System.arraycopy(A, 0, tmp, 0, A.length);
		System.arraycopy(B, 0, tmp, A.length, B.length);
		return tmp;
	}
	
	//2つのint配列が等しいかどうか判定する
	static boolean arrayEqual(int[] A, int[] B){
		if(A.length != B.length)return false;
		for(int i=0; i<A.length; i++){
			if(A[i] != B[i])return false;
		}
		return true;
  }
  
	//AとBの素因数分解の結果をもとに、A*Bの素因数分解の結果を返す
	static List<long[]> factorizationMerge(List<long[]> A, List<long[]> B){
		List<long[]> primes = new ArrayList<>(A);
		for(long[] b : B){
			boolean isExist = false;
			for(long[] a : primes){
				if(a[0] == b[0]){
					isExist = true;
					a[1] += b[1]; 
				}
			}
			if(!isExist)primes.add(b);
		}
		return primes;
	}
	
}