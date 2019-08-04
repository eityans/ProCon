import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
 
 
public class Main {

	static long MOD = 1_000_000_007;
	static int INF = 1_000_000_007;
	//�񍀌W���֘A��������-----
	static boolean isPreprocessing = false;	//�񍀌W�����v�Z���邽�߂̑O�������s���Ă��邩�ǂ����̃t���O
	static int MAX = 260;				//MAX�܂ŊK��₻���̋t���̃e�[�u����ێ�����B
	static long[] fac;	//fac[i] := i! % MOD
	static long[] inv;	//inv[i] := mod. MOD�ɂ����� i �̋t��
	static long[] finv;	//finv[i] := mod. MOD�ɂ����� i! �̋t��(inv�̗ݐ�"��")
	//�񍀌W���֘A�����------
	
	static int[] roots;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//int N = Integer.parseInt(sc.next());
		//long L = Long.parseLong(sc.next());
		//char[] A = sc.next().toCharArray();
			
		
		
	}
	
	static boolean same(int a, int b){
		if(root(a) == root(b)){
			return true;
		}else{
			return false;
		}
	}
	
	static int root(int a){
		if(a == roots[a])return a;
		return roots[a] = root(roots[a]);
	}
	
	static void join(int a, int b){
		if(root(a) == root(b))return;
		roots[b] = root(a);
	}
	
	//�f��������������(index_0:�f�� index_1:��)
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
		if (now_M>1 || M==1){
			long[] prime = new long[2];
			prime[0] = now_M;
			prime[1] = 1;
			primes.add(prime);
		}
		
		return primes;
	}
	
	//�Q��int�z���A��������
	static int[] joinArray(int[] A, int[] B){
		int[] tmp = new int[A.length + B.length];
		System.arraycopy(A, 0, tmp, 0, A.length);
		System.arraycopy(B, 0, tmp, A.length, B.length);
		return tmp;
	}
	
	//�Q��int�z�񂪓��������ǂ������肷��
	static boolean arrayEqual(int[] A, int[] B){
		if(A.length != B.length)return false;
		for(int i=0; i<A.length; i++){
			if(A[i] != B[i])return false;
		}
		return true;
	}
	
	//int�z���index���Ɍ��āA�v�f�̏d�����������ꍇ���̗v�f�ƊԂ̗v�f���폜����12123��23
	static int[] calc(int[] A){
		boolean[] tmp = new boolean[A.length];
		Arrays.fill(tmp, true);
		int fetch = 0;
		while(fetch<A.length-1){
			boolean isExist = false;
			for(int i=fetch+1; i<A.length;i++){
				if(A[fetch] == A[i]){
					for(int j=fetch;j<=i;j++){
						tmp[j]=false;
					}
					fetch = i+1;
					isExist = true;
					break;
				}
			}
			if(!isExist)fetch++;
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<A.length; i++){
			if(tmp[i])list.add(A[i]);
		}
		
		int[] foo = new int[list.size()];
		for(int i=0; i<list.size(); i++){
			foo[i] = list.get(i);
		}
		/*
		for(boolean t : tmp)
			System.out.print(t+" ");
		*/
		return foo;
	}
	
	
	//a��b�̍ŏ����{����Ԃ�
	static long lcm (long a, long b) {
		long temp;
		long c = a;
		c *= b;
		while((temp = a%b)!=0) {
			a = b;
			b = temp;
		}
		return (c/b);
	}
	
	//�񍀌W���p�̑O����
	static void COMinit(){
		//�񍀌W�����Z�p�O����
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
	
	//�񍀌W��i_C_j��MOD�Ŋ������]���Ԃ�
	static long COM(int i, int j){
		if(i<j)return 0;
		if(i<0 || j<0)return 0;
		if(!isPreprocessing)COMinit();
		return fac[i] * (finv[j] * finv[i-j] % MOD) % MOD;
	}
	
}

