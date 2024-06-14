package week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    Queue<Integer> queue = new LinkedList<Integer>();
    StringBuilder result = new StringBuilder();

    // 1부터 n까지 큐에 넣기.
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    result.append("<");
    // 매 숫자마다.
    for (int i = 0; i < n - 1; i++) {
      // 순서 바꾸기.
      for (int j = 0; j < m - 1; j++) {
        queue.offer(queue.poll());
      }
      result.append(queue.poll() + ", ");
    }

    result.append(queue.poll() + ">");
    System.out.println(result);

    sc.close();
    return;
  }
}
