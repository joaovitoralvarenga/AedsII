#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#include <time.h>      

#define MAX_LINES 1000
#define MAX_SHOWS 302
#define MAX_CSV_LINES 1000
#define matricula "872857"

char *csvLines[MAX_CSV_LINES];
int total_linhas_csv = 0;

typedef struct {
    char *dia;
    char *mes;
    char *ano;
} Data;

typedef struct {
    char *show_id;
    char *type;
    char *title;
    char *director;
    char **cast;
    int cast_count;
    char *country;
    Data date_added;         
    int release_year;
    char *rating;
    char *duration;
    char **listed_in;
    int listed_in_count;
} Show;

// Funções auxiliares
char *copy(const char *src) {
    if (src == NULL) return NULL;
    char *dest = malloc(strlen(src) + 1);
    if (dest) strcpy(dest, src);
    return dest;
}

char **split(const char *str, const char *delim, int *count) {
    char *temp = copy(str);
    char *token = strtok(temp, delim);
    int size = 0;
    char **array = NULL;

    while (token) {
        array = realloc(array, (size + 1) * sizeof(char *));
        array[size++] = copy(token);
        token = strtok(NULL, delim);
    }

    *count = size;
    free(temp);
    return array;
}

void ordenarArrayStrings(char **array, int count) {
    for (int i = 0; i < count - 1; i++) {
        for (int j = 0; j < count - i - 1; j++) {
            if (strcmp(array[j], array[j + 1]) > 0) {
                char *tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
            }
        }
    }
}

void liberarArrayStrings(char **array, int count) {
    for (int i = 0; i < count; i++) free(array[i]);
    free(array);
}

Data parseDate(char *str) {
    Data d;
    if (str == NULL || strlen(str) == 0) {
        d.mes = copy("March");
        d.dia = copy("1");
        d.ano = copy("1900");
    } else {
        char *temp = copy(str);
        d.mes = copy(strtok(temp, " "));
        d.dia = copy(strtok(NULL, ","));
        d.ano = copy(strtok(NULL, " "));
        free(temp);
    }
    return d;
}

int converterParaInteiro(const char *str) {
    if (str == NULL || strlen(str) == 0) return 0;
    return atoi(str);
}

// Construtor
Show *new_Show() {
    Show *s = malloc(sizeof(Show));
    s->show_id = s->type = s->title = s->director = s->country = NULL;
    s->cast = NULL;
    s->cast_count = 0;
    s->listed_in = NULL;
    s->listed_in_count = 0;
    s->date_added.dia = s->date_added.mes = s->date_added.ano = NULL;
    s->release_year = 0;
    s->rating = s->duration = NULL;
    return s;
}

// Destrutor
void destruir(Show *s) {
    free(s->show_id);
    free(s->type);
    free(s->title);
    free(s->director);
    liberarArrayStrings(s->cast, s->cast_count);
    free(s->country);
    free(s->date_added.dia);
    free(s->date_added.mes);
    free(s->date_added.ano);
    free(s->rating);
    free(s->duration);
    liberarArrayStrings(s->listed_in, s->listed_in_count);
    free(s);
}

// Getters e Setters
char *getShow_id(Show *s) { return s->show_id; }
void setShow_id(Show *s, const char *value) { s->show_id = copy(value); }

char *getType(Show *s) { return s->type; }
void setType(Show *s, const char *value) { s->type = copy(value); }

char *getTitle(Show *s) { return s->title; }
void setTitle(Show *s, const char *value) { s->title = copy(value); }

char *getDirector(Show *s) { return s->director; }
void setDirector(Show *s, const char *value) { s->director = copy(value); }

char **getCast(Show *s) { return s->cast; }
void setCast(Show *s, const char *value) {
    s->cast = split(value, ",", &s->cast_count);
    ordenarArrayStrings(s->cast, s->cast_count);
}

char *getCountry(Show *s) { return s->country; }
void setCountry(Show *s, const char *value) { s->country = copy(value); }

Data getDate_added(Show *s) { return s->date_added; }
void setDate_added(Show *s, const char *value) { s->date_added = parseDate((char *)value); }

int getRelease_year(Show *s) { return s->release_year; }
void setRelease_year(Show *s, const char *value) { s->release_year = converterParaInteiro(value); }

char *getRating(Show *s) { return s->rating; }
void setRating(Show *s, const char *value) { s->rating = copy(value); }

char *getDuration(Show *s) { return s->duration; }
void setDuration(Show *s, const char *value) { s->duration = copy(value); }

char **getListed_in(Show *s) { return s->listed_in; }
void setListed_in(Show *s, const char *value) {
    s->listed_in = split(value, ",", &s->listed_in_count);
    ordenarArrayStrings(s->listed_in, s->listed_in_count);
}

