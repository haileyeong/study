package study_09_1;

import java.util.*;

public class day2 {

  public static void main(String[] args) {
    //필요한 것. 스캐너, 입력받을 숫자, 리스트
    Scanner scan = new Scanner(System.in);
    List<Map.Entry<Integer, String>> user = new ArrayList<>();

    //1. 회원 수 N을 입력 받는다.
    int num = scan.nextInt();
    scan.nextLine();

    //2. 나이와 이름을 N개 입력 받는다.
    //3. input을 list에 담는다.
    for (int i = 0; i < num; i++) {
      int age = scan.nextInt();
      String name = scan.nextLine();
      user.add(new AbstractMap.SimpleEntry<>(age, name));
    }

    //4. list를 나이를 기준으로 정렬한다.
    //5. 같은 나이가 있는지 확인하고, 같은 나이가 있다면 배열 인덱스의 오름차순으로 정렬한다.
    user.sort((entry, entry2) -> Integer.compare(entry.getKey(), entry2.getKey()));

    //6. 결과를 출력한다.
    for (Map.Entry<Integer, String> result : user) {
      System.out.println(result.getKey() + result.getValue());
    }

    scan.close();
  }
}
