package study_09_2;

import java.io.*;

public class day5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1보다 크거나 같고, 1,000,000보다 작거나 같은 정수 n을 입력 받는다.
    int n = Integer.parseInt(br.readLine());

    // 분기처리. n이 3으로 나누어 떨어지면, 3으로 나누고 2로 나누어 떨어지면, 2로 나눈다.

    int[] result = new int[n + 1];

    result[0] = result[1] = 0; //1을 1로 만드는데 사용한 연산 횟수는 기본 0

    for (int i = 2; i <= n; i++) {
      result[i] = result[i - 1] + 1;
      if (i % 3 == 0) {
        result[i] = Math.min(result[i], result[ i / 3] + 1);
      }
      if ( i % 2 == 0) {
        result[i] = Math.min(result[i], result[ i / 2] + 1);
      }
    }

    System.out.println(result[n]);

    br.close();
  }

}

