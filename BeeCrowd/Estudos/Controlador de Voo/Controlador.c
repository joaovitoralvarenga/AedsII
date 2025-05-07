#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct Celula {
	int elemento;
	struct Celula* prox;
}Celula;

typedef struct Fila {
	Celula* primeiro;
	Celula* ultimo;
}Fila;

Celula* novaCelula(int elemento) {
	Celula* nova = (Celula*) malloc(sizeof(Celula));
	nova->elemento = elemento;
	nova->prox = NULL;
	return nova;

}

void inicia() {
	primeiro = novaCelula(-1);
	ultimo = primeiro
}


