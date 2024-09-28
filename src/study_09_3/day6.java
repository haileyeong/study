package study_09_3;

import java.util.Scanner;

public class day6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 입력받은 N
    long[] dp = new long[N + 1]; // dp 배열 생성 (long 타입 사용)

    // 초기 조건 설정
    dp[1] = 1; // 1자리 이친수: '1'
    if (N > 1) {
      dp[2] = 1; // 2자리 이친수: '10'
    }

    // dp 배열 계산
    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2]; // 점화식
    }

    // 결과 출력
    System.out.println(dp[N]);
  }
}