package codingtest;

public class IDRecommendation {
    public static String solution(String new_id) {
        String answer = "";

        //1단계
        answer = new_id.toLowerCase();
        //2단계//특수문자는 -,_,. 만 가능
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        //answer = answer.replaceAll()
        //System.out.println("return answer:"+answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(IDRecommendation.solution("ABcdE#$%^-_-.3245*&%$#f#Q%#^@&gEHI"));
        System.out.println(IDRecommendation.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("010-1111-2222".replaceAll("[^0-9]", ""));
    }


}
