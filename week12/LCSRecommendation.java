import java.util.ArrayList;
import java.util.List;

public class LCSRecommendation {
    // LCS 알고리즘 구현
    public static Result lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // LCS 추적
        StringBuilder lcsResult = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcsResult.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new Result(dp[m][n], lcsResult.reverse().toString());
    }

    // 추천 단어 계산
    public static String recommendWord(String baseWord, String[] compareWords) {
        String bestMatch = null;
        int maxLcsLength = 0;
        List<Comparison> comparisons = new ArrayList<>();

        System.out.println("기본 단어: " + baseWord);
        System.out.println("비교 결과:");
        for (String word : compareWords) {
            Result result = lcs(baseWord, word);
            comparisons.add(new Comparison(word, result.lcsLength, result.lcsString));
            System.out.println("단어: " + word + ", LCS 길이: " + result.lcsLength);

            if (result.lcsLength > maxLcsLength) {
                maxLcsLength = result.lcsLength;
                bestMatch = word;
            }
        }

        System.out.println("\n추천: " + bestMatch);
        return bestMatch;
    }

    // 메인 함수
    public static void main(String[] args) {
        String[][] samples = {
                { "intellagence", "intelligence", "intelligentsia" },
                { "accomodation", "accommodation", "accommodative" },
                { "enviroment", "environment", "environ" },
                { "managament", "management", "managing" },
                { "proffessor", "professor", "profession" }
        };

        for (String[] sample : samples) {
            String base = sample[0];
            String[] compares = new String[sample.length - 1];
            System.arraycopy(sample, 1, compares, 0, sample.length - 1);
            System.out.println();
            recommendWord(base, compares);
        }
    }

    // LCS 결과를 저장할 클래스
    static class Result {
        int lcsLength;
        String lcsString;

        public Result(int lcsLength, String lcsString) {
            this.lcsLength = lcsLength;
            this.lcsString = lcsString;
        }
    }

    // 비교 결과를 저장할 클래스
    static class Comparison {
        String word;
        int lcsLength;
        String lcsString;

        public Comparison(String word, int lcsLength, String lcsString) {
            this.word = word;
            this.lcsLength = lcsLength;
            this.lcsString = lcsString;
        }
    }
}