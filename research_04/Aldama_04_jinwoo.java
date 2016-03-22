import java.util.ArrayList;
import java.util.Scanner;


public class Aldama_04_jinwoo {
	static int T, J, endX, endY;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int startX, startY, stoneCount,x, y;
		T = sc.nextInt();
		while(T-- > 0){
			J = sc.nextInt();
			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();
			stoneCount = sc.nextInt();
			ArrayList<Stone> map = new ArrayList<Stone>();
			for(int i=0;i<stoneCount;i++){
				map.add(new Stone(sc.nextInt(), sc.nextInt()));
			}
			map.add(new Stone(endX, endY));
			
			System.out.println(canDuckGoOver(startX, startY, map)?"YES":"NO");
		}
	}
	
	private static boolean canDuckGoOver(int x, int y, ArrayList map) {
		boolean result = false;
		if(x == endX && y == endY){
			return true;
		}else{
			ArrayList temp = (ArrayList) map.clone();
			for (Object obj : temp) {
				Stone s = (Stone)obj;
				if(Math.pow(s.x-x, 2)+Math.pow(s.y-y, 2) <= Math.pow(J, 2)){
					map.remove(s);
					result |= canDuckGoOver(s.x, s.y, map);
				}
			}
			return result;
		}
	}

	static class Stone{
		int x, y;
		public Stone(){}
		public Stone(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
