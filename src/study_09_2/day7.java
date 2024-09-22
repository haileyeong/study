package study_09_2;

import java.io.*;
import java.util.*;

public class day7 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 게임에 참여하는 사람의 수
    int K = Integer.parseInt(st.nextToken()); // 보성이의 번호

    int[] targets = new int[N]; // 각 사람이 지목하는 사람
    for (int i = 0; i < N; i++) {
      targets[i] = Integer.parseInt(br.readLine());
    }

    // BFS를 위한 큐와 방문 여부를 기록할 배열
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N];

    // 0번부터 시작
    queue.add(0);
    visited[0] = true;
    int count = 0; // 몇 번째 지목인지 세는 변수

    // BFS 탐색
    while (!queue.isEmpty()) {
      int size = queue.size();
      count++; // 지목 횟수 증가
      for (int i = 0; i < size; i++) {
        int current = queue.poll();

        // 현재 사람이 지목하는 사람
        int next = targets[current];

        // 보성이에 도착하면 count를 출력하고 종료
        if (next == K) {
          System.out.println(count);
          return;
        }

        // 아직 방문하지 않은 사람이라면 탐색을 계속한다
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
      }
    }

    // 보성이에게 도달할 수 없으면 -1 출력
    System.out.println(-1);
  }
}
