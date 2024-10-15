import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    // Merge Sort 함수
    public static void mergeSort(int[] array, int[] tempArray, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;  // 더 이상 나눌 수 없는 경우
        }

        int middle = (leftStart + rightEnd) / 2;  // 배열을 반으로 나눔
        mergeSort(array, tempArray, leftStart, middle);  // 왼쪽 절반 정렬
        mergeSort(array, tempArray, middle + 1, rightEnd);  // 오른쪽 절반 정렬
        mergeHalves(array, tempArray, leftStart, rightEnd);  // 나눠진 배열을 병합
    }

    // 배열 병합 함수
    public static void mergeHalves(int[] array, int[] tempArray, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        // 좌우 배열을 병합하는 과정
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tempArray[index] = array[left];
                left++;
            } else {
                tempArray[index] = array[right];
                right++;
            }
            index++;
        }

        // 왼쪽 절반의 남은 요소 복사
        System.arraycopy(array, left, tempArray, index, leftEnd - left + 1);

        // 오른쪽 절반의 남은 요소 복사
        System.arraycopy(array, right, tempArray, index, rightEnd - right + 1);

        // 병합된 결과를 원본 배열로 복사
        System.arraycopy(tempArray, leftStart, array, leftStart, size);
    }

    // 임의의 수 100개를 생성하는 함수
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);  // 0부터 9999 사이의 임의의 수 생성
        }
        return array;
    }

    // 메인 함수: 실행 시간 측정 및 Merge Sort 수행
    public static void main(String[] args) {
        int[] array = generateRandomArray(100);  // 100개의 임의의 수 생성
        int[] tempArray = new int[array.length];  // 임시 배열 준비

        System.out.println("Before Sorting: " + Arrays.toString(array));  // 정렬 전 배열 출력

        long startTime = System.nanoTime();  // 시작 시간 측정

        mergeSort(array, tempArray, 0, array.length - 1);  // Merge Sort 수행

        long endTime = System.nanoTime();  // 끝 시간 측정
        double duration = (double) (endTime - startTime) / 1000000;  // 밀리초로 변환

        System.out.println("After Sorting: " + Arrays.toString(array));  // 정렬 후 배열 출력
        System.out.println("Merge Sort Execution Time: " + duration + " ms");
    }
}