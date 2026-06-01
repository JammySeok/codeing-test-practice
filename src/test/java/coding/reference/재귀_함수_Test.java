package test.java.coding.reference;

import main.java.coding.reference.재귀_함수;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class 재귀_함수_Test {

    재귀_함수 ref = new 재귀_함수();

    @Test
    void 테스트1_이진선택() {
        // Given
        List<String> result = List.of("OO", "OX", "XO", "XX");
        List<String> answerList = new ArrayList<>();

        // When
        ref.recursiveFunction1("", 0, 2, answerList);

        // Then
        Assertions.assertEquals(result, answerList);
        System.out.println("테스트 1 결과 (O/X) = " + answerList);
    }

    @Test
    void 테스트2_다중선택_비밀번호() {
        // Given
        char[] options = {'A', 'B', 'C'};
        List<String> result = List.of("AA", "AB", "AC", "BA", "BB", "BC", "CA", "CB", "CC");
        List<String> answerList = new ArrayList<>();

        // When
        ref.recursiveFunction2("", 0, 2, options, answerList);

        // Then
        Assertions.assertEquals(result, answerList);
        System.out.println("테스트 2 결과 (비밀번호) = " + answerList);
    }

    @Test
    void 테스트3_중복없는_순열() {
        // Given: 'A', 'B', 'C' 중 중복 없이 2자를 뽑는 경우 (AA, BB 등은 불가능)
        char[] options = {'A', 'B', 'C'};
        boolean[] visited = new boolean[options.length];
        List<String> result = List.of("AB", "AC", "BA", "BC", "CA", "CB");
        List<String> answerList = new ArrayList<>();

        // When
        ref.recursiveFunction3("", 0, 2, options, visited, answerList);

        // Then
        Assertions.assertEquals(result, answerList);
        System.out.println("테스트 3 결과 (순열) = " + answerList);
    }

    @Test
    void 테스트4_값반환_피보나치() {
        // Given: 피보나치 수열의 5번째 숫자는 5 (0, 1, 1, 2, 3, 5)
        int n = 5;
        int expectedResult = 5;

        // When
        int answer = ref.recursiveFunction4(n);

        // Then
        Assertions.assertEquals(expectedResult, answer);
        System.out.println("테스트 4 결과 (피보나치 5번째 항) = " + answer);
    }
}