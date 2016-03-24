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
			
			// ������, ����, ������ ��ǥ�� �Է¹޴´�.
			start = new Point(sc.nextInt(), sc.nextInt());
			end = new Point(sc.nextInt(), sc.nextInt());
			ArrayList<Point> nexts = makeArr(sc);
			nexts.add(end);
			
			// ���̿켱 Ž�� ������� ���� ���Ѵ�.
			boolean success = false;
			
			// 0. ť�� ���������� �ִ´�. (���)
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(start);
			
			// 1. ť�� ���� �������� ������ Ž���� ����Ѵ�.
			while (!queue.isEmpty()) {
				
				// 2. ť���� ���� �ϳ��� ���� Ž���Ѵ�.
				Point now = queue.remove();
				nexts.remove(now);
				
				// 3. ���� ���� ���� �� �����ؼ� �ǳʰ��� �ִ� ���� ������ ť�� �ִ´�.
				for (Point next : nexts) {
					double d = dist(now.x, now.y, next.x, next.y);
					if (d <= j) {
						queue.add(next);
					}
				}
				
				// 4. ���� ���������� ť�� �ִٸ� �׸��д�. (����)
				if (queue.contains(end)) {
					success = true;
					break;
				}
			}
			
			// ���
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