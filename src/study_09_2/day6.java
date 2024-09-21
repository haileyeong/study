package study_09_2;

import java.io.*;

public class day6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine()); // 순열의 크기 N 입력
      String[] permStr = br.readLine().split(" "); // 순열 입력
      int[] permutation = new int[N + 1]; // 1-based index 사용을 위해 크기를 N+1로 설정

      // 순열 입력 값 처리 (1-based index)
      for (int i = 1; i <= N; i++) {
        permutation[i] = Integer.parseInt(permStr[i - 1]);
      }

      boolean[] visited = new boolean[N + 1]; // 방문 여부 확인 배열
      int cycleCount = 0; // 사이클 개수

      // 모든 정점을 탐색하여 사이클 찾기
      for (int i = 1; i <= N; i++) {
        if (!visited[i]) { // 방문하지 않은 숫자부터 시작
          cycleCount++; // 사이클이 새로 발견되었으므로 증가
          int current = i; // 현재 위치
          // 사이클이 완성될 때까지 계속 이동
          while (!visited[current]) {
            visited[current] = true; // 현재 숫자를 방문 처리
            current = permutation[current]; // 다음 숫자로 이동
          }
        }
      }

      // 결과 출력
      System.out.println(cycleCount);
    }
    br.close();
  }
}
