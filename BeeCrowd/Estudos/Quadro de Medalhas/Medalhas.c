#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM 500
#define MAX 101

typedef struct {
	char nome[MAX];
	int ouro,prata,bronze;
}Paises;

void ordenaPaises(Paises pais[], int n) {
	for(int i=0;i<n-1;i++) {
		for(int j =0;j< n-i-1;j++) {
			int troca = 0;                                       
			if(pais[j].ouro < pais[j+1].ouro) {
				troca = 1;
			} else if(pais[j].ouro == pais[j+1].ouro) {              //Ordena- se o conjunto de elementos por bubblesort, verificando se existe a necessidade da realização de troca
				if(pais[j].prata< pais[j+1].prata) {                 //para só depois realizar a troca, a fim de evitar operações desnecessárias.
					troca = 1;
				} else if (pais[j].prata == pais[j+1].prata) {
					if(pais[j].bronze < pais[j+1].bronze) {
						troca = 1;
					} else if(pais[j].bronze == pais[j+1].bronze) {
						if(strcmp(pais[j].nome, pais[j+1].nome) > 0) {
							troca = 1;
						}
					}
				}
			}
				

				if (troca)  {
					Paises temp = pais[j];
					pais[j] = pais[j+1];
					pais[j+1] = temp;
				}
			}
			
		}
	}

int main() {
	int n;
	scanf("%d", &n);

	Paises pais[MAX];

	for(int i = 0;i<n;i++) {
		scanf("%s %d %d %d", pais[i].nome, &pais[i].ouro, &pais[i].prata , &pais[i].bronze);
	}
	
	ordenaPaises(pais, n);

	for(int i = 0;i<n;i++) {
		printf("%s %d %d %d\n", pais[i].nome, pais[i].ouro, pais[i].prata , pais[i].bronze);
	}

	return 0;
}
