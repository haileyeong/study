package week1;

import java.util.Arrays;

public class Day3 {

  public static void main(String[] args) {
    int n = 6; // 입국 심사를 기다리는 사람이 6명
    int[] times = {7, 10}; // 심사관 당 한 명을 심사하는데 걸리는 시간이 각 7분, 10분

    Long result = solution(n, times);

    System.out.println("입국심사 총 소요시간은 : " + result + "분");
  }


  public static long solution(int n, int[] times) {

    long answer = 0;
    Arrays.sort(times); // 이진탐색을 위해서는 정렬이 되어있어야함.
    long left = 0; // 이진탐색의 시작 범위
    long right = times[times.length - 1] * (long) n; // 이진탐색의 끝 범위. 시간 배열의 최댓값에 입국 심사를 기다리는 사람의 수를 곱함.

    while (left <= right) { // 이진 탐색을 수행하는 반복문.
      long mid = (left + right) / 2; // 이진 탐색의 중간 값
      long complete = 0; // 입국 심사 대기자 수의 총합을 저장함

      for (int i = 0; i < times.length; i++) { // 각 심사관의 심사 시간을 반복하여 확인
        complete += mid / times[i];
      }

      if (complete < n) { // 현재시간으로 모든 심사가 완료되지 않았을 경우.
        left = mid + 1;
      } else { // 현재 시간으로 모든 심사가 완료되었을 경우..
        right = mid - 1;
        answer = mid;
      }

    }
    return answer;

  }
}

