#include <stdio.h>

int sum_of_numbers(const int array[]) {
    int i;
    int sum = 0;
    for (i = 0; i < 5; ++i) {
        sum += array[i];
    }
    return sum;
}

int main() {
    int budzet;
    int array[5];
    int i;
    printf("Unesite svoj pocetni budzet: \n");
    scanf("%d", &budzet);

    printf("Unesite 5 cene stavke na koje ste potrosili novac: \n");
    for (i = 0; i < 5; ++i) {
        scanf("%d", &array[i]);
    }

    int rezultat = budzet - sum_of_numbers(array);
    printf("%d", rezultat);
    return 0;
}