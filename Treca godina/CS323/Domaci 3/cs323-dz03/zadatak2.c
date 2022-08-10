#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

//18. Napisati funkciju koja dati string s skraćuje na podstring od prvih p znakova. Zadatak jako nejano postavljen.
// Mogucnost: F-ja koja skracuje string na substring na prvih p znakova gde je p broj znakova prosledjen f-ji.

void result(char *data, int p) {
    for (int i = 0; i < strlen(data); ++i) {
        if (i == p) {
            data[i] = '\0';
        }
    }
}

int main() {

    char str[100];
    int size;

    printf("Unesite string: ");
    scanf("%s", str);

    printf("Unesite broj znakova za substring: ");
    scanf("%d", &size);

    printf("Pre funckije: %s \n", str);

    result(str, size);

    printf("Posle funckije: %s", str);

    return 0;
}