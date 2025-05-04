#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void ordenaPorCouting(char livros[][5],int codigos[],int tam) {
	int max = 0;
	for(int i=0;i<tam;i++) {
		if(codigos[i] > max) {
			max = codigos[i];
		}
	}

	int *contador = (int*)calloc(max + 1, sizeof(int));
	
	for(int i = 0;i<tam;i++) {
		contador[codigos[i]]++;

	}

	char (*resultado)[5] = (char(*)[5])malloc(tam * sizeof(char[5]));

	int indiceResultado = 0;
	for(int i=0;i<= max;i++) {
		while(contador[i] > 0) {

			sprintf(resultado[indiceResultado], "%04d", i);
			indiceResultado++;
			contador[i]--;

		}
	}

	for(int i = 0;i<tam;i++) {
		strcpy(livros[i],resultado[i]);
				
	}

	free(resultado);
	free(contador);

	}

int main() {

int n;

while(scanf("%d", &n) != EOF) {

char (*codigoLivros) [5] = (char(*)[5])malloc(n * sizeof(char[5]));
int *codigos = (int*)malloc(n* sizeof(int));

for(int i=0;i<n;i++) {
	scanf("%s",codigoLivros[i]);
	codigos[i] = atoi(codigoLivros[i]);
}

 ordenaPorCouting(codigoLivros,codigos,n);

 for(int i=0;i<n;i++) {
	printf("%s\n", codigoLivros[i]);
 }

 free(codigoLivros);
 free(codigos);

 

}

return 0;

}
				
		
