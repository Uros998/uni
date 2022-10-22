#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int getRandomNumber(int min, int max) {
	return rand() % (max - min + 1) + min;
}

void printNiz(int* n, int s) {
	int i;
	for (i = 0; i < s; i++) {
		printf("%d ", n[i]);
	}
	printf("\n");
}

int main() {
	srand(time(0));
	int n;
	int i;
	printf("Unesite koliko elementa zelite da prikazete u nizu A:");
	scanf_s("%d", &n);
	int* A = (int*)malloc(n * sizeof(int));

	for (i = 0; i < n; i++) {
		A[i] = getRandomNumber(-100, 100);
	}

	printf("Niz A:");
	printNiz(A, n);
	return 0;
}