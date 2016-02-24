package aldama_01_dw;

import java.util.Scanner;

public class Main {
	public static int arr[][] = null;
	public static int sub_arr[][] = null;
	public static int arr_x, arr_y;
	public static int path = 0;
	public static int min = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int x,y;
        while(cases-- > 0) {
        	path = 0;
        	min = -1;
        	x = sc.nextInt();
        	y = sc.nextInt();
        	makeArray(x, y);
        	insertArray(sc);
        	
        	search(0, 0);
            System.out.println(path);
        }

	}
	
	static void makeArray(int x, int y) {
		arr = new int[x][];
		sub_arr = new int[x][];
		for(int i = 0; i < x; i++) {
			arr[i] = new int[y];
			sub_arr[i] = new int[y];
		}
		arr_x = x-1;
		arr_y = y-1;
	}
	
	static void insertArray(Scanner sc) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
				sub_arr[i][j] = 0;
			}
		}
	}
	
	static void search(int x, int y) {
		min++;
		if((x < 0) || (y < 0) || (x > arr_x) || (y > arr_y)) {
			min--;
			return;
		}
		else if(sub_arr[x][y] == -1) {
			min--;
			return;
		}
		else if((x == arr_x) && (y ==  arr_y)) {
			if(min == ((x+1)*(y+1)-1)) {
				path++;
			}
			min--;
			return;
		}
		else if((arr[x][y] != min)&&(arr[x][y] != -1)&&(arr[x][y] != 0)) {
			min--;
			return;
		}
		
		sub_arr[x][y] = -1;
		search(x-1 , y);
		search(x, y+1);
		search(x+1, y);
		search(x, y-1);
		sub_arr[x][y] = 0;
		min--;
	}
}
