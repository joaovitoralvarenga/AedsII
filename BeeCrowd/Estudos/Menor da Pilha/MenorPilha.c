#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int minimos[1000000];

int main() {
    char operacao[4];
    int n, V, minimo,topo  = -1;
    

   
    scanf("%d", &n);
    for(int i=0;i<n;i++) {
        scanf("%s", operacao);

        if(strcmp(operacao, "PUSH") == 0) {
            scanf("%d", &V);

            if(topo == -1) {
              minimos[++topo] = V;
            } else {
                minimo = (V < minimos[topo]) ? V : minimos[topo];
                minimos[++topo] = minimo;
            }

           

        } else if(strcmp(operacao, "POP" ) == 0) {
            if(topo == -1) {
                printf("EMPTY\n");
            } else {
                --topo;
            }
        }
        else if(strcmp(operacao, "MIN") == 0) {
            if(topo == -1) {
                printf("EMPTY\n");
            } else {
                printf("%d\n", minimos[topo]);
    
            }
        }
    }
    return 0;
}
