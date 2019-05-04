
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


public class CopyOfSolution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());

		for(int i=0; i<T; i++){
			BigInteger N = new BigInteger(sc.next());
			int L = Integer.parseInt(sc.next());
			BigInteger[] P = new BigInteger[L];
			for(int j=0; j<L; j++){
				P[j] = new BigInteger(sc.next());
			}
			
			TreeSet<BigInteger> primes = new TreeSet<>();
			
			for(int k=0; k<L-1;k++){
				if(P[k].equals(P[k+1]))continue;
				BigInteger tmp = Euclid(P[k], P[k+1]);
				if(tmp.equals(P[k]))continue;
				primes.add(tmp);
				if(k==0){
					primes.add(P[0].divide(tmp));
				}
				if(k==L-2){
					primes.add(P[L-1].divide(tmp));
				}
			}
			
			ArrayList<BigInteger> al_primes = new ArrayList<>(primes);
			
			StringBuilder str = new StringBuilder();
			BigInteger last_2 = null;
			BigInteger last_1 = null;
			
			for(int j=0; j<L-1; j++){
				BigInteger tmp_1;
				
				int offset = 99;
				int tmp_offset = 99;
				for(int k=0;k<26;k++){
					if(P[j].remainder(al_primes.get(k)).equals(BigInteger.ZERO)){
						tmp_1 = al_primes.get(k);
						tmp_offset = k;
						if(P[j+1].remainder(tmp_1).equals(BigInteger.ZERO)){
							if(j==L-2){
								last_2 = tmp_1;
								last_1 = P[L-1].divide(last_2);
							}
							continue;
						}
						offset = k;
					}
				}
				if(offset == 99)offset = tmp_offset;
				char base = 'A';
				str.append((char)(base+offset));
			}
			for(int k=0;k<26;k++){
				if(last_2.equals(al_primes.get(k))){
					char base = 'A';
					str.append((char)(base+k));
				}
			}
			for(int k=0;k<26;k++){
				if(last_1.equals(al_primes.get(k))){
					char base = 'A';
					str.append((char)(base+k));
				}
			}
			

			System.out.println("Case #"+(i+1)+": "+str);
		}
		
		sc.close();
	}
	
	public static BigInteger Euclid(BigInteger a, BigInteger b){
		BigInteger bigger = a.max(b);
		BigInteger smaller = a.min(b);
		
		BigInteger surplus = bigger.remainder(smaller);
		
		if(surplus.equals(BigInteger.ZERO)){
			return smaller;
		}else{
			return Euclid(smaller, surplus);
		}
		
		
	}
	
	
}
