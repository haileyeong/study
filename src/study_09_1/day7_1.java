package study_09_1;

import java.io.*;
import java.util.*;

public class day7_1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. 입력받기
    int n = Integer.parseInt(br.readLine());

    // 2. n명의 몸무게와 키를 저장할 배열
    int[][] input = new int[n][2];

    // 3. 각 몸무게와 키 입력받고 저장
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      input[i][0] = weight;
      input[i][1] = height;
    }

    // 4. 각 덩치 등수를 계산하기 위한 배열
    int[] rankArr = new int[n];

    // 5. 모든 사람을 비교하고 등수 계산
    for (int i = 0; i < n; i++) {
      int rank = 1; // 기본 등수는 1등
      for (int j = 0; j < n; j++) {
        if (i != j) {
          // i번째 사람보다 j번째 사람이 덩치가 크면 i번째 등수 증가
          if (input[i][0] < input[j][0] && input[i][1] < input[j][1]) {
            rank++;
          }
        }
      }
      rankArr[i] = rank;
    }
    for (int i = 0; i < n; i++) {
      System.out.print(rankArr[i] + " ");
    }

    br.close();
  }
}
