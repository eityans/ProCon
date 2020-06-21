public class UnionFind {
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