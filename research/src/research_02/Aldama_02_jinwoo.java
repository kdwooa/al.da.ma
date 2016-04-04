package research_02;

import java.util.Scanner;

public class Aldama_02_jinwoo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int[] row = {0};
			int temp = 0;
			int max = 0;
			int N = sc.nextInt();
			int[][] floor = new int[N][];
			for (int i = 0; i < N; i++) {
				floor[i] = new int[i+1];
				if(i != 0){
					row = floor[i-1];
				}
				for (int j = 0; j < i+1; j++) {
					if(j == 0){
						temp = row[0];
					}else if(j == i){
						temp = row[i-1];
					}else{
						temp = row[j-1] > row[j] ? row[j-1] : row[j]; 
					}
					floor[i][j] = sc.nextInt() + temp;
				}
			}
			for (int result : floor[N-1]) {
				max = result > max ? result : max;
			}
			System.out.println(max);
		}
		sc.close();		
	}
}
