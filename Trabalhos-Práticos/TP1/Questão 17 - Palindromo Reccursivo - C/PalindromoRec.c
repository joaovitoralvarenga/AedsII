#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#include <locale.h>

#define TAM 1000       //Definição de tamanho lógico maior a fim de evitar sobrecarga de buffer,
                       // o que anteriormente causava a sobreposição de linhas e gerava mais saídas que o esperado



bool ehPalindromo(char string[], int i) {
	bool palindromo = true;
	int tamanho = strlen(string);

	if(i > tamanho/2) {
		palindromo = true;
		//Definição do caso base, que retorna que a string é um palindromo uma vez que as duas divisões da string já foram percorridas.
	}else {
		if(string[i] != string[tamanho - 1-  i]) { //Retorna que não é palindromo uma vez que após percorrer as substrings as letras não coincidiram
			palindromo = false;
		} else {
			palindromo = ehPalindromo(string, i + 1); 
		}
	}
	return palindromo;
}

int main() {
	setlocale(LC_ALL, "pt_BR.UTF-8");

	char entrada[TAM];
	

	fgets(entrada,sizeof(entrada), stdin);
	entrada[strcspn(entrada, "\n")] = '\0';

	while(strcmp("FIM", entrada) != 0) {
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



