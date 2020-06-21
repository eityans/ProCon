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

	
	//aの逆元a^-1を求める
	//条件：aとmodが互いに素であること(aがmodの倍数でないこと)
	static long modinv(long a, long mod){
		long b = mod;
		long u = 1;
		long v = 0;
		while(b>0){
			long t = a/b;
			a -= t*b;
			long tmp = b;
			b = a;
			a = tmp;
			u -= t*v;
			tmp = v;
			v = u;
			u = tmp;
		}
		u %= mod;
		if(u<0) u+=mod;
		return u;
	}


	
	//繰り返し二乗法(x^n)
	static long pow(long x, long n){
		long sum = 1;
		while(n>0){
			if((n&1) == 1 ){
				sum = sum * x;
			}
			x = x * x;
			n >>= 1;
		}
		return sum;
	}
	
	//繰り返し二乗法(x^n % mod)
	static long modPow(long x, long n, long mod){
		long sum = 1;
		while(n>0){
			if((n&1) == 1 ){
				sum = sum * x % mod;
			}
			x = (x * x) % mod;
			n >>= 1;
		}
		return sum;
	}
	
	
	//素数判定
	static boolean isPrime(int n){
		int tmp = 2;
		boolean flg = true;
		while(tmp*tmp<=n){
			if (n%tmp == 0)flg = false;
			tmp++;
		}
		if(n <= 1)flg = false;
		return flg;
	}

	//エラトステネスの篩
	//要素数がn+1のboolean配列を返す。
	//素数のindexはtrueとなり、それ以外はfalseとなる
	static boolean[] eratosthenes(int n){
		boolean[] flg = new boolean[n+1];
		Arrays.fill(flg, true);
		flg[0] = flg[1] = false;
		for(int i=2; i<n+1; i++){
			if(!flg[i])continue;
			for(int j=i*2; j<n+1; j += i)flg[j] = false;
		}
		return flg;
	}
	
	//拡張ユークリッドの互除法
	//返り値、aとbの最大公約数
	//XとYが、ax+by=gcd(a,b)を満たすようになる
	static long X = 0L;				//拡張ユークリッドの互除法用
	static long Y = 0L;				//拡張ユークリッドの互除法用
	static long extGCD(long a, long b, long X, long Y){
		if(b == 0){
			X = 1;
			Y = 0;
			return a;
		}
		long d = extGCD(b, a%b, Y, X);
		Y -= a/b * X;
		
		return d;
	}


	//２点間の距離
	public static double distance(double X1, double Y1, double X2, double Y2){
		return Math.sqrt((X1-X2)*(X1-X2) + (Y1-Y2)*(Y1-Y2));
	}
}