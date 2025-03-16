#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM 100


int somaRecursiva(int n) {

    int soma = 0;
    
    if(n == 0) {
        soma = 0;
    } else {
        soma = (n % 10) + somaRecursiva(n/10);
    }

    return soma;
    }

int main() {
    char entrada[TAM];

    scanf("%s", entrada);

    while(strcmp(entrada, "FIM") !=0 ) {
       

        int numero = atoi(entrada);

        printf("%d\n", somaRecursiva(numero));

        scanf("%s", entrada);
    }

    return 0;

}

    
    

