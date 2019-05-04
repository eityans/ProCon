

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class CopyOfMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] A = new int[N];
		
		for(int i=0;i<N;i++){
			A[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(A);
		
		int min_A=A[0];	//A‚Ì’†‚Åˆê”Ô¬‚³‚¢’l
		
		//min_A‚Ü‚Å‚Ì‘f”‚ð‹‚ß‚é
		List<Integer> searchList = new ArrayList<>();
		List<Integer> primeList = new ArrayList<>();
		int prime=2;
		while(prime*prime<=min_A){
			searchList.add(prime);
			prime++;
		}
		
		int head=0;
		int nowHead ;
		while(head*head<=min_A){
			head = searchList.get(0);
			nowHead = head;
			primeList.add(nowHead);
			for(Iterator<Integer> it = searchList.iterator(); it.hasNext();){
				int num = it.next();
				if(num%nowHead == 0){
					it.remove();
				}
			}	
		}
		for(Iterator<Integer> it = searchList.iterator(); it.hasNext();){
			primeList.add(it.next());
		}
		
		
		
		int ans = 1;
		
		for(Iterator<Integer> it = primeList.iterator(); it.hasNext();){
			int num = it.next();
			boolean flag=false;
			boolean flag_ans=true;
			for(int i=0; i<N-1;i++){
				if(A[i]%num != 0){
					if(flag){
						flag_ans = false;
						continue;
					}
					flag = true;
				}
			}
			if(flag_ans)ans = num;
		}



		System.out.println(ans);
		
		
		sc.close();
	}
	
}
