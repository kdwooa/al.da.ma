import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class aldama_04_eunyoung {
	
	public static int arr[][] = null;
	public static int cache[][] = null;
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
			// TODO : 현재 RTE(non zero code) 발생중...원인 불명ㅠㅠ
			Queue<Point> queue = new LinkedList<Point>();
			boolean success = search(start, nexts, queue);
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

	private static boolean search(Point start, ArrayList<Point> nexts, Queue<Point> queue) {
		
		// 시작지점에서 이동가능한 지점들을 탐색한다.
		// 만약 jump 가능한 점일 경우 큐에 넣는다.
		for (Point next : nexts) {
			double d = dist(start.x, start.y, next.x, next.y);
			if (d <= j) queue.add(next);
		}
		
		// 만약 큐에 도착지점이 들어왔다면 -> 성공
		if (queue.contains(end)) return true;
		
		// 큐가 비워졌다면(탐색이 끝났다면) -> 실패
		if (queue.isEmpty()) return false;
		
		// 큐에서 다음지점을 빼낸다.
		Point next = queue.remove();
		nexts.remove(next);
		
		// 탐색을 계속한다.
		return search(next, nexts, queue);
		
	}

}