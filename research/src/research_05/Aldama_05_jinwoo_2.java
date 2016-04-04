package research_05;

import java.util.Scanner;
import java.io.FileInputStream;

public class Aldama_05_jinwoo_2 {
	static int idx;
	static String comp;
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("sample/input/aldama_05_input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			idx = -1;
			comp = sc.next();
			System.out.println(revert());
		}
	}

	private static String revert() {
		idx++;
		char a = comp.charAt(idx);
		if (a == 'x') {
			String a1 = revert();
			String a2 = revert();
			String a3 = revert();
			String a4 = revert();
			return 'x' + a3 + a4 + a1 + a2;
		}
		return String.valueOf(a);
	}
}