// clone
Show *clone(Show *s) {
    Show *novo = new_Show();
    setShow_id(novo, s->show_id);
    setType(novo, s->type);
    setTitle(novo, s->title);
    setDirector(novo, s->director);
    setCast(novo, "");  // depois sobrescreve manualmente
    novo->cast = malloc(s->cast_count * sizeof(char *));
    for (int i = 0; i < s->cast_count; i++) {
        novo->cast[i] = copy(s->cast[i]);
    }
    novo->cast_count = s->cast_count;
    setCountry(novo, s->country);
    setDate_added(novo, s->date_added.mes);
    free(novo->date_added.dia);
    free(novo->date_added.mes);
    free(novo->date_added.ano);
    novo->date_added = parseDate(s->date_added.mes);
    novo->date_added.dia = copy(s->date_added.dia);
    novo->date_added.ano = copy(s->date_added.ano);
    setRelease_year(novo, "");
    novo->release_year = s->release_year;
    setRating(novo, s->rating);
    setDuration(novo, s->duration);
    setListed_in(novo, "");
    novo->listed_in = malloc(s->listed_in_count * sizeof(char *));
    for (int i = 0; i < s->listed_in_count; i++) {
        novo->listed_in[i] = copy(s->listed_in[i]);
    }
    novo->listed_in_count = s->listed_in_count;
    return novo;
}

// imprimir
void imprimir(Show *s) {
    printf("%s %s %s %s [", s->show_id, s->type, s->title, s->director);
    for (int i = 0; i < s->cast_count; i++) {
        printf("%s%s", s->cast[i], i < s->cast_count - 1 ? ", " : "");
    }
    printf("] %s %s %s, %s %d %s %s [", s->country, s->date_added.mes, s->date_added.dia, s->date_added.ano,
           s->release_year, s->rating, s->duration);
    for (int i = 0; i < s->listed_in_count; i++) {
        printf("%s%s", s->listed_in[i], i < s->listed_in_count - 1 ? ", " : "");
    }
    printf("]\n");
}

// ler (manual parsing da linha CSV)
void ler(Show *s, const char *linha) {
    char *campos[12];
    char *temp = copy(linha);
    char *token;
    int i = 0;
    token = strtok(temp, ";");

    while (token && i < 12) {
        campos[i++] = token;
        token = strtok(NULL, ";");
    }

    setShow_id(s, campos[0]);
    setType(s, campos[1]);
    setTitle(s, campos[2]);
    setDirector(s, campos[3]);
    setCast(s, campos[4]);
    setCountry(s, campos[5]);
    setDate_added(s, campos[6]);
    setRelease_year(s, campos[7]);
    setRating(s, campos[8]);
    setDuration(s, campos[9]);
    setListed_in(s, campos[10]);

    free(temp);
}

void trim_newline(char *str) {
    str[strcspn(str, "\n")] = '\0';
}


void leArquivo(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        fprintf(stderr, "Error opening file: %s\n", filename);        
        return;
    }


    char linha[MAX_LINES];
    fgets(linha, MAX_LINES, file); // Ignorar cabeçalho
    while (fgets(linha, MAX_LINES, file) && total_linhas_csv < MAX_CSV_LINES) {
        linha[strcspn(linha, "\n")] = '\0'; // Remover newline
        csvLines[total_linhas_csv++] = copy(linha);
    }

    fclose(file);
}




bool ehFim(char *str) {
    return strcmp(str,"FIM") == 0;
}




void comparaTitulos(Show *a, Show *b) {
    return strcmp(getTitle(a), getTitle(b));
}

void ordena(Show **shows, int n) {
    for(int i=0;i < n-1;i++) {
        for(int j = i +1; j < n;j++) {
            if(comparaTitulos(shows[j], shows[j+1]) > 0) {
                Show *temp
            }
        }
    }

}



bool pesquisaBinaria(Show **shows, int n, char *chave) {
    bool encontrado = false;
    int esquerda = 0, direita = n-1;

    while(esquerda <= direita) {
        int meio = (esquerda + direita) / 2;
        int compara = strcmp(getTitle(shows[meio]),chave);

        if(compara == 0) {
            encontrado = true; 
        } else if(compara < 0) {
            esquerda = meio +1;
        } else {
            direita = meio - 1;
        }
    }
    
    return encontrado;
}

int main() {
    char entrada[MAX_LINES];
    Show *shows[MAX_SHOWS];
    int contador;

    leArquivo("/tmp/disneyplus.csv");

    fgets(entrada, MAX_LINES, stdin);
    trim_newline(entrada);
    while(!ehFim) {
        int indice = atoi(entrada);
        if(indice >= 0 && indice < total_linhas_csv) {
            Show *s= new_Show();
            ler(s,csvLines[indice]);
            shows[contador++] = s;
        }

        fgets(entrada, MAX_LINES, stdin);
        trim_newline(entrada);
    }
    




}

