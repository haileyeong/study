package study_09_1;

import java.util.*;


public class day2_1 {

  public static void main(String[] args) {
    //필요한 것. 스캐너, 입력받을 숫자, 2차원 배열,
    Scanner scan = new Scanner(System.in);

    //1. 회원 수 N을 입력 받는다.
    int num = scan.nextInt();
    scan.nextLine();

    String[][] user = new String[num][2];

    //2. 나이와 이름을 N개 입력 받는다.
    //3. input을 배열에 담는다.
    for (int i = 0; i < num; i++) {
      int age = scan.nextInt();
      String name = scan.nextLine();
      scan.nextLine();
      user[i][0] = Integer.toString(age);
      user[i][1] = name;
    }

    //4. 배열을 조건에 맞게 정렬한다.
    Arrays.sort(user, (a, b) -> Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0])));

    //5. 결과를 출력한다.
    for (String[] result : user) {
      System.out.println(result[0] + " " + result[1]);
    }

    scan.close();
  }
}