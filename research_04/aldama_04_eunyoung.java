import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class aldama_04_eunyoung {
	
	public static int j = 0;
	public static Point start;
	public static Point end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			j = sc.nextInt();
			
			// 시작점, 끝점, 돌들의 좌표를 입력받는다.
			start = new Point(sc.nextInt(), sc.nextInt());
			end = new Point(sc.nextInt(), sc.nextInt());
			ArrayList<Point> nexts = makeArr(sc);
			nexts.add(end);
			
			// 넓이우선 탐색 방식으로 답을 구한다.
			boolean success = false;
			
			// 0. 큐에 시작지점을 넣는다. (출발)
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(start);
			
			// 1. 큐에 돌이 남아있을 때까지 탐색을 계속한다.
			while (!queue.isEmpty()) {
				
				// 2. 큐에서 돌을 하나씩 빼서 탐색한다.
				Point now = queue.remove();
				nexts.remove(now);
				
				// 3. 만약 다음 돌들 중 점프해서 건너갈수 있는 돌이 있으면 큐에 넣는다.
				for (Point next : nexts) {
					double d = dist(now.x, now.y, next.x, next.y);
					if (d <= j) {
						queue.add(next);
					}
				}
				
				// 4. 만약 도착지점이 큐에 있다면 그만둔다. (도착)
				if (queue.contains(end)) {
					success = true;
					break;
				}
			}
			
			// 출력
			if (success) System.out.println("YES");
			else		 System.out.println("NO");
		
		}
		sc.close();

	}
	
	private static ArrayList<Point> makeArr(Scanner sc) {
		int n = sc.nextInt();
		ArrayList<Point> stones = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
			stones.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		return stones;
	}
	
	private static double dist(int x1, int y1, int x2, int y2) {
		return Point.distance(x1, y1, x2, y2);
	}

}