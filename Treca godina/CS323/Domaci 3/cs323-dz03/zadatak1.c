#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include<time.h>

//Napisati program koji formira matricu dimenzije m x n čije elemente biraslu čajnim izborom
//brojeva od 0 do 9. Izračunati sumu parnih elemenata, i prebrojati koliko je elemenata
//jednako nuli, pa zatim prikazati matricu i dobijene rezultate.

int main() {

    int m,n,i,j,k,o;
    int isZero = 0;
    int sum = 0;

    printf("Unesite broj vrsta: ");
    scanf("%d", &m);

    printf("Unesite broj kolona: ");
    scanf("%d", &n);

    int matrix[m][n];

    srand(time(NULL));
    for(i = 0; i < 3; i++){
        for(j = 0; j < 3; j++){
            matrix[i][j] = rand() % 10;
            if (matrix[i][j] % 2 == 0) {
                sum += matrix[i][j];
            }
            if (matrix[i][j] == 0) {
                isZero++;
            }
        }
    }

    for (k = 0; k < 3 ; ++k) {
        for (o = 0; o < 3; ++o) {
            printf("%d ", matrix[k][o]);
        }
        printf("\n");
    }

    printf("Zbir parnih elemenata: %d \n", sum);
    printf("Broj elemenata jednak nuli je %d", isZero);

    return 0;
}
