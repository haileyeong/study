package study_09_3;

import java.io.*;
import java.util.*;

public class day3 {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int n = sc.nextInt();

      if (n == 0) {
        break;
      }

      sc.nextLine();

      String[] words = new String[n];

      for (int i = 0; i < n; i++) {
        words[i] = sc.nextLine();
      }

      // 사전순으로 가장 앞서는 단어 찾기
      String result = words[0];
      for (int i = 1; i < n; i++) {
        if (result.compareToIgnoreCase(words[i]) > 0) {
          result = words[i];
        }
      }

      System.out.println(result);
    }

    sc.close();
  }
}