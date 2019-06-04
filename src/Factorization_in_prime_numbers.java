import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Factorization_in_prime_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//‘fˆö”•ª‰ğ(int‚Ì”ÍˆÍ)
		
		Scanner sc = new Scanner(System.in);
		int M = Integer.parseInt(sc.next());
		List<int[]> primes = new ArrayList<>();

		int now_prime = 2;
		int now_M = M;
		while(now_prime*now_prime<=M){
			if(now_M%now_prime == 0){
				now_M /= now_prime;
				int[] prime = new int[2];
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
			int[] prime = new int[2];
			prime[0] = now_M;
			prime[1] = 1;
			primes.add(prime);
		}
		
		for(int[] prime : primes){
			System.out.println(prime[0]+" "+prime[1]);
		}
	}

}
