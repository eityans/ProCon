import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
 

public class Main {	
	
	public static void main(String[] args) throws Exception {
		
		//int N = scan.nextInt();
		//long L = scan.nextLong();
		//double D = scan.nextDouble();
		//char[] A = scan.next().toCharArray();

		out.println();
		out.flush();
	}
	
	static FastScanner scan = new FastScanner();
	static PrintWriter out = new PrintWriter(System.out);			 
	static long MOD = 1_000_000_007;
	static long INF = 1_000_000_007;
	
	static int[] roots;		//Union-find木用
	//static List<ArrayList<Integer>> G;	//グラフ用

	static List<List<E>> G = new ArrayList<>();	//グラフ用
	static List<E> Edges = new ArrayList<>();	//グラフ用
	static int V;								//グラフ用頂点の数
	static int E;								//グラフ用辺の数
	static long[] X = new long[1];				//拡張ユークリッドの互除法用
	static long[] Y = new long[1];				//拡張ユークリッドの互除法用
	//旧入力
	//Scanner sc = new Scanner(System.in);
	//int N = Integer.parseInt(sc.next());
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] dx8 = {1,-1,0,0,1,1,-1,-1};
	static int[] dy8 = {0,0,1,-1,1,-1,1,-1};
	
	
	/*	グラフ形式の入力を行う
	 * 	前提：M個の辺があるとき、以下の形式で辺情報が与えられることを期待している
	 * 		1 2
	 * 		2 3
	 *  	2 4
	 *  入力：
	 *  	int		N		: 頂点の数
	 *  	int 	M		: 辺の数
	 *  	boolean	isArrow	: 無向グラフか有向グラフかを表すフラグ（trueならば有向グラフ）
	 *  出力：ArrayList<ArrayList<Integer>>
	 * 
	 */
	static ArrayList<ArrayList<Integer>> inputG(int N, int M, boolean isArrow){
		ArrayList<ArrayList<Integer>> G = new ArrayList<>();
		
		for(int i=0; i<N; i++){
			ArrayList<Integer> V = new ArrayList<>();
			G.add(V);
		}
		for(int i=0; i<M; i++){
			int u = scan.nextInt() - 1;
			int v = scan.nextInt() - 1;
			G.get(u).add(v);
			if(!isArrow)G.get(v).add(u);
		}
		return G;
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
	
	//拡張ユークリッドの互除法
	//返り値、aとbの最大公約数
	//X[0]とY[0]が、ax+by=gcd(a,b)を満たすようになる
	static long extGCD(long a, long b, long[] X, long[] Y){
		if(b == 0){
			X[0] = 1;
			Y[0] = 0;
			return a;
		}
		long d = extGCD(b, a%b, Y, X);
		Y[0] -= a/b * X[0];
		
		return d;
	}
	
	//Bellman-Ford法
	//辺情報とstartの頂点を指定すると、すべての頂点への最短コストを返す（負の重みの辺もOK）
	//(問題に応じて要変化)1→Vのパスに負の閉路がある場合はindex:Vの要素に-1を入れて返す。
	static long[] bellmanFord(List<E> Edges, int from){
		long[] rtn = new long[V+1];
		Arrays.fill(rtn, INF);
		rtn[from] = 0;
		
		for(int i=0; i<V-1; i++){
			boolean update = false;
			for(E e : Edges){
				if(rtn[e.from] != INF && rtn[e.to] > rtn[e.from] + e.weight){
					rtn[e.to] = rtn[e.from] + e.weight;
					update = true;
				}
			}
			if(!update)break;
		}	
		//閉経路判定
		boolean[] is_update = new boolean[V];
		Arrays.fill(is_update, false);
		for(int i=0; i<V; i++){
			for(E e : Edges){
				if(rtn[e.from] != INF && rtn[e.to] > rtn[e.from] + e.weight){
					rtn[e.to] = rtn[e.from] + e.weight;
					is_update[e.to] = true;
				}
			}
		}
		
		if(is_update[V-1]){
			rtn[V] = -1;
		}
		return rtn;
	}
	
	//Kruskal法
	//最小全域木を構成したときのコストの総和を返す
	static long kruskal(List<E> Edges){
		Collections.sort(Edges);
		UnionFind uni = new UnionFind(V);
		long res = 0L;
		for (E e : Edges){
			if(!uni.same(e.from, e.to)){
				uni.join(e.from, e.to);
				res += e.weight;
			}
		}
		return res;
	}
	
	//Dijkstra法
	//辺情報とstartの頂点を指定すると、すべての頂点への最短コストを返す
	static long[] dijkstra(List<List<E>> G, int from){
		int N = G.size();
		long[] rtn = new long[N];
		Arrays.fill(rtn, INF);
		rtn[from] = 0;
		Queue<V> que = new PriorityQueue<>();
		
		que.add(new V(from,0));
        while(!que.isEmpty()){
            V doneNode = que.poll();
            for(E e: G.get(doneNode.num)){
                  long alt = rtn[doneNode.num] + e.weight;
                  if(rtn[e.to] > alt){
                        rtn[e.to] = alt;
                        que.add(new V(e.to, alt));
                  }     
            }
        }
		return rtn;
	}
	
	//グラフ用：辺
	static class E implements Comparable<E>{
		int from;
		int to;
		long weight;
		public E(int from, int to, long weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(E o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
	}
	//グラフ用：頂点
	static class V implements Comparable<V>{
		int num;
		long cost;
		public V(int num, long cost){
			this.num = num;
			this.cost = cost;
		}
		//コストの低い順に並べる(PriorityQueue用)
		@Override
		public int compareTo(V o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	//Union-Find木
	static class UnionFind{
		private int[] roots;
		public UnionFind(int N){
			this.roots = new int[N];
			for(int i=0; i<N; i++){
				this.roots[i] = i;
			}
		}
		
		public boolean same(int a, int b){
			if(root(a) == root(b)){
				return true;
			}else{
				return false;
			}
		}
		
		public int root(int a){
			if(a == this.roots[a])return a;
			return this.roots[a] = root(this.roots[a]);
		}
		
		public void join(int a, int b){
			if(root(a) == root(b))return;
			this.roots[root(b)] = root(a);
		}
		
		public int[] getRoots(){
			return this.roots;
		}
	}
 


	

	
		
	//GCD最大公約数を返す
	static long gcd(long a, long b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}

	//aとbの最小公倍数を返す
	static long lcm (long a, long b) {
		return ((a/gcd(a,b))*b);
	}
	
	//入力
	//https://qiita.com/p_shiki37/items/a0f6aac33bf60f5f65e4
	static class FastScanner {
	    private final InputStream in = System.in;
	    private final byte[] buffer = new byte[1024];
	    private int ptr = 0;
	    private int buflen = 0;
	    private boolean hasNextByte() {
	        if (ptr < buflen) {
	            return true;
	        }else{
	            ptr = 0;
	            try {
	                buflen = in.read(buffer);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            if (buflen <= 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
	    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
	    public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
	    public String next() {
	        if (!hasNext()) throw new NoSuchElementException();
	        StringBuilder sb = new StringBuilder();
	        int b = readByte();
	        while(isPrintableChar(b)) {
	            sb.appendCodePoint(b);
	            b = readByte();
	        }
	        return sb.toString();
	    }
	    public long nextLong() {
	        if (!hasNext()) throw new NoSuchElementException();
	        long n = 0;
	        boolean minus = false;
	        int b = readByte();
	        if (b == '-') {
	            minus = true;
	            b = readByte();
	        }
	        if (b < '0' || '9' < b) {
	            throw new NumberFormatException();
	        }
	        while(true){
	            if ('0' <= b && b <= '9') {
	                n *= 10;
	                n += b - '0';
	            }else if(b == -1 || !isPrintableChar(b)){
	                return minus ? -n : n;
	            }else{
	                throw new NumberFormatException();
	            }
	            b = readByte();
	        }
	    }
	    public int nextInt() {
	        long nl = nextLong();
	        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
	        return (int) nl;
	    }
	    public double nextDouble() { return Double.parseDouble(next());}
	}
}
