package codingtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReportUsers {


        public static int[] solution(String[] id_list, String[] report, int k) {
            List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
            HashMap<String, Integer> count = new HashMap<>();
            for(String s : list) {
                String target = s.split(" ")[1];
                count.put(target, count.getOrDefault(target, 0)+1);
            }

            count.forEach((key,value) -> {
                System.out.println(key + ":" + value);
            });
            System.out.println("아자차카");
            return Arrays.stream(id_list).map(_user -> {
                final String user = _user;
                List<String> reportList = list.stream().filter(s -> s.startsWith(user+" ")).collect(Collectors.toList());
                return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1],0)>=k).count();
            }).mapToInt(Long::intValue).toArray();

        }

        public static void main(String[] args) {
            String[] id_list = {"muzi", "frodo", "apeach", "neo"};
            String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
            int k = 2;
            int answer[] = ReportUsers.solution(id_list,report,k);
            for(int s : answer) {
                System.out.print(s + " ");
            }
        }

}
