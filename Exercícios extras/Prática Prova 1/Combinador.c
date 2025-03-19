#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM 100



void combinaStrings(char str1[], char str2[], char combinacao[]) {
    int j = 0;
    
    int tamanho1 = strlen(str1);
    int tamanho2 = strlen(str2);

    for(int i=0;i<tamanho1 && i<tamanho2;i++) {
        combinacao[j++] = str1[i];
        combinacao[j++] = str2[i];
        
    }

    


}


