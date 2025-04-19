fgets(entrada,MAX_LINES,stdin);
trim_newline(entrada);
while(!ehFim(entrada)) {
    if(pesquisaBinaria(shows,contador,entrada)) {
        printf("SIM\n");
    } else {
        printf("NAO\n");
    }
    fgets(entrada, MAX_LINES, stdin);
    trim_newline(entrada);
}

for (int i = 0; i < contador; i++) {
    destruir(&shows[i]);
}

for (int i = 0; i < total_linhas_csv; i++) {
    free(csvLines[i]);
}
