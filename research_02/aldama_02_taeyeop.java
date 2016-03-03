package com.sds;

import java.util.Scanner;

//public class aldama_02_taeyeop {
//	public static int[][] triangleArray = null;
//	public static int N;
//
//	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//
//		int T = sc.nextInt();
//		for (int testcase = 0; testcase < T; testcase++) {
//			N = sc.nextInt();
//			triangleArray = new int[N][];
//			for (int i = 0; i < N; i++) {
//				triangleArray[i] = new int[i + 1];
//				for (int j = 0; j < i + 1; j++) {
//					triangleArray[i][j] = sc.nextInt();
//				}
//			}
//
//			int maximumValue = calculateMaximumSum(0, 0);
//			System.out.println(maximumValue);
//		}
//		sc.close();
//	}
//
//	public static int calculateMaximumSum(int currentX, int currentY) {
//		int currentValue = triangleArray[currentX][currentY];
//
//		if (currentX == N - 1) {
//			return currentValue;
//		} else {
//			int leftSum = calculateMaximumSum(currentX + 1, currentY);
//			int rightSum = calculateMaximumSum(currentX + 1, currentY + 1);
//
//			return (leftSum > rightSum) ? (currentValue + leftSum) : (currentValue + rightSum);
//		}
//	}
//}

public class aldama_02_taeyeop {
	public static int[] frontArray = null;
	public static int[] tempArray = null;
	public static int[] resultArray = null;
	public static int[] frontPascalTriangle = null;
	public static int[] pascalTriangle = null;
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int testcase = 0; testcase < T; testcase++) {
			int maximumSum = 0;
			N = sc.nextInt();

			if (N > 1) {
				frontArray = new int[1];
				frontArray[0] = sc.nextInt();

				for (int i = 0; i < N - 1; i++) {
					if (i == 0) {
						pascalTriangle = new int[2];
						pascalTriangle[0] = 1;
						pascalTriangle[1] = 1;
						frontPascalTriangle = pascalTriangle.clone();
					} else {
						pascalTriangle = new int[i + 2];
						for (int j = 0; j < i + 2; j++) {
							if (j == 0 || j == i + 1) {
								pascalTriangle[j] = 1;
							} else {
								pascalTriangle[j] = frontPascalTriangle[j - 1] + frontPascalTriangle[j];
							}
						}
					}

					tempArray = new int[i + 2];
					for (int k = 0; k < i + 2; k++) {
						tempArray[k] = sc.nextInt();
					}

					int resultCount = (int) Math.pow(2, (i + 1));
					resultArray = new int[resultCount];

					int resultIter = 0;
					for (int x = 0; x < i + 2; x++) {
						int iter = pascalTriangle[x];
						int frontIter = 0;
						if (resultIter != 0 && resultIter != resultCount - 1) {
							for (int q = 0; q < x - 2; q++) {
								frontIter += frontPascalTriangle[q];
							}
						}
						for (int y = 0; y < iter; y++) {
							if (resultIter == 0) {
								resultArray[resultIter] = frontArray[0] + tempArray[0];
							} else if (resultIter == resultCount - 1) {
								resultArray[resultIter] = frontArray[frontArray.length - 1] + tempArray[i + 1];
							} else {
								resultArray[resultIter] = frontArray[frontIter] + tempArray[x];
								frontIter++;
							}
							resultIter++;
						}
					}
					frontArray = resultArray.clone();
					frontPascalTriangle = pascalTriangle.clone();
				}

				maximumSum = resultArray[0];
				for (int i = 1; i < resultArray.length; i++) {
					if (resultArray[i] > maximumSum) {
						maximumSum = resultArray[i];
					}
				}
			} else {
				maximumSum = sc.nextInt();
			}
			System.out.println(maximumSum);
		}
		sc.close();
	}
}
