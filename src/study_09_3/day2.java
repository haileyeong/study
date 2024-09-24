package study_09_3;

import java.io.*;
import java.util.*;

public class day2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. 입력 처리
    int n = Integer.parseInt(br.readLine()); // 전체 사람 수
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken()); // 촌수를 계산할 첫 번째 사람
    int b = Integer.parseInt(st.nextToken()); // 촌수를 계산할 두 번째 사람
    int m = Integer.parseInt(br.readLine()); // 부모 자식 간의 관계 수

    // 2. 그래프 초기화 (인접 리스트)
    ArrayList<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    // 3. 부모-자식 관계 입력받아 양방향 연결
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      graph[parent].add(child);
      graph[child].add(parent);
    }

    // 4. BFS를 이용하여 촌수 계산
    int result = bfs(graph, a, b, n);

    // 5. 결과 출력
    System.out.println(result);
  }

  // BFS 함수
  private static int bfs(ArrayList<Integer>[] graph, int start, int target, int n) {
    boolean[] visited = new boolean[n + 1]; // 방문 여부를 기록
    int[] distance = new int[n + 1]; // 각 사람까지의 거리를 기록

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll();

      // 만약 목표 지점에 도달하면 그때의 거리를 반환
      if (current == target) {
        return distance[current];
      }

      // 현재 정점에서 연결된 모든 사람들 탐색
      for (int neighbor : graph[current]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          distance[neighbor] = distance[current] + 1; // 거리를 하나씩 증가
          queue.offer(neighbor);
        }
      }
    }

    // 목표 지점에 도달할 수 없으면 -1을 반환
    return -1;
  }
}
