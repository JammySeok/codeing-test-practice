package main.java.coding.progms.level2;

public class P42842_카펫 {

    // 내가 푼 방법
    public int[] solution1(int brown, int yellow) {

        if (yellow == 1) {
            return new int[] {3, 3};
        }

        int width = 0, height = 0;

        int yellowHight = 1;
        while (yellowHight <= yellow) {
            if (yellow % yellowHight == 0) {
                int curBrown = (yellowHight * 2) + (yellow / yellowHight * 2) + 4;

                if (curBrown == brown) {
                    width = yellow / yellowHight + 2;
                    height = yellowHight + 2;
                    break;
                }
            }
            yellowHight++;
        }

        return new int[] {width, height};
    }

    // 정공법
    public int[] solution2(int brown, int yellow) {
        // 카펫의 전체 타일 수 (넓이)
        int totalArea = brown + yellow;

        // 가로가 세로보다 길거나 같으므로, 세로는 전체 넓이의 제곱근까지만 탐색
        for (int height = 3; height <= Math.sqrt(totalArea); height++) {

            // 전체 넓이가 현재 세로 길이로 나누어 떨어질 때 (정상적인 직사각형일 때)
            if (totalArea % height == 0) {
                int width = totalArea / height;

                // 내부 노란색 타일의 개수 공식이 일치하는지
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[] {width, height};  // 조건 만족 시 즉시 반환
                }
            }
        }

        // 못찾으면 0
        return new int[] {0, 0};
    }
}
