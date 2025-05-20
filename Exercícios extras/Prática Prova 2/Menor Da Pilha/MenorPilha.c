#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Celula {
	int elemento;
	int minAtual;
	struct Celula* prox;

}Celula;

Celula* novaCelula(int elemento, int minimo) {
	Celula* nova = (Celula*)malloc(sizeof(Celula));
	nova->elemento = elemento;
	nova->minAtual = minimo;
	nova->prox = NULL;
	return nova;

}

Celula* topo;


void inicia() {
	topo = NULL;
}

void push(int x) {
	int minimo;

	if(topo == NULL) {
	      minimo = x;
	}
	else {
		minimo = (x < topo->minAtual) ? x : topo->minAtual;
	}
	Celula* temp = novaCelula(x,minimo);
	temp->prox = topo;
	topo = temp;
	temp = NULL;
}

int pop() {
	if(topo == NULL) {
		printf("EMPTY\n");
	}

	int resp = topo->elemento;
	Celula* temp = topo;
	topo = topo->prox;
	temp->prox = NULL;
	free(temp);
	return resp;

}

int minimo() {
	int resp = -1;
	if(topo == NULL) {
		printf("EMPTY\n");
	} else {
		resp = topo->minAtual;
	}

	return resp;

}

int main() {
	int n;
	scanf("%d",&n);

	inicia();

	char operacao[10];
	int valor;
	int i = 0;

	while(i<n) {

		scanf("%s",operacao);

		if(strcmp(operacao, "PUSH") == 0) {
			scanf("%d", &valor);
			push(valor);
		
		}else if(strcmp(operacao, "MIN") == 0) {
			int min = minimo();
			if(min >=0 ) {
				printf("%d\n",min);
			}
		
		}else if(strcmp(operacao, "POP") == 0) {
			pop();
		}
	i++;

	}

	while(topo != NULL) {
		pop();
	}

	return 0;

}





