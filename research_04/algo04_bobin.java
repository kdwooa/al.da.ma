package com.aldama;

import java.util.Scanner;

public class Main {
	static int J;
	static int[][] end;
	static int flag;
	static int Bridge;
	static int[][] rock;
	static int tempX;
	static int tempY;
	static int tempJ;
	static int count;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		for (int i = 0; i < TC; i++) {
			flag = 0;
			tempX = 0;
			tempY = 0;
			tempJ = 0;
			count = 0;
			Bridge = 0;
			end = new int[2][2];
			J = scan.nextInt();
			for (int h = 0; h < 2; h++) {
				for (int k = 0; k < 2; k++) {
					end[h][k] = scan.nextInt();
				}
			}
			Bridge = scan.nextInt();
			rock = new int[Bridge][3];
			for (int k = 0; k < Bridge; k++) {
				rock[k][0] = scan.nextInt();
				rock[k][1] = scan.nextInt();
				rock[k][2] = 0;
			}
			
			int x = end[0][0];
			int y = end[0][1];
			search(x, y);
			
			if(flag==0){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
		scan.close();
	}
	
	private static void search(int x, int y){
		for (int j = 0; j < Bridge; j++) {
			if(distance(x, y, end[1][0], end[1][1]) <= J){
				flag = 1;
				break;
			}else if(rock[j][2]==0 && distance(x, y, rock[j][0], rock[j][1]) <= J){
				rock[j][2] = 1; //flag
				search(rock[j][0], rock[j][1]);
			}
		}
		
	}
	
	private static double distance(int x, int y, int x2, int y2) {
		return Math.sqrt(Math.pow(Math.abs(x-x2),2)+Math.pow(Math.abs(y-y2),2));
	}

}