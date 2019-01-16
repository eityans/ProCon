import java.util.*;
public class Main_ {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// ®”‚Ì“ü—Í
		int N = sc.nextInt();
		ArrayList<Long> input = new ArrayList<Long>();
		
		int answer = 0;
		for(int i=0; i<N; i++){
			input.add(sc.nextLong());	
		}
		ArrayList<ArrayList<Integer>> map = scan(input);
		
		System.out.println(answer);
	}
	
	
	public static ArrayList<Long> renew(ArrayList<Long> input, ArrayList<ArrayList<Integer>> map){
		int lowLine = Integer.MAX_VALUE;
		for(int i=0;i<input.size();i++){
			int lineSum = 0;
			for(int j=0;j<map.get(i).size();j++){
				lineSum += map.get(i).get(j);
			}
			if (lineSum != 0 && lineSum < lowLine)lowLine = lineSum;
		}
		return input;
	}
	
	public static ArrayList<ArrayList<Integer>> scan(ArrayList<Long> input){
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<input.size();i++){
			ArrayList<Integer> line = new ArrayList<Integer>();
			for(int j=0;j<input.size();j++){
				line.add(0);
			}
			map.add(line);
		}
		
		for(int i=0; i<input.size()-1 ; i++){
			for(int j=i+1;j<input.size();j++ ){
				if(check(input.get(i),input.get(j))){
					map.get(i).set(j, map.get(i).get(j)+1);
					map.get(j).set(i, map.get(j).get(i)+1);
					
				}
				System.out.println(check(input.get(i),input.get(j)));
			}
		}
		return map;
		
	}
	
	public static boolean check(long a,long b){
		long sum = a+b;
		if(check2pow(sum)==1){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static long check2pow(long a){
		if(a==1)return 1L;
		if(a%2 == 0){
			return check2pow(a/2);
		}else{
			return a;
		}
	}
}