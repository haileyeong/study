package week1;

import java.util.Stack;

public class Day7 {
/*
  push X: 정수 X를 스택에 넣는 연산이다.
  pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  size: 스택에 들어있는 정수의 개수를 출력한다.
  empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
  top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

  public static void main(String[] args) {

    // 스택 생성
    Stack<Integer> stack = new Stack<>();

    // 스택에 요소 추가 push
    stack.push(1);
    stack.push(2);
    stack.push(3);

    // top 스택의 가장 위에 있는 정수 출력
    System.out.println("1, 2, 3 중 가장 위에 있는 정수는 ? : " + stack.peek());

    // size 스택에 몇개가 들어있는지 출력
    System.out.println("스택에 몇개 ? : " + stack.size());

    // pop 가장 위에 있는 정수를 제거
    System.out.println("제거된 정수는 ? : " + stack.pop());

    // 다시 확인
    System.out.println("스택에 몇개 ? : " + stack.size());

    // 스택 전체 출력
    System.out.println("스택 전체 출력 : " + stack);



  }


}
