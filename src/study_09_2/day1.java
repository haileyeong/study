package study_09_2;

import java.io.*;
import java.util.*;

public class day1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. 빙고판 입력 받기
    int[][] bingoBoard = new int[5][5]; // 빙고판
    boolean[][] marked = new boolean[5][5]; // 숫자를 지웠는지 여부

    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        bingoBoard[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 2. 사회자가 부르는 수 입력 받기
    List<Integer> callNum = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens()) {
        callNum.add(Integer.parseInt(st.nextToken()));
      }
    }

    // 3. 사회자가 부르는 수를 하나씩 처리
    for (int turn = 0; turn < callNum.size(); turn++) {
      int number = callNum.get(turn);

      // 3-1. 부른 숫자를 빙고판에서 찾아서 지운다
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (bingoBoard[i][j] == number) {
            marked[i][j] = true;
          }
        }
      }

      // 3-2. 빙고 줄 체크
      int bingoCount = 0;

      // 가로 체크
      for (int i = 0; i < 5; i++) {
        boolean isBingo = true;
        for (int j = 0; j < 5; j++) {
          if (!marked[i][j]) {
            isBingo = false;
            break;
          }
        }
        if (isBingo) bingoCount++;
      }

      // 세로 체크
      for (int j = 0; j < 5; j++) {
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
          if (!marked[i][j]) {
            isBingo = false;
            break;
          }
        }
        if (isBingo) bingoCount++;
      }

      // 대각선 체크 (왼쪽 위 -> 오른쪽 아래)
      boolean isBingo = true;
      for (int i = 0; i < 5; i++) {
        if (!marked[i][i]) {
          isBingo = false;
          break;
        }
      }
      if (isBingo) bingoCount++;

      // 대각선 체크 (오른쪽 위 -> 왼쪽 아래)
      isBingo = true;
      for (int i = 0; i < 5; i++) {
        if (!marked[i][4 - i]) {
          isBingo = false;
          break;
        }
      }
      if (isBingo) bingoCount++;

      // 3-3. 빙고 줄이 3개 이상이면 결과 출력
      if (bingoCount >= 3) {
        System.out.println(turn + 1); // 몇 번째 수를 부른 후인지 출력
        break;
      }
    }

    br.close();
  }
}
