#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define TAM 100

void reverteString(char string[],int inicio, int fim) {
   

    if(inicio<fim) {
        char temp = string[inicio];
        string[inicio] = string[fim];
        string[fim] = temp;
        reverteString(string, inicio+1, fim - 1);

    }

   
} 

void chamaRecursão(char str[]) {
    int tamanho = strlen(str);
    reverteString(str,0,tamanho -1);
}

int main() {
    char entrada[TAM];

    scanf("%s", entrada);

    while(strcmp(entrada,"FIM")!= 0) {
        chamaRecursão(entrada);

        printf("%s\n", entrada);

        scanf("%s",entrada);
    }
}


