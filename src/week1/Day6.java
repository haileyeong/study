package week1;

import java.util.Scanner;

public class Day6 {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int N = in.nextInt();  // 나무의 수
    int M = in.nextInt();  // 집으로 가져가려고 하는 나무의 길이

    int[] tree = new int[N];  // 나무의 높이

    int min = 0;
    int max = 0;

    for(int i = 0; i < N; i++) {
      tree[i] = in.nextInt();

      // 입력 받은 나무가 max보다 클 경우 max 값을 해당 나무의 높이로 갱신
      if(max < tree[i]) {
        max = tree[i];
      }
    }

    // 이분 탐색
    while(min < max) {

      int mid = (min + max) / 2;
      long sum = 0;
      for(int treeHeight : tree) {

        // tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
        if(treeHeight - mid > 0) {
          sum += (treeHeight - mid);
        }
      }

      if(sum < M) {
        max = mid;
      }
      else {
        min = mid + 1;
      }
    }

    System.out.println(min - 1);

  }
}
