package study_09_1;

import java.io.*;
import java.util.*;

public class day6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //1. 응시자 수 n, 수상자 k를 입력 받는다.
    String[] input = br.readLine().split(" ");

    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    //2. 응시자들의 점수를 입력받는다.
    Integer[] score = new Integer[n];
    String[] inputScore = br.readLine().split(" ");

    for(int i = 0; i < n; i++) {
      score[i] = Integer.parseInt(inputScore[i]);
    }

    //3. 내림차순 정렬
    Arrays.sort(score, Collections.reverseOrder());

    //4. 커트라인 찾기
    int cutLine = score[k - 1];

    //5. 결과 출력
    System.out.println(cutLine);

    br.close();
  }
}