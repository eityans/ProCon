import java.util.*;

public class Mathmatics {


  //素因数分解をする(index_0:素数 index_1:個数)
	static List<long[]> factorization(long M){
		List<long[]> primes = new ArrayList<>();
 
		long now_prime = 2;
		long now_M = M;
		while(now_prime*now_prime<=M){
			if(now_M%now_prime == 0){
				now_M /= now_prime;
				long[] prime = new long[2];
				prime[0] = now_prime;
				prime[1] = 1;
				while(now_M%now_prime == 0){
					now_M /= now_prime;
					prime[1]++;
				}
				primes.add(prime);
				
			}
			if(now_prime%2 == 0){
				now_prime++;
			}else{
				now_prime += 2;
			}
		}
		if (now_M>1){
			long[] prime = new long[2];
			prime[0] = now_M;
			prime[1] = 1;
			primes.add(prime);
		}
		
		return primes;
	}

	//オイラーのφ関数（nに対して、nと互いに素である1以上n以下の自然数の個数）
	static long phi(long n){
		List<long[]> primes = factorization(n);//素因数分解
		long rtn = n;
		for(long[] prime : primes){
			long p = prime[0];
			rtn /= p;
			rtn *= p-1;
		}
		return rtn;
	}

	//約数の配列を返す
	static long[] divisor(long num){
		Set<Long> divisors = new TreeSet<>();
		long tmp=1;
		while(tmp*tmp<=num){
			if(num%tmp == 0){
				divisors.add(tmp);
				divisors.add(num/tmp);
			}
			tmp++;
		}
		Long[] rtn = new Long[divisors.size()];
		divisors.toArray(rtn);
		long[] ans = new long[rtn.length];
		for(int i=0; i<rtn.length; i++){
			ans[i] = rtn[i];
		}
		return ans;
	}

	//階乗
	public static long fact(long a){
		if(a == 0 || a == 1)return 1;
		return a*fact(a-1);
	}

	//２点間の距離
	public static double distance(double X1, double Y1, double X2, double Y2){
		return Math.sqrt((X1-X2)*(X1-X2) + (Y1-Y2)*(Y1-Y2));
	}
}