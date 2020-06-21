import java.util.*;
import input.*;
public class Graph {
  static FastScanner scan = new FastScanner();

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


	
  static long INF = 1_000_000_007;
  //Dijkstra法
	//隣接リストとstartの頂点を指定すると、すべての頂点への最短コストを返す
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
  
	//Bellman-Ford法
	//辺情報とstartの頂点を指定すると、すべての頂点への最短コストを返す（負の重みの辺もOK）
	//(問題に応じて要変化)1→Vのパスに負の閉路がある場合はindex:Vの要素に-1を入れて返す。
	static long[] bellmanFord(List<E> Edges, int V, int from){
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
	static long kruskal(List<E> Edges, int V){
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
  


}