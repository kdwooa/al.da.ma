package aldama;

import java.util.Scanner;
import java.io.FileInputStream;

public class Aldama_05_jinwoo_2 {
	// x 는 4등분한 것. x 는 한덩이가 되는 4개의 조각?
	// 뒤집을 때엔 x 를 기준으로 1,4분면과 2,3분면이 서로 위치 변경 (x wb bw -> xbwwb )
	// 제일 처음 위치한 x 부터 뒤집어가며 전환작업 xbwxwbbwxwbwxwbwb
	// 문자 5개 = x 1개, 문자 9개 = x 2개, 13개 = x 3개, 17개 = x 4개
	// 즉, 4n+1 로 x의 갯수를 알 수 있음. 이를 이용하여 x 의 count 를 통해,
	// 이를 충족했을 때에는 이 후의 x에 대해 검사를 하지 않아도 됨.
	// x 가 나타나면 그 이후에 4덩이로 나누어, 12번째와, 34번째 덩이를 서로 위치 교대한다.
	static int idx;
	static String comp;
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("aldama_05_input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 읽기
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
