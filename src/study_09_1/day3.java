package study_09_1;

import java.io.*;
import java.util.*;

public class day3 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> words = new HashSet<>();

    //1. 단어의 개수 N 입력 받기
    int n = Integer.parseInt(br.readLine());

    //2. n개만큼 단어 입력받기
    //3. input을 HashSet에 담기
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      words.add(input);
    }

    //4. HashSet을 List로 변환하기
    List<String> wordList = new ArrayList<>(words);

    //5. 조건에 맞게 정렬하기
    wordList.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));

    //6. 결과 출력
    for(String result : wordList) {
      System.out.println(result);
    }

    br.close();
  }
}