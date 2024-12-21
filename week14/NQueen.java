public class NQueen {
    private static final int SIZE = 8;
    private static int[] col = new int[SIZE];

    public static void main(String[] args) {
        nqueen(0);
    }

    private static boolean check(int x) {
        for (int i = 0; i < x; i++) {
            // 같은 열에 있거나, 대각선에 있는 경우
            if (col[i] == col[x] || Math.abs(col[i] - col[x]) == x - i) {
                return false;
            }
        }
        return true;
    }

    private static void nqueen(int x) {
        if (x == SIZE) {
            // 해답 출력
            for (int i = 0; i < SIZE; i++) {
                System.out.printf("(%d,%d) ", i, col[i]);
            }
            System.out.println();
        } else {
            for (int i = 0; i < SIZE; i++) {
                col[x] = i;
                if (check(x)) {
                    nqueen(x + 1);
                }
            }
        }
    }
}