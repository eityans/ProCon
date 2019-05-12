

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Copy_2_of_Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		boolean flag = true;
		int ans = 0;
		int count_XXA=0;
		int count_BXX=0;
		//String[] s = new String[N];
		for(int i=0; i<N; i++){
			//s[i] = sc.next();
			String str = sc.next();
			ans += count_AB(str);
			if(is_XXA(str))count_XXA++;
			if(is_BXX(str))count_BXX++;
			if(is_XXA(str)||is_BXX(str))flag = flag && is_BXXA(str);
		}
		
		ans += Math.min(count_XXA, count_BXX);
		if(flag)ans--;

		System.out.println(ans);
		
		
		sc.close();
	}
	
	public static int count_AB(String str){
		int count=0;
		char[] c = str.toCharArray();
		int len=c.length;
		for(int i=0; i<len-1;i++){
			if(c[i]=='A' && c[i+1]=='B')count++;
		}
		return count;
	}
	
	public static boolean is_BXXA(String str){
		char[] c = str.toCharArray();
		int len=c.length;
		return c[0]=='B' && c[len-1]=='A';
	}
	
	public static boolean is_BXX(String str){
		char[] c = str.toCharArray();
		return c[0]=='B';
	}
	
	public static boolean is_XXA(String str){
		char[] c = str.toCharArray();
		int len=c.length;
		return c[len-1]=='A';
	}
	
}
