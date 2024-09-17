package study_09_2;

import java.io.*;

public class day2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. 숫자 n 입력 받기
    int n = Integer.parseInt(br.readLine());

    // 2. n 길이의 배열 생성 (n번째 수를 구하려면 배열 크기는 n+1이어야 함)
    long[] arr = new long[n + 1];

    // 3. 0과 1을 피보나치 수열 초기값으로 설정
    arr[0] = 0;
    arr[1] = 1;

    // 4. 배열의 가장 이전 두개의 인덱스 값을 계산하여 배열에 저장 n번 반복
    for (int i = 2; i <= n; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }

    // 5. (결과 출력) n번째 피보나치 수 출력
    System.out.println(arr[n]);

    br.close();
  }
}
