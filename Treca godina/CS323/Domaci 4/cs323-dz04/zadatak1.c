#include <stdio.h>
#include <stdbool.h>
// Napisati program u C-u koji učitava niz realnih brojeva od n elemenata i realan broj x.
// Napisati funkciju PoslednjaPojava koja vraća najveći indeks elemenata niza koji je jednak
// broju x, a ako ga nema vraća -1. Iz glavnog programa pozvati funkciju PoslednjaPojava.
// Funkciju implementirati kao:
// void PoslednjaPojava (int *Niz, int n, int *najveciIndex);

void poslednjaPojava (const int *niz, int n, int *najveciIndex) {
    int index = -1;
    for (int i = 0; i < 5; ++i) {
        if (niz[i] == n) {
            index = i;
        }
    }
   *najveciIndex = index;
}

int main() {

    int niz[5];
    int x;
    int najveciIndeks;

    for (int i = 0; i < 5; ++i) {
        printf("Unesite %d element: ", i);
        scanf("%d", &niz[i]);
    }

    printf("Unesite broj x: ");
    scanf("%d", &x);

    poslednjaPojava(niz, x, &najveciIndeks);

    printf("Najveci index elementa jednak broju %d je %d" ,x ,najveciIndeks);

    return 0;
}
