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
	 * ������ ��ǥ ������ �־����� ��, ���� ���ι� ���� ���θ� �Ǵ��Ѵ�.
	 * +) ���� ���θ� ĳ�ÿ� ����Ѵ�.
	 * 
	 *  1) ������ ������ �Ѿ ��� -> ����
	 *  2) ������ ������ ��� -> ����
	 *  3) ������ �ȿ� ���� ��� -> ��ǥ�� �Էµ� ���ڸ�ŭ ������ �Ǵ� �Ʒ��� �̵��Ѵ�
	 *  
	 * @param x x��ǥ
	 * @param y y��ǥ
	 * @return boolean ��������
	 */
	static int search(int x, int y) {
		
		// 0) �̹� ������ ��ǥ�� ��� ĳ�õ� ������ �����Ѵ�
		if (cache[x][y] != -1) return cache[x][y];
		
		// 1) ������ ������ �Ѿ ���
		if (x >= n || y >= n) {
			return cache[x][y] = 0;
		}
		
		// 2) ������ ������ ���
		if (x == n-1 && y == n-1) {
			return cache[x][y] = 1;
		}
		
		// 3) ���� ������ �ȿ� ���� ���
		int jump = arr[x][y];
		return cache[x][y] = (search(x + jump, y) | search(x, y + jump));
		
	}

}