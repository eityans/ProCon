public class Reference {
  //ここには実装の仕方を参考にする系のものを入れる
  
	//a_i≧kとなるような最小のiを求める(0≦i≦N-1)
	//存在しなかったら-1を返す
	static int lower_bound(long[] A, long k){
		int N = A.length;
		int lb = -1;
		int ub = N;
		while(ub-lb > 1){
			int mid = (lb + ub) / 2;
			if(A[mid] >= k){
				ub = mid;
			}else{
				lb = mid;
			}
		}
		return ub;
	}

	//k≧a_iとなるような最大のiを求める(0≦i≦N-1)
	//存在しなかったらa_N-1を返す
	static int upper_bound(long[] A, long k){
		int N = A.length;
		int lb = -1;
		int ub = N;
		while(ub-lb > 1){
			int mid = (lb + ub) / 2;
			if(A[mid] <= k){
				lb = mid;
			}else{
				ub = mid;
			}
		}
		if(lb == N) lb = N-1;
		return lb;
	}
}