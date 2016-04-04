package research_03;

import java.io.File;
import java.util.Scanner;

public class Aldama_03_jinwoo {
	static int T;
	static int N;
	static int[][] table; 
	static boolean[][] check;
	public static void main(String[] args) throws Exception {

//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/sampleInput/aldama_03_input.txt"));
		T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();
			table = new int[N][N];
			check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			System.out.println(goal(0,0)?"YES":"NO");
		}
		sc.close();		
	}

	static boolean goal(int y, int x){
		boolean result = false;
		if(check[y][x]){
			return false;
		}else if(table[y][x] == 0){
			return true;
		}else{
			int temp = table[y][x];
			check[y][x] = true;
			result = y+temp < N ? result||goal(y+temp, x) : result;
			result = x+temp < N ? result||goal(y, x+temp) : result;
			return result;
		}
	}
}
