#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>
#include <time.h>


#define MAX_TAM 1000
#define MAX_STR 300


typedef struct  {
    char show_id[MAX_STR];
    char type[MAX_STR];
    char title[MAX_STR];
    char director[MAX_STR];
    char **cast;
    int cast_count;
    char country[MAX_STR];
    struct tm *date_added;
    int release_year;
    char rating[MAX_STR];
    char duration[MAX_STR];
    char **listed_in;
    int listed_in_count;
} Show;


Show* Cria_Shows() {

    Show* show = (Show*) malloc(sizeof(Show));


    strcpy(show ->show_id, "NaN");
    strcpy(show ->type, "NaN");
    strcpy(show ->title, "NaN");
    strcpy(show ->director,"NaN");
    strcpy(show ->country, "NaN");
    strcpy(show ->rating, "NaN");
    strcpy(show ->duration, "NaN");           //Construtor padrão, que define no caso da inexistência de um parâmetro especifíco, o valor que o mesmo
    show ->cast = NULL;                       // já é atribuído.
    show ->cast_count = 0;
    show ->release_year = 0;
    show ->listed_in = NULL;
    show ->listed_in_count = 0;

    memset(&show ->date_added,0,sizeof(struct tm));
    show -> date_added->tm_year = 0;
    show ->date_added->tm_mon = 2;
    show ->date_added->tm_mday = 1;

    return show;
}
