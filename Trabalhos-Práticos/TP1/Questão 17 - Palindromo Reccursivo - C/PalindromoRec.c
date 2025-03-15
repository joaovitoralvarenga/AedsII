#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#include <locale.h>

#define TAM 100
#define TAM_STR "99"

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
	bool ehFim = false;
	if(strlen(str) == 3) {
		if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
			ehFim = true;
		}
	}
	return ehFim;
}

int main() {
	setlocale(LC_ALL, "pt_BR.UTF-8");

	char entrada[TAM];
	

	fgets(entrada,sizeof(entrada), stdin);
	entrada[strcspn(entrada, "\n")] = '\0';

	while(!ehFim(entrada)) {
		if(ehPalindromo(entrada,0)) {
			printf("SIM\n");
		} else {
			printf("NAO\n");
		}

		fgets(entrada,sizeof(entrada), stdin);
		entrada[strcspn(entrada, "\n")] = '\0';
	
	}

	return 0;

}



