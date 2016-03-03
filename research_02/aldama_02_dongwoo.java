import java.util.Scanner;

public class aldama_02_dongwoo {
	public static int arr[][] = null;
	public static int n = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			n = sc.nextInt();
			makeArray(n, sc);
			search(1);
			System.out.println(arr[n - 1][0]);
		}

	}

	static void makeArray(int n, Scanner sc) {
		arr = new int[n][];
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = new int[n - i];
			for (int j = 0; j < n - i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}

	static void search(int height) {
		int width = n - height;
		for (int i = 0; i < width; i++) {
			if (arr[height - 1][i] > arr[height - 1][i + 1]) {
				arr[height][i] += arr[height - 1][i];
			} else {
				arr[height][i] += arr[height - 1][i + 1];
			}
		}
		if (height == n - 1) {
			return;
		}
		search(height + 1);
	}

}
