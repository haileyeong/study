package study_09_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class day4 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      BigInteger result = BigInteger.ONE; //초기값을 1로 설정

      for(int i = 0; i < n; i++) {
        result = result.multiply(BigInteger.valueOf(m - i));
        result = result.divide(BigInteger.valueOf(i + 1));
      }

      System.out.println(result);
    }

    br.close();
  }

}

