package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChatting {
    public static String[] solution(String[] record) {
        String[] answer = {};

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        HashMap<String,String> lastNick = new HashMap<>();
        for(String s : record) {
            if (s.split(" ")[0].equals("Change")) {
                lastNick.put(s.split(" ")[1], s.split(" ")[2]);
            }  else if (s.split(" ")[0].equals("Enter")) {
                lastNick.put(s.split(" ")[1], s.split(" ")[2]);
            }
        }

        lastNick.forEach((key,value) ->{
            System.out.println(key+"우르르"+value);
        });

        //진짜 마지막 출력해보기
        List<String> answerList = new ArrayList<>();
        for(String s : record) {
            if(s.startsWith("Enter")) {
                answerList.add(lastNick.get(s.split(" ")[1])+"님이 들어왔습니다.");
            } else if(s.startsWith("Leave")) {
                answerList.add(lastNick.get(s.split(" ")[1])+"님이 나갔습니다.");
            }
        }

        String[] answer = answerList.toArray(new String[answerList.size()]);
        System.out.println("찐막");

        for(String s : answer) {
            System.out.println(s);
        }
    }


}
