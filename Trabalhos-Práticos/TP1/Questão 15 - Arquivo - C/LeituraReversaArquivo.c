#include <stdio.h>
#include <stdlib.h>

       void escreveArquivo(int n) {
              FILE *arquivo;
              arquivo = fopen ("arquivo.txt", "wb");

              for(int i=0;i<n;i++) {
                     double numero;
                     scanf("%lf", &numero);
                     fwrite(&numero, sizeof(double),1, arquivo); 
              }
              fclose(arquivo);
       }

       void leArquivoReverso(int n) {
              FILE *arquivo;
              arquivo = fopen("arquivo.txt", "rb");

              fseek(arquivo, 0, SEEK_END);
              long tamArq = ftell(arquivo);
              int contador = tamArq / sizeof(double);
              int leContador = contador;

              if(n<contador) {
                     leContador = n;
              }

              for(int i = leContador - 1;i >= 0;i--) {
                     fseek(arquivo,i * sizeof(double), SEEK_SET);
                     double numero;
                     fread(&numero, sizeof(double),1,arquivo);

                     if(numero == (int)numero) {
                            printf("%d\n",(int) numero);
                     } else {
                            printf("%g\n", numero);
                     }
              }
              fclose(arquivo);
       } 

       int main() {
              int n;
              scanf("%d", &n);

              escreveArquivo(n);
              leArquivoReverso(n);

              return 0;
       }

