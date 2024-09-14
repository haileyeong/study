package study_09_1;

import java.io.*;
import java.util.*;

public class day7 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. 입력받기
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] input = new int[5];  // 나무 조각 배열

    for (int i = 0; i < 5; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    // 2. 버블 정렬 방식으로 숫자 정렬 및 출력
    boolean sorted = false; // 정렬 여부를 체크하는 변수

    while (!sorted) { // 배열이 정렬될 때까지 반복
      sorted = true; // 루프가 시작할 때 배열이 정렬되었다고 가정

      for (int i = 0; i < 4; i++) { // 4번까지 비교, 5번째는 없으므로
        if (input[i] > input[i + 1]) {
          // 인접한 두 수가 크기 순이 아니라면 교환
          int temp = input[i];
          input[i] = input[i + 1];
          input[i + 1] = temp;

          // 교환 후 배열 출력
          for (int j = 0; j < input.length; j++) {
            System.out.print(input[j] + " ");
          }
          System.out.println(); // 배열 출력 후 줄바꿈

          sorted = false; // 교환이 발생했으므로 아직 정렬되지 않음
        }
      }
    }

    br.close();
  }
}