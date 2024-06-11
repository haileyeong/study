package week1;

import java.util.*;

public class Day2 {

  public static void main(String[] args) {
    int bridge_length = 2; // 다리의 길이
    int weight = 10; // 다리가 견딜 수 있는 최대 무게
    int[] truck_weights = {7, 4, 5, 6}; // 트럭들의 무게 배열

    int result = solution(bridge_length, weight, truck_weights);

    System.out.println("얼마나 걸렸냐면: " + result + "초");
  }


  public static int solution(int bridge_length, int weight, int[] truck_weights) {

    Queue<Integer> queue = new LinkedList<>();
    int answer = 0; // 소요시간

    int sum = 0;

    // 트럭이 다 지나갈 때까지..
    for (int truck : truck_weights) {
      while (true) {

        // 다리 위에 아무것도 없을때
        if (queue.isEmpty()) {
          queue.add(truck);
          sum += truck;
          answer++;
          break;
        }

        // 다리가 찼을때
        else if (queue.size() == bridge_length) {
          sum -= queue.poll();
        } else {

          // 다리에 트럭 가능
          if (sum + truck <= weight) {
            queue.add(truck);
            sum += truck;
            answer++;
            break;
          } else {

            //다리에 트럭 무게 초과일때 0을 채움
            queue.add(0);
            answer++;
          }
        }
      }


    }

    //마지막 트럭이 나오는 시간
    answer += bridge_length;

    return answer;
  }

}




