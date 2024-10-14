#include <stdio.h>

int main() {
    int n, m = 1, f = 1;

    printf("input: ");
    scanf("%d", &n);

    for (m; m <= n; m++) {
        f *= m;
    }

    printf("output: %d\n", f);
}