package study_09_1;

import java.io.*;
import java.util.*;

public class day6_1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //1. 응시자 수 n, 수상자 k를 입력 받는다.
    String[] input = br.readLine().split(" ");

    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    //2. 응시자들의 점수를 입력받는다.
    String[] inputScore = br.readLine().split(" ");
    int score;

    //3. 우선순위 큐를 사용하여 k개의 최대 점수를 유지한다.
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i < n; i++) {
      score = Integer.parseInt(inputScore[i]);
      if (pq.size() < k) {
        pq.add(score);
      } else if (pq.peek() < score){
        pq.poll();
        pq.add(score);
      }
    }

    //3. 커트라인 찾기
    int cutLine = pq.peek();

    //5. 결과 출력
    System.out.println(cutLine);

    br.close();
  }
}