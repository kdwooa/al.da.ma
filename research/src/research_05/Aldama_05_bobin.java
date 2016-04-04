package research_05;

import java.util.Scanner;

public class Aldama_05_bobin {
	static String[] chars;
	static int J;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		for (int i = 0; i < TC; i++) {
			if(scan.hasNext()){
				String nextLine = scan.next();
				chars = nextLine.split("");
				J=-1;
				System.out.println(addArray());
			}
		}
		scan.close();
		
	}


	private static String addArray() {
		J++;
		if(chars[J].equals("x")){
			String str1 = addArray();
			String str2 = addArray();
			String str3 = addArray();
			String str4 = addArray();
			return "x"+str3+str4+str1+str2;
		}
		return chars[J];
	}

}