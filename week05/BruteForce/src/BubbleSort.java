import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        // 랜덤 난수 생성
        int[] randomNumbers = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            randomNumbers[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();

        // Bubble Sort
        for (int i = 0; i < 1000 - 1; i++) {
            for (int j = 0; j < 1000 - i - 1; j++) {
                if (randomNumbers[j] > randomNumbers[j + 1]) {
                    // swap
                    int temp = randomNumbers[j];
                    randomNumbers[j] = randomNumbers[j + 1];
                    randomNumbers[j + 1] = temp;
                }
            }
        }

        long end = System.currentTimeMillis();

        // 출력
        for (int i = 0; i < 1000; i++) {
            System.out.print(randomNumbers[i] + "\n");
        }
        System.out.println((end - start) + " milliseconds");
    }
}
