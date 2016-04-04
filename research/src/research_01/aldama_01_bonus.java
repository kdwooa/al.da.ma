package research_01;

public class aldama_01_bonus {
	static long [] arr = new long[101];
	public static void main(String[] args) {
		System.out.println(fibonachi(70));
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}
	
	public static long fibonachi(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else if(arr[n] != 0) {
			return arr[n];
		}
		else {
			arr[n] = fibonachi(n-1) + fibonachi(n-2);
			return arr[n];
		}
	}
}
