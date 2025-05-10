#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct Celula {
	char* id;
	struct Celula* prox;
}Celula;                                         //Estruta básica da célula, que será utilizada para determinar os elementos da fila
 

Celula* novaCelula(const char* id) {
	Celula* nova = (Celula*) malloc(sizeof(Celula));
    if (nova == NULL) {
        fprintf(stderr, "Memory allocation error\n");
        exit(1);
    }

	nova->id = strdup(id);
    if (nova->id == NULL) {
        free(nova);
        fprintf(stderr, "Memory allocation error\n");
        exit(1);
    }
    
    nova->prox = NULL;
    return nova;
	                             //Estrutura de criação de uma nova instância de célula, representando a inserção de um novo elemento na fila

}

typedef struct Fila {
	Celula* primeiro;
	Celula* ultimo;

}Fila;



void inicia(Fila* fila) {
	Celula* nova = novaCelula("dummy");
    fila->primeiro = nova;
    fila->ultimo = nova;
	
}

void push(Fila* fila,const char* id) {
	Celula* nova = novaCelula(id);
    fila->ultimo->prox = nova;
    fila->ultimo = nova;
}


char* pop(Fila* fila) {
    if (fila->primeiro == fila->ultimo) {
        return NULL;
    }
    
    Celula* temp = fila->primeiro;
    fila->primeiro = fila->primeiro->prox;
    char* resp = strdup(fila->primeiro->id);              //Método de remoção de um elemento na fila,para executar a retirada dos aviões da fila enquanto imprime
     
    free(temp->id);
    free(temp);
    
    return resp;
}

int ehVazia(Fila* fila ) {
	return(fila->primeiro == fila->ultimo);
}

void freeFila(Fila* fila) {
    Celula* atual = fila->primeiro;
    while (atual != NULL) {
        Celula* prox = atual->prox;
        free(atual->id);
        free(atual);
        atual = prox;
    }
    fila->primeiro = NULL;
    fila->ultimo = NULL;
}
int main() {

	Fila norte, sul,leste,oeste;
	inicia(&norte);
	inicia(&sul);
	inicia(&leste);
	inicia(&oeste);
	

	char entrada[20] = "";
	int direcao =  0;
	

	while(strcmp(entrada,"0") != 0) {
		scanf("%s", entrada);

		if(entrada[0] == '-' && strlen(entrada) <= 3) {
			direcao = atoi(entrada);
		}else if(entrada[0] == 'A') {
			char aviao[20];
			strcpy(aviao,entrada);
			
			

			switch (direcao) 
			{
			case -4 :
			   push(&leste,aviao);                              //Método de determinação de casos, que incluem elementos na fila de forma flexível, para serem verificados depois    
				break;
 
			case -3:
		       push(&norte,aviao);
			   break;

			case -2:
			    push(&sul,aviao);
				break;
			
			case -1:
			    push(&oeste,aviao);
				break;
			}
		}
	}

	

	
	int primeiro = 1;

	while(!ehVazia(&oeste) || !ehVazia(&norte) || !ehVazia(&sul) || !ehVazia(&leste)) {

		if(!ehVazia(&oeste)) {
			char* aviao = pop(&oeste);
			if(!primeiro) printf(" ");
		printf("%s", aviao);                                                               //Executa o "pop" do elemento "x" da lista, enqunanto imprime
			primeiro = 0;                                                                  //a fim de garantir a eficiência.
			primeiro = 0;
			free(aviao);
	}
		if(!ehVazia(&leste)) {
			char* aviao = pop(&leste);
			free(aviao);
	}
		if(!ehVazia(&norte)) {
			char* aviao = pop(&norte);
			if(!primeiro) printf(" ");
			printf("%s", aviao);
			primeiro = 0;
			free(aviao);
	}
		if(!ehVazia(&sul)) {
			char* aviao = pop(&sul);
			if(!primeiro) printf(" ");
			printf("%s", aviao);
			primeiro = 0;
			free(aviao);
	}
		if(!ehVazia(&leste)) {
			char* aviao = pop(&leste);
			if(!primeiro) printf(" ");
			printf("%s", aviao);
			primeiro = 0;
			free(aviao);
	}
	
		
}

printf("\n");

	freeFila(&norte);
	freeFila(&sul);
	freeFila(&leste);
	freeFila(&oeste);

	return 0;
}


