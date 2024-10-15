import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        // 랜덤 난수 생성
        int[] randomNumbers = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            randomNumbers[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();

        // selection sort
        for (int i = 0; i < 1000 - 1; i++) {
            for (int j = i + 1; j < 1000; j++) {
                if (randomNumbers[i] > randomNumbers[j]) {
                    // swap
                    int temp = randomNumbers[i];
                    randomNumbers[i] = randomNumbers[j];
                    randomNumbers[j] = temp;
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
