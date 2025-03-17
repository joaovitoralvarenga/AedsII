#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>



#define TAM 100

bool ehPalindromo(char string[]) {
    bool palindromo = true;
    int tamanho = strlen(string);

    for(int i=0;i<tamanho/2;i++) {
        if(string[i] != string[tamanho - 1 -i]) {
            palindromo = false;
        }
    
    }
    return palindromo;
}

int main() {
    setlocale(LC_ALL, "pt_BR.UTF-8");

    char entrada[TAM];

    scanf(" ^[%\n\r]",entrada);
    getchar();

    while(strcmp(entrada, "FIM")!= 0) {
        if(ehPalindromo(entrada)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        scanf(" ^[%\n\r]",entrada);
        getchar();

        
    }

    return 0;   

}