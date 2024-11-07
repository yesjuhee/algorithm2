import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        // Step 1: 10000개의 임의의 데이터 생성
        int[] data = new int[10000];
        Random random = new Random();
        
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100000); // 0 ~ 99999 사이의 임의의 정수 생성
        }
        
        // Step 2: 생성된 자료를 배열에 저장 (이미 data 배열에 저장됨)

        // Step 3: 배열의 내용을 정렬
        Arrays.sort(data);
        
        // Step 4 및 Step 5: 수를 입력 받아 정렬된 자료에서의 인덱스 번호 확인
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("검색할 숫자를 입력하세요 (종료하려면 Q 입력): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("Q")) { // Q 입력 시 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            try {
                int number = Integer.parseInt(input);
                int index = Arrays.binarySearch(data, number);
                
                if (index >= 0) {
                    System.out.println("입력한 숫자 " + number + "는 배열의 인덱스 " + index + "에 있습니다.");
                } else {
                    System.out.println("입력한 숫자 " + number + "는 배열에 존재하지 않습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
        
        scanner.close();
    }
}