package study_09_3;

import java.util.Scanner;

public class day5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 사람의 수
    int[][] cards = new int[N][5]; // 각 사람의 5장의 카드 저장

    // 카드 입력 받기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 5; j++) {
        cards[i][j] = sc.nextInt();
      }
    }

    int winner = 0; // 이긴 사람의 번호 (0부터 시작)
    int maxResult = -1; // 가장 큰 일의 자리 수

    // 각 사람에 대해서 처리
    for (int i = 0; i < N; i++) {
      int bestMod = -1; // 현재 사람의 가장 큰 일의 자리 수

      // 3장의 카드를 선택하는 모든 경우의 수를 체크
      for (int a = 0; a < 5; a++) {
        for (int b = a + 1; b < 5; b++) {
          for (int c = b + 1; c < 5; c++) {
            int sum = cards[i][a] + cards[i][b] + cards[i][c];
            int mod = sum % 10; // 일의 자리 수 계산

            // 가장 큰 일의 자리 수를 찾음
            if (mod > bestMod) {
              bestMod = mod;
            }
          }
        }
      }

      // 현재 사람의 bestMod가 지금까지의 maxResult보다 크면 갱신
      // 만약 동일한 일의 자리 수라면 번호가 더 큰 사람으로 갱신
      if (bestMod > maxResult || (bestMod == maxResult && i + 1 > winner)) {
        maxResult = bestMod;
        winner = i + 1; // 0 기반이므로 +1 해서 실제 사람 번호로 저장
      }
    }

    System.out.println(winner); // 최종 이긴 사람 출력
  }
}
