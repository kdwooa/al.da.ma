package aldama;

import java.util.Scanner;

public class Aldama_01_jinwoo {
	static int T;
	static int N, M;
	static int[][] floor;

	static int run(int x, int y, int order) {
		if (x < 0 || x >= M)
			return 0;
		if (y < 0 || y >= N)
			return 0;

		if (floor[y][x] == -1 || floor[y][x] == order) {
			if (x == M - 1 && y == N - 1)
				return 1;
			int old = floor[y][x];
			floor[y][x] = order;

			int result = 0;

			result = run(x - 1, y, order + 1) + run(x + 1, y, order + 1)
					+ run(x, y - 1, order + 1) + run(x, y + 1, order + 1);

			floor[y][x] = old;
			return result;
		} else
			return 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		while (T != 0) {
			N = sc.nextInt();
			M = sc.nextInt();

			floor = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					floor[i][j] = sc.nextInt();
				}
			}
			System.out.println(run(0, 0, 0));
			T--;
		}
		sc.close();
	}

}
