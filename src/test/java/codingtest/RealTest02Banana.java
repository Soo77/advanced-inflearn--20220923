package codingtest;

import java.util.*;

public class RealTest02Banana {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        //Arrays.asList(array).contains(value);

        int start = 0; int correctCnt = 0;
        HashMap<Integer,Integer> resultMap = new HashMap<>();
        loop:
        for(int i=0; i<want.length; i++) {
            int productCnt = 0;
            if(!Arrays.asList(discount).contains(want[i])) {
                return answer;
            }

            //String[] tempDiscountArr = new String[10];
            List<String> tempDiscountList = new ArrayList<>();
            //10일 이하로 남으면 큰 for문 탈출
            if(discount.length-start+1 < 10) break;


            for (int j = 0; j < 10; j++) {
                if(j+start < discount.length) {
                    tempDiscountList.add(discount[j + start]);
                }
            }


            System.out.println("want[i]:"+want[i]+", start:"+start);
            for(String s : tempDiscountList) {
                System.out.print(s+" ");
            }
            System.out.println();
            for(int j=0; j<tempDiscountList.size(); j++) {
                if(tempDiscountList.get(j).equals(want[i]) && tempDiscountList.size() == 10) {
                    productCnt++;
                }

            }



            if(number[i] != productCnt) {
                i--;start++;
                continue ;
            } else {
                correctCnt++;
                resultMap.put(start, resultMap.getOrDefault(start,0)+1);
                start=0;
            }
        }

        System.out.println();
        resultMap.forEach((key,value) ->{
            System.out.println(key+":"+value);
        });
        return answer;
    }

    public static void main(String[] args) {
        String[] want={"banana","apple","rice","pork","pot"};
        int[] number={3,2,2,2,1};
        String[] discount={"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println("\ntest입니다.");
        System.out.println(solution(want,number,discount));
    }


}
