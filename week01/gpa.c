#include <stdio.h>

int main() {
    int n, credit, score, cur;
    int total_gpa = 0;
    int total_credit = 0;

    printf("과목 수 : ");
    scanf("%d", &n);

    for (cur = 0; cur < n; cur++) {
        printf("학점 %d: ", cur + 1);
        scanf("%d", &credit);
        printf("성적 %d: ", cur + 1);
        scanf("%d", &score);

        total_gpa += score * credit;
        total_credit += credit;
    }

    printf("전체 성적 평균: %f\n", (float)total_gpa / total_credit);
}