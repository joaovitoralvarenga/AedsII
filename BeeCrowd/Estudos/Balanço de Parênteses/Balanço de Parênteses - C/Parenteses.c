#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define TAM 1000
typedef struct Pilha {
	char data[TAM];
	int top;
}Stack;

void inicia(Stack *s) {
	s->top = -1;
}
bool ehVazia(Stack *s) {
	return s->top == -1;
}
void push(Stack *s, char c) {
	s->data[++(s->top)] = c;
}

char pop(Stack *s) {
	return s->data[(s->top)--];
}

bool ehValida(char *str) {
	Stack parenteses;
	bool valida = true;
	inicia(&parenteses);

	for(int i=0;i<strlen(str);i++) {
		char c = str[i];

		if(c == '(') {
			push(&parenteses,c);
		} else if(c == ')' && !ehVazia(&parenteses)) {
			pop(&parenteses);
		}else if(c == ')') {

			valida = false;
		}
	}

	if(valida && !ehVazia(&parenteses)) {
		valida = false;
	}

	return valida;
}

int main() {
	char entrada[TAM];

	while(fgets(entrada,TAM,stdin) != NULL) {
		if(ehValida(entrada)) {
			printf("correct\n");
		}
		else {
			printf("incorrect\n");
		}
	}

	return 0;
}

