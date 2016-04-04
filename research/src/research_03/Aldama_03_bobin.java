package research_03;
import java.util.Scanner;

public class Aldama_03_bobin {
 static int N;
 static int[][] array;
 static int[][] temp;
 static int flag;
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int testcase = scan.nextInt();
  for (int i = 0; i < testcase; i++) {
   flag = 0;
   N = scan.nextInt();
   array = new int[N][N];
   temp = new int[N][N];
   for (int j = 0; j < N; j++) {
    for (int k = 0; k < N; k++) {
     array[j][k] = scan.nextInt();
     temp[j][k] = 0;
    }
   }
   
   int J = 0;
   int K = 0;
   search(J, K);
   if(flag==1){
    System.out.println("YES");
   }else{
    System.out.println("NO");
   }
  }
 
 }

 private static void search(int j, int k) {
  if(j==N-1 && k==N-1){
   flag = 1;
   return;
  }else{
   if(flag==1){
    return;
   }else if(k>=N || j>=N){
    return;
   }else if(array[j][k] >= N-k && array[j][k] >= N-j){
    return;
   }else if(temp[j][k]==1){
    return;
   }
   temp[j][k] = 1;
   search(j, k+(array[j][k]));
   search(j+(array[j][k]), k);
  }
    
 }
}
