#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM 100

void combinaString(char *str1, char *str2, char *combinacao) {
    int tam1 = strlen(str1);
    int tam2 = strlen(str2);
    int i,j = 0;

    for(i = 0;i<tam1 && i<tam2;i++) {
        combinacao[j++] = str1[i];
        combinacao[j++] = str2[i];
    }

    while(i<tam1) {
        combinacao[j++] = str1[i];
        i++;
    }

    while(i<tam2) {
        combinacao[j++] = str2[i];
        i++;
    }
}

int main() {
    char str1[TAM], str2[TAM],combinacao[TAM *2];
    int n;

    scanf("%d", &n);

    for(int i=0;i<n;i++) {

        scanf("%s %s" , str1,str2);
        combinaString(str1,str2,combinacao);

        printf("%s", combinacao);

    }

    return 0;
}

