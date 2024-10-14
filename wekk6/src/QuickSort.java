import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    // Quick Sort 함수
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);  // 피벗을 기준으로 배열을 나눔
            quickSort(array, low, pivotIndex - 1);         // 피벗의 왼쪽 부분을 정렬
            quickSort(array, pivotIndex + 1, high);        // 피벗의 오른쪽 부분을 정렬
        }
    }

    // Partition 함수 - 피벗을 기준으로 배열을 나누는 과정
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];  // 피벗을 배열의 첫 번째 요소로 설정
        int left = low + 1;
        int right = high;

        while (left <= right) {
            // 피벗보다 큰 값을 찾음
            while (left <= right && array[left] <= pivot) {
                left++;
            }
            // 피벗보다 작은 값을 찾음
            while (left <= right && array[right] > pivot) {
                right--;
            }
            // left와 right 값이 교차되지 않았다면 교환
            if (left < right) {
                swap(array, left, right);
            }
        }
        // 피벗을 올바른 위치에 놓음
        swap(array, low, right);
        return right;  // 피벗의 최종 위치 반환
    }

    // 배열의 두 요소를 교환하는 함수
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 임의의 1000개 수 생성하는 함수
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);  // 0부터 9999까지의 랜덤한 수 생성
        }
        return array;
    }

    // 메인 함수: 실행 시간 측정 및 퀵 소트 수행
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000);  // 1000개의 임의의 수 생성
        System.out.println("Before Sorting: " + Arrays.toString(array));

        long startTime = System.nanoTime();  // 시작 시간 측정

        quickSort(array, 0, array.length - 1);  // 퀵 소트 수행

        long endTime = System.nanoTime();  // 끝 시간 측정
        double duration = (double) (endTime - startTime) / 1000000;  // 밀리초로 변환

        System.out.println("After Sorting: " + Arrays.toString(array));
        System.out.println("Quick Sort Execution Time: " + duration + " ms");
    }
}