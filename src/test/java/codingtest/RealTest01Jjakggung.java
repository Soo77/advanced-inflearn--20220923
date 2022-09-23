package codingtest;

import java.util.*;

public class RealTest01Jjakggung {
    public static String[] solution(String[] record) {
        String[] answer = {};

        return answer;
    }

    public static void main(String[] args) {
        String answer = "";

        String X="100";
        String Y="203045";

        List<String> Xmember = new ArrayList<>();
        List<String> Ymember = new ArrayList<>();

        HashMap<String, Integer> Xmap = new HashMap<>();
        HashMap<String, Integer> Ymap = new HashMap<>();

        for(int i=0; i<X.length(); i++) {
            Xmap.put(X.split("")[i],Xmap.getOrDefault(X.split("")[i],0)+1);
            if(!Xmember.contains(X.split("")[i])) Xmember.add(X.split("")[i]);
        }

        for(int i=0; i<Y.length(); i++) {
            Ymap.put(Y.split("")[i],Ymap.getOrDefault(Y.split("")[i],0)+1);
            if(!Ymember.contains(Y.split("")[i])) Ymember.add(Y.split("")[i]);
        }

        List<String> jjak = new ArrayList<>();
        for(int i=0; i<Xmember.size(); i++) {
            if(Ymember.contains(Xmember.get(i))) {
                int min = Math.min(Xmap.get(Xmember.get(i)),Ymap.get(Xmember.get(i))) ;
                for(int j=0; j<min; j++) {
                    jjak.add(Xmember.get(i));
                }
            }
        }
        if(jjak.isEmpty()) {
            answer="-1";
        } else {
            Collections.sort(jjak, Collections.reverseOrder());
        }

        if(!jjak.isEmpty() && jjak.get(0).equals("0")) {
            answer = "0";
        } else {
            for (String s : jjak) {
                answer+=s;
            }
        }


        System.out.println("answer:"+answer);
    }


}
