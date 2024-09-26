package study_09_3;

import java.util.*;

public class day4 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 입력 받기
    int n = sc.nextInt(); // 동기의 수
    int m = sc.nextInt(); // 친구 관계의 수

    List<List<Integer>> friends = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      friends.add(new ArrayList<>()); // 친구 관계 리스트 초기화
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      friends.get(a).add(b);
      friends.get(b).add(a); // 무방향 그래프이므로 양방향으로 추가
    }

    // BFS 탐색
    boolean[] visited = new boolean[n + 1]; // 방문 여부 배열
    Queue<Integer> queue = new LinkedList<>();

    queue.add(1); // 상근이의 번호는 1번
    visited[1] = true; // 상근이는 이미 방문

    int inviteCount = 0; // 초대할 사람 수
    int level = 0; // 탐색 깊이를 나타내는 변수

    // BFS 탐색 시작
    while (!queue.isEmpty() && level < 2) { // 두 단계까지만 탐색
      int size = queue.size(); // 현재 레벨의 노드 수
      for (int i = 0; i < size; i++) {
        int current = queue.poll();

        // 현재 친구의 친구들을 확인
        for (int friend : friends.get(current)) {
          if (!visited[friend]) {
            visited[friend] = true;
            queue.add(friend);
            inviteCount++; // 초대할 사람 수 증가
          }
        }
      }
      level++; // 한 단계 탐색이 끝날 때마다 레벨 증가
    }

    // 결과 출력
    System.out.println(inviteCount);
  }
}
