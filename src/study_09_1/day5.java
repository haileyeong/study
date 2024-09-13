package study_09_1;

import java.io.*;
import java.util.*;

public class day5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //1. 반에 있는 학생의 수 n 입력받기
    int n = Integer.parseInt(br.readLine());

    String[][] students = new String[n][4];

    //2. n줄 만큼 각 학생의 이름과 생일을 형식에 맞게 입력받기
    //3. [n] [4] 2차원 배열에 담기
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      students[i][0] = input[0];  //이름
      students[i][1] = input[1];  //일
      students[i][2] = input[2];  //월
      students[i][3] = input[3];  //연도
    }

    // 4. Comparator를 사용하여 생일을 기준으로 정렬하기
    Arrays.sort(students, new Comparator<String[]>() {
      @Override
      public int compare(String[] student1, String[] student2) {
        // 연도 비교
        int year1 = Integer.parseInt(student1[3]);
        int year2 = Integer.parseInt(student2[3]);
        if (year1 != year2) {
          return year1 - year2; // 연도가 적은 것이 먼저 오도록
        }

        // 월 비교
        int month1 = Integer.parseInt(student1[2]);
        int month2 = Integer.parseInt(student2[2]);
        if (month1 != month2) {
          return month1 - month2; // 월이 적은 것이 먼저 오도록
        }

        // 일 비교
        int day1 = Integer.parseInt(student1[1]);
        int day2 = Integer.parseInt(student2[1]);
        return day1 - day2; // 일이 적은 것이 먼저 오도록
      }
    });

    // 5. 정렬된 결과에서 가장 나이가 적은 사람과 많은 사람을 찾기
    String youngestStudent = students[n - 1][0]; // 가장 나이가 적은 사람 (정렬된 마지막 요소)
    String oldestStudent = students[0][0];      // 가장 나이가 많은 사람 (정렬된 첫 번째 요소)

    // 6. 결과 출력
    System.out.println(youngestStudent); // 가장 나이가 적은 사람
    System.out.println(oldestStudent);   // 가장 나이가 많은 사람

    br.close();
  }
}