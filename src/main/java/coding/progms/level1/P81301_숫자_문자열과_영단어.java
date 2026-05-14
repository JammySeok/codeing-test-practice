package main.java.coding.progms.level1;

public class P81301_숫자_문자열과_영단어 {

    // 정공법
    public int solution1(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder str = new StringBuilder();  // 임시로 단어 저장할 String 공간
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < s.length(); i++) {
            // String -> Char
            char c = s.charAt(i);

            // Char가 숫자이면
            if(Character.isDigit(c)) {
                answer.append(c);
            }
            // Char가 문자이면
            else {
                str.append(c);

                // words를 순회하면서 str과 같은 단어가 있는지 확인
                for (int j = 0; j < words.length; j++) {
                    if(words[j].contentEquals(str)) {
                        answer.append(j);
                        str.setLength(0);  // 임시 단어 공간 비우기
                        break;
                    }
                }
            }
        }

        return Integer.parseInt(String.valueOf(answer));
    }

    // replace 사용 (간단)
    public int solution2(String s) {
        String str = s.replace("zero", "0")
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9");

        return Integer.parseInt(str);
    }
}