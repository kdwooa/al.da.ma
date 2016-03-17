import java.util.Scanner;

public class aldama_03_eunyoung {
	
	public static int arr[][] = null;
	public static int cache[][] = null;
	public static int n = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			n = sc.nextInt();
			makeArray(n, sc);
			makeCache(n);
			
			int success = search(0, 0);
			switch (success) {
			case 1:
				System.out.println("YES");
				break;
			case 0:
				System.out.println("NO");
				break;
			default:
				System.out.println("ERROR");
				break;
			}
		}

	}
	
	private static void makeCache(int n) {
		cache = new int[n+9][n+9];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cache[j][i] = -1;
			}
		}
	}

	static void makeArray(int n, Scanner sc) {
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[j][i] = sc.nextInt();
			}
		}
	}

	/**
	 * 현재의 좌표 정보가 주어졌을 때, 성공 여부및 수행 여부를 판단한다.
	 * +) 성공 여부를 캐시에 기록한다.
	 * 
	 *  1) 게임판 밖으로 넘어간 경우 -> 실패
	 *  2) 끝점에 도달한 경우 -> 성공
	 *  3) 게임판 안에 있을 경우 -> 좌표에 입력된 숫자만큼 오른쪽 또는 아래로 이동한다
	 *  
	 * @param x x좌표
	 * @param y y좌표
	 * @return boolean 성공여부
	 */
	static int search(int x, int y) {
		
		// 0) 이미 지나간 좌표일 경우 캐시된 정보를 리턴한다
		if (cache[x][y] != -1) return cache[x][y];
		
		// 1) 게임판 밖으로 넘어갈 경우
		if (x >= n || y >= n) {
			return cache[x][y] = 0;
		}
		
		// 2) 끝점에 도달한 경우
		if (x == n-1 && y == n-1) {
			return cache[x][y] = 1;
		}
		
		// 3) 아직 게임판 안에 있을 경우
		int jump = arr[x][y];
		return cache[x][y] = (search(x + jump, y) | search(x, y + jump));
		
	}

}