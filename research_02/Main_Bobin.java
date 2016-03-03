package com.sds;

import java.util.Scanner;


public class Main_Bobin{
	   public static void main(String args[]){
		   Scanner sc = new Scanner(System.in);
		   int C = sc.nextInt();
		   int MAX = 0;
		   
		   for(int t=0; t<C; t++) {
			   MAX = 0;
			   int N = sc.nextInt();
			   int path[] = new int[N];
			   int temp[] = new int[N];
			   
			   for(int i=0; i<N; i++) {
				   for(int j=0; j<i+1; j++) {
					   if(j==0) {
						   temp[0] = path[0] + sc.nextInt();
					   }
					   else {
						   if(path[j-1] > path[j]) {
							   temp[j] = path[j-1] + sc.nextInt();
						   }
						   else {
							   temp[j] = path[j] + sc.nextInt();
						   }
					   }
				   }
				   path = temp;
				   temp = new int[N];
			   }
			   
			   for(int i=0; i<N; i++) {
				   if(MAX < path[i]) {
					   MAX = path[i];
				   }
			   }
			   
			   System.out.println(MAX);
		   }
	   }
}
