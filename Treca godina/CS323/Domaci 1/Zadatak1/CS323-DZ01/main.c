#include <stdio.h>
#include <math.h>

int main() {
    double r;
    printf("Unesite poluprecnik kruga:\n");
    scanf("%2lf", &r);
    double sqrR = r * r;
    double P = sqrR * M_PI;
    printf("P = r^2 * Pi = %.2lf^2*%.2lf = %.2lf * %.2lf = %.2lfcm2", r, M_PI, sqrR, M_PI, P);
    double O = 2 * r * M_PI;
    printf("\nO = 2 * r * Pi = 2 * %.2lf * Pi = %.2lfcm", r, O);
    return 0;
}
