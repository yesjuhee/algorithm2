class JobAssignment {
    private int[][] costMatrix;
    private int n;
    private int minCost = Integer.MAX_VALUE;
    private int[] bestAssignment;

    public JobAssignment(int[][] costMatrix) {
        this.costMatrix = costMatrix;
        this.n = costMatrix.length;
        this.bestAssignment = new int[n];
    }

    public Result solve(boolean byPerson) {
        boolean[] visited = new boolean[n];
        int[] assignment = new int[n];

        branchAndBound(0, 0, visited, assignment, byPerson);

        return new Result(minCost, bestAssignment.clone());
    }

    private void branchAndBound(int level, int currentCost, boolean[] visited, int[] assignment, boolean byPerson) {
        if (currentCost >= minCost) {
            return;
        }

        if (level == n) {
            if (currentCost < minCost) {
                minCost = currentCost;
                System.arraycopy(assignment, 0, bestAssignment, 0, n);
            }
            return;
        }

        if (byPerson) {
            int currPerson = level;
            for (int job = 0; job < n; job++) {
                if (!visited[job]) {
                    visited[job] = true;
                    assignment[currPerson] = job;
                    branchAndBound(level + 1, currentCost + costMatrix[currPerson][job], visited, assignment, byPerson);
                    visited[job] = false;
                }
            }
        } else {
            int currJob = level;
            for (int person = 0; person < n; person++) {
                if (!visited[person]) {
                    visited[person] = true;
                    assignment[person] = currJob;
                    branchAndBound(level + 1, currentCost + costMatrix[person][currJob], visited, assignment, byPerson);
                    visited[person] = false;
                }
            }
        }
    }

    static class Result {
        int minCost;
        int[] assignment;

        public Result(int minCost, int[] assignment) {
            this.minCost = minCost;
            this.assignment = assignment;
        }
    }

    public static void main(String[] args) {
        int[][] costMatrix = {
                { 11, 12, 18, 40 },
                { 14, 15, 13, 22 },
                { 10, 17, 19, 23 },
                { 17, 14, 20, 28 }
        };

        JobAssignment solver = new JobAssignment(costMatrix);

        System.out.println("=== 작업 할당 문제 결과 ===");
        System.out.println("주어진 비용 행렬:");
        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix[i].length; j++) {
                System.out.print(costMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n사람 위주 할당 결과:");
        JobAssignment.Result personResult = solver.solve(true);
        printResult(personResult, true);

        System.out.println("\n작업 위주 할당 결과:");
        JobAssignment.Result jobResult = solver.solve(false);
        printResult(jobResult, false);
    }

    private static void printResult(JobAssignment.Result result, boolean byPerson) {
        System.out.println("최소 비용: " + result.minCost);
        System.out.println("작업 할당 결과:");
        for (int person = 0; person < result.assignment.length; person++) {
            if (byPerson) {
                System.out.printf("  사람 %d -> 작업 %d\n", person + 1, result.assignment[person] + 1);
            } else {
                System.out.printf("  작업 %d -> 사람 %d\n", person + 1, result.assignment[person] + 1);
            }
        }
    }
}
