

import java.util.ArrayList;
import java.util.Scanner;

class answer{
	int max;
	int min;
}
public class maxmin {
	

	public static answer maxmin(int n[],int start,int end) {
		int length = (end - start)+1;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		answer ans = new answer();
		if(length<=2) {
			if(length == 2) {
				if(n[start]<=n[end]) {
					min = n[start];
					max = n[end];
				}else {
					min = n[end];
					max= n[start];
				}
			}else if(length ==1) {
				min=n[start];
			}
			ans.min=min;
			ans.max =max;
			return ans;
		}
		int mid = (start+end)/2;
		answer ans1 = maxmin(n,start,mid);
		answer ans2 = maxmin(n,mid+1,end);
		
		answer mans = new answer();
		if(ans1.min <= ans2.min) {
			mans.min=ans1.min;
		}else {
			mans.min=ans2.min;
		}
		
		if(ans1.max <= ans2.max) {
			mans.max=ans2.max;
		}else {
			mans.max=ans1.max;
		}
		return mans;
	
	}

	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Array Size");
			int size = s.nextInt();
			int arr[]= new int[size];
			for(int i=0;i<size;i++) {
				arr[i] = s.nextInt();
			}
			answer ans = maxmin(arr,0,arr.length-1);
			System.out.println("Max Element: "+ ans.max);
			System.out.println("Min Element: " +ans.min);
			
	}

}
