package research_06;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Aldama_06_jinwoo {

	static int N, KOR = 1, RUS = 0;
	static Integer[][] rating;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("sample/input/aldama_06_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine().trim());
		int cnt, index;
		String[] r, k;
		while(T-- > 0){
			N = Integer.parseInt(sc.nextLine().trim());
			rating = new Integer[2][N];
			r = sc.nextLine().split(" ");
			k = sc.nextLine().split(" ");
			for(int n=0;n<N;n++){
				rating[RUS][n] = Integer.parseInt(r[n]);
				rating[KOR][n] = Integer.parseInt(k[n]);
			}
			
			Arrays.sort(rating[RUS], Collections.reverseOrder());
			Arrays.sort(rating[KOR], Collections.reverseOrder());
			cnt = 0;
			index = 0;
			
			for (int rus : rating[RUS]) {
				if(rus <= rating[KOR][index]){
					index++;
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
