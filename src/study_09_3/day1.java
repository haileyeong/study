package study_09_3;

import java.io.*;
import java.util.*;

public class day1 {

  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] visited;

  // DFS 메소드
  static void dfs(int node) {
    visited[node] = true;  // 현재 노드를 방문 처리
    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor);  // 이웃 노드에 대해 재귀적으로 DFS 수행
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 정점의 수
    int M = Integer.parseInt(st.nextToken()); // 간선의 수

    // 초기화
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    // 간선 입력
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u); // 양방향 연결
    }

    // 방문 여부를 체크하는 배열
    visited = new boolean[N + 1];

    int count = 0; // 연결 요소의 개수

    // 모든 정점에 대해 DFS 실행
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }

    System.out.println(count);
  }
}
