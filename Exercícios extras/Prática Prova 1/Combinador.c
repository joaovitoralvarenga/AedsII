#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM 250



void combinaStrings(char str1[], char str2[], char combinacao[]) {
    int j = 0;
    int i;
    
    int tamanho1 = strlen(str1);
    int tamanho2 = strlen(str2);

    for(i=0;i<tamanho1 && i<tamanho2;i++) {
        combinacao[j++] = str1[i];
        combinacao[j++] = str2[i];
        
    }

    if(tamanho1 > tamanho2) {
        for(; i<tamanho1;i++) {
            combinacao[j++] = str1[i];
        }
    } else if(tamanho2> tamanho1) {
        for(; i<tamanho2;i++) {
            combinacao[j++] = str2[i];
        }

    }

    combinacao[j] = '\0';



}

int main() {
    char str1[TAM],str2[TAM], combinacao[TAM*2];

    while(scanf("%s %s", str1,str2) == 2) {
        combinaStrings(str1,str2,combinacao);

        printf("%s\n", combinacao);
    }
        

        return 0;

    }

        

    



