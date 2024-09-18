package study_09_2;

import java.io.*;

public class day3 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine()); // Test case의 수 입력

    for (int t = 0; t < T; t++) {
      int k = Integer.parseInt(br.readLine()); // 층수 입력
      int n = Integer.parseInt(br.readLine()); // 호수 입력

      // 0층부터 k층까지의 아파트 사람 수를 저장할 배열
      int[][] apt = new int[k + 1][n + 1];

      // 0층의 각 호수에 사는 사람의 수를 설정 (호수 번호와 동일)
      for (int i = 1; i <= n; i++) {
        apt[0][i] = i;
      }

      // 각 층별로 사람 수 계산
      for (int i = 1; i <= k; i++) { // 1층부터 k층까지
        for (int j = 1; j <= n; j++) { // 1호부터 n호까지
          apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
        }
      }

      // k층 n호에 사는 사람 수 출력
      System.out.println(apt[k][n]);
    }
  }
}

