package codingtest;

import java.util.*;

public class RealTest03Box {
    public static int solution(int[] order) {
        int answer = 0;
        int orderLen = order.length;

        Queue<Integer> container = new LinkedList<>();
        Stack<Integer> bojoContainer = new Stack<>();
        List<Integer> truck = new ArrayList<>();

        // 주문표 (Queue 사용)
        for(int i=1; i<=orderLen; i++) {
            container.add(i);
        }

        int orderIdx=0;
        while(true) {
            if (bojoContainer.isEmpty()) {
                if (order[orderIdx] == container.peek()) {
                    truck.add(container.poll());
                    orderIdx++;
                } else if (order[orderIdx] != container.peek()) {
                    bojoContainer.push(container.poll());
                }

                if (orderIdx == orderLen) break;
            } else if (!container.isEmpty() && !bojoContainer.isEmpty()) {
                if (order[orderIdx] == container.peek()) {
                    truck.add(container.poll());
                    orderIdx++;
                } else if (order[orderIdx] == bojoContainer.peek()) {
                    truck.add(bojoContainer.pop());
                    orderIdx++;
                } else if (order[orderIdx] != container.peek()
                        && order[orderIdx] != bojoContainer.peek()) {
                    bojoContainer.push(container.poll());
                }

                if (orderIdx == orderLen) break;
            } else if (container.isEmpty()) {
                if (order[orderIdx] == bojoContainer.peek()) {
                    truck.add(bojoContainer.pop());
                    orderIdx++;
                } else if (order[orderIdx] != bojoContainer.peek()) {
                    break;
                }

                if (orderIdx == orderLen) break;
            } else if (bojoContainer.isEmpty() && container.isEmpty()) {
                break;
            }
        }

        answer = truck.size();

        System.out.println("\nanswer zone");
        return answer;
    }


    public static void main(String[] args) {
        int[] order1 = {4,3,1,2,5};
        int[] order2 = {5,4,3,2,1};

        System.out.println("test1:");
        System.out.println(solution(order1));

        System.out.println("test2:");
        System.out.println(solution(order2));


    }


}
