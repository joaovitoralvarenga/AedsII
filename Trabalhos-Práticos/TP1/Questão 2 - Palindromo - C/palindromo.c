#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <wchar.h>
#include <locale.h>
#define TAM 100

int main()
{
    setlocale(LC_ALL, "");
    wchar_t string[TAM];
    
    fgetws(string, TAM, stdin);
    string[wcscspn(string, L"\n")] = L'\0';
    
    while (wcscmp(string, L"FIM") != 0) {
        int ehPalindromo = 1;
        int contador = wcslen(string);
        
        for(int i = 0; i < contador/2; i++) {
            if(string[i] != string[contador - i - 1]){
                ehPalindromo = 0;
            }
        }
        
        if(ehPalindromo) {
            wprintf(L"SIM\n");
        } else {
            wprintf(L"NAO\n");
        }
        
        fgetws(string, TAM, stdin);
        string[wcscspn(string, L"\n")] = L'\0';
    }
    
    return 0;
}