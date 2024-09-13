package study_09_1;

import java.util.Scanner;

public class day1 {

  public static void main(String[] args) {
    //필요한 것. 스캐너, 배열, 총합을 담을 곳, 선택정렬
    Scanner scan = new Scanner(System.in);
    int[] input = new int[9];
    int sum = 0;

    //1. 9개 숫자를 입력 받는다.
    for (int i = 0; i < 9; i++) {
      input[i] = scan.nextInt();
    }

    //2. 9개 숫자의 총합을 계산한다.
    for (int i : input) {
      sum += i;
    }

    //3. 난쟁이가 아닌 2개의 숫자를 찾아서 제외한다.
    int number = sum - 100;
    int except1 = 0;
    int except2 = 0;

    //3-1. number에 해당되는 2개의 숫자를 찾는다.
    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {
        //배열의 두 수의 합이 number와 같은지 확인
        if (input[i] + input[j] == number) {
          except1 = i;
          except2 = j;
          break;
        }
      }
    }

    //4. 7개의 숫자를 선택 정렬을 사용해 오름차순으로 정렬한다.
    int[] output = new int[7];
    int index = 0;
    for (int i = 0; i < 9; i++) {
      if (i != except1 && i != except2) {
        output[index++] = input[i];
      }
    }

    selectionSort(output);
    //5. 결과를 출력한다.
    for (int result : output) {
      System.out.println(result);
    }

    scan.close();
  }

  static void selectionSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int min = i; // 최솟값

      for (int j = i + 1; j < n; j++ ) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }

      int temp = arr[min];
      arr[min] = arr[i];
      arr[i] = temp;

    }
  }
}
