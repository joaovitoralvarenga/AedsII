#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define TAM 100

bool ehPalindromo(char string[], int i) {
	bool palindromo = true;
	int tamanho = strlen(string);

	if(i > tamanho/2) {
		palindromo = true;
	}else {
		if(string[i] != string[tamanho - 1-  i]) {
			palindromo = false;
		} else {
			palindromo = ehPalindromo(string, i + 1);
		}
	}
	return palindromo;
}

bool ehFim(char str[]) {
	return(strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
}

int main() {

	char entrada[TAM];

	scanf("%[^\n]", entrada);

	while(!ehFim(entrada)) {
		if(ehPalindromo(entrada,0)) {
			printf("SIM\n");
		} else {
			printf("NAO\n");
		}
		scanf("%[^\n]", entrada);
	}

	return 0;

}



