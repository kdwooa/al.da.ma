package research_05;

import java.util.Scanner;
import java.io.FileInputStream;

public class Aldama_05_jinwoo {
	// x 는 4등분한 것. x 는 한덩이가 되는 4개의 조각?
	// 뒤집을 때엔 x 를 기준으로 1,4분면과 2,3분면이 서로 위치 변경 (x wb bw -> xbwwb )
	// 제일 처음 위치한 x 부터 뒤집어가며 전환작업 xbwxwbbwxwbwxwbwb
	// 문자 5개 = x 1개, 문자 9개 = x 2개, 13개 = x 3개, 17개 = x 4개
	// 즉, 4n+1 로 x의 갯수를 알 수 있음. 이를 이용하여 x 의 count 를 통해,
	// 이를 충족했을 때에는 이 후의 x에 대해 검사를 하지 않아도 됨.
	// x 가 나타나면 그 이후에 4덩이로 나누어, 12번째와, 34번째 덩이를 서로 위치 교대한다.
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("sample/input/aldama_05_input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 읽기
		String comp;
		while (T-- > 0) {
			comp = sc.next();
			System.out.println(revert(comp));
		}
	}

	private static String revert(String comp) {
		int xCnt = (comp.length() - 1) / 4;

		for (int i = 0; xCnt > 0; i++) {
			if (comp.charAt(i) == 'x') {
				comp = change(comp, i);
				xCnt--;
			}
			if (xCnt == 0) {
				break;
			}
		}
		return comp;
	}

	private static String change(String comp, int i) {
		String start = comp.substring(0, i + 1);
		String check = comp.substring(i + 1);
		String[] temp = new String[3];
		int cnt = 0;
		int tempIdx = 0;
		for (int j = 0; j < check.length(); j++) {
			if (check.charAt(j) == 'x') {
				cnt -= 4;
			}
			cnt++;

			if (cnt == 2 && temp[1] == null) {
				temp[1] = check.substring(0, j+1);
				tempIdx = j+1;
			} else if (cnt == 4 && temp[0] == null) {
				temp[0] = check.substring(tempIdx, j+1);
				temp[2] = check.substring(j+1);
				break;
			}

		}
		return start + temp[0] + temp[1] + temp[2];
	}
}
