#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <time.h>


#define MAX_LINE_SIZE 4096
#define MAX_SHOWS 1000
char **csv_lines = NULL;
int csv_line_count = 0;


typedef struct {
    char show_id[50];
    char type[20];
    char title[200];
    char director[200];
    char **cast;
    int cast_count;
    char country[100];
    struct tm *date_added;
    int release_year;
    char rating[20];
    char duration[50];
    char **listed_in;
    int listed_in_count;
} Show;




void read_file(const char *filename);
void sort_string_array(char **array, int size);
void read_show(Show *show, char *line);
void print_show(Show *show);
bool is_end(char *str);
int convert_str_to_int(char *str);
void free_csv_lines();

void init_show(Show *show) {
    strcpy(show->show_id, "");
    strcpy(show->type, "");
    strcpy(show->title, "");
    strcpy(show->director, "");
    strcpy(show->country, "");                     //Construtor padrão, estruturado para determinar os valores de elementos não parametrizados
    show->cast = NULL;
    show->cast_count = 0;
    show->date_added = NULL;
    show->release_year = 0;
    strcpy(show->rating, "");
    strcpy(show->duration, "");
    show->listed_in = NULL;
    show->listed_in_count = 0;
}


void read_file(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        fprintf(stderr, "Error opening file: %s\n", filename);        
        return;
    }

  
    char buffer[MAX_LINE_SIZE];
    csv_line_count = 0;
    while (fgets(buffer, MAX_LINE_SIZE, file) != NULL) {
        csv_line_count++;
    }

   
    csv_lines = (char **)malloc(csv_line_count * sizeof(char *));
    if (csv_lines == NULL) {
        fprintf(stderr, "Memory allocation error\n");
        fclose(file);
        return;
    }

 
    rewind(file);
    for (int i = 0; i < csv_line_count; i++) {
        if (fgets(buffer, MAX_LINE_SIZE, file) != NULL) {
            // Remove newline character
            buffer[strcspn(buffer, "\n")] = 0;
            
            csv_lines[i] = (char *)malloc((strlen(buffer) + 1) * sizeof(char));
            if (csv_lines[i] == NULL) {
                fprintf(stderr, "Memory allocation error\n");
                fclose(file);
                return;
            }
            strcpy(csv_lines[i], buffer);
        }
    }

    fclose(file);
}

void sort_string_array(char **array, int size) {
    if (array == NULL || size <= 1) return;
    
    for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
            if (array[i] != NULL && array[j] != NULL && strcmp(array[i], array[j]) > 0) {            //Método de ordenação por bubblesort, a fim de organizar alfabeticamente membros do "cast"
                char *temp = array[i];                                                               //e de "listed in"
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}


char* trim(char *str) {
    if (str == NULL) return NULL;
    
 
    while(isspace((unsigned char)*str)) str++;
    
    if(*str == 0) return str; // All spaces
  
    char *end = str + strlen(str) - 1;
    while(end > str && isspace((unsigned char)*end)) end--;
    
 
    *(end + 1) = 0;
    
    return str;
}


char* fix_double_quotes(char *str) {
    if (str == NULL) return NULL;
    
    char *src = str;
    char *dst = str;
    
    while (*src) {
        if (*src == '"' && *(src + 1) == '"') {
            *dst++ = '"';
            src += 2;
        } else {
            *dst++ = *src++;
        }
    }
    *dst = '\0';
    
    return str;
}


char** parse_csv_line(char *line, int *field_count) {
    if (line == NULL || field_count == NULL) return NULL;
    
 
    int expected_fields = 1;
    bool in_quotes = false;
    for (char *p = line; *p; p++) {
        if (*p == '"') {
            in_quotes = !in_quotes;
        } else if (*p == ',' && !in_quotes) {
            expected_fields++;
        }
    }
    
 
    char **fields = (char **)malloc(expected_fields * sizeof(char *));
    if (fields == NULL) return NULL;
    
    
    *field_count = 0;
    
    char *p = line;
    char *field_start = p;
    in_quotes = false;
    
    while (*p) {
        if (*p == '"') {
         
            if (*(p+1) == '"') {
                p += 2; 
            } else {
                in_quotes = !in_quotes;
                p++;
            }
        } else if (*p == ',' && !in_quotes) {
        
            *p = '\0';
            
           
            char *field_value = field_start;
            int field_len = strlen(field_value);
            
            if (field_len >= 2 && *field_value == '"' && *(field_value + field_len - 1) == '"') {
                field_value++;
                *(field_value + field_len - 2) = '\0';
               
                fix_double_quotes(field_value);
            }
            
            fields[(*field_count)++] = strdup(field_value);
            field_start = p + 1;
            p++;
        } else {
            p++;
        }
    }
    
   
    if (field_start) {
     
        int field_len = strlen(field_start);
        if (field_len >= 2 && *field_start == '"' && *(field_start + field_len - 1) == '"') {
            field_start++;
            *(field_start + field_len - 2) = '\0';
           
            fix_double_quotes(field_start);
        }
        
        fields[(*field_count)++] = strdup(field_start);
    }
    
    return fields;
}



char** split_and_sort(const char *str, int *count) {
    if (str == NULL || count == NULL || strlen(str) == 0) {
        *count = 0;
        return NULL;
    }
    

    char *str_copy = strdup(str);
    if (str_copy == NULL) {
        *count = 0;
        return NULL;
    }
    

    fix_double_quotes(str_copy);
    
   
    int max_items = 1;
    for (char *p = str_copy; *p; p++) {
        if (*p == ',') max_items++;
    }
    
  
    char **items = (char **)malloc(max_items * sizeof(char *));
    if (items == NULL) {
        free(str_copy);
        *count = 0;
        return NULL;
    }
    

    int item_count = 0;
    char *token = strtok(str_copy, ",");
    
    while (token != NULL) {
        items[item_count++] = strdup(trim(token));
        token = strtok(NULL, ",");
    }
    
    free(str_copy);
    *count = item_count;
    
   
    sort_string_array(items, item_count);
    
    return items;
}


void read_show(Show *show, char *line) {
    if (show == NULL || line == NULL) return;
    
  
    char *line_copy = strdup(line);
    if (line_copy == NULL) return;
    
 
    int field_count = 0;
    char **fields = parse_csv_line(line_copy, &field_count);
    
 
    if (fields != NULL && field_count >= 11) {
     
        if (fields[0] && strlen(fields[0]) > 0) {
            strcpy(show->show_id, fields[0]);
        }
        
      
        if (fields[1] && strlen(fields[1]) > 0) {
            if (strcasecmp(fields[1], "movie") == 0) {
                strcpy(show->type, "Movie");
            } else {
                strcpy(show->type, "TV Show");
            }
        }
      
        if (fields[2] && strlen(fields[2]) > 0) {
            char *cleaned_title = strdup(fields[2]);
            
         
            char *src = cleaned_title;
            char *dst = cleaned_title;
            
            while (*src) {
                if (*src != '"') {
                    *dst++ = *src;
                }
                src++;
            }
            *dst = '\0';
            
            strcpy(show->title, cleaned_title);
            free(cleaned_title);
        }
        
  
        if (fields[3] && strlen(fields[3]) > 0) {
            strcpy(show->director, fields[3]);
        }
        
     
        if (fields[4] && strlen(fields[4]) > 0) {
            show->cast = split_and_sort(fields[4], &show->cast_count);
        } else {
            show->cast = NULL;
            show->cast_count = 0;
        }
        
   
        if (fields[5] && strlen(fields[5]) > 0) {
            strcpy(show->country, fields[5]);
        }
        
      
        if (fields[6] && strlen(fields[6]) > 0) {
            show->date_added = (struct tm *)malloc(sizeof(struct tm));
            if (show->date_added != NULL) {
                memset(show->date_added, 0, sizeof(struct tm));
                
               
                char month_str[20] = {0};
                int day = 0, year = 0;
                
                sscanf(fields[6], "%19s %d, %d", month_str, &day, &year);
                
                
                const char *months[] = {"January", "February", "March", "April", "May", "June", 
                                       "July", "August", "September", "October", "November", "December"};
                int month = 0;
                for (int i = 0; i < 12; i++) {
                    if (strstr(month_str, months[i]) != NULL) {
                        month = i;
                        break;
                    }
                }
                
                show->date_added->tm_year = year - 1900;
                show->date_added->tm_mon = month;
                show->date_added->tm_mday = day;
            }
        } else {
            show->date_added = NULL;
        }
        
     
        if (fields[7] && strlen(fields[7]) > 0) {
            show->release_year = atoi(fields[7]);
        }
        
        
        if (fields[8] && strlen(fields[8]) > 0) {
            strcpy(show->rating, fields[8]);
        }
        
        
        if (fields[9] && strlen(fields[9]) > 0) {
            strcpy(show->duration, fields[9]);
        }
        
      
        if (fields[10] && strlen(fields[10]) > 0) {
            show->listed_in = split_and_sort(fields[10], &show->listed_in_count);
        } else {
            show->listed_in = NULL;
            show->listed_in_count = 0;
        }
        
    
        for (int i = 0; i < field_count; i++) {
            if (fields[i] != NULL) {
                free(fields[i]);
            }
        }
        free(fields);
    }
    
    free(line_copy);
}


void print_show(Show *show) {
    if (show == NULL) return;
    
    printf("=> %s ## %s ## %s ## ", 
           show->show_id, 
           show->title, 
           show->type);
    
 
    if (strlen(show->director) == 0) {
        printf("NaN ## ");
    } else {
        printf("%s ## ", show->director);
    }
    

    if (show->cast_count == 0 || show->cast == NULL) {
        printf("[NaN] ## ");
    } else {
        printf("[");
        for (int i = 0; i < show->cast_count; i++) {
            if (show->cast[i] != NULL) {
                printf("%s", show->cast[i]);
                if (i < show->cast_count - 1) printf(", ");
            }
        }
        printf("] ## ");
    }
    

    if (strlen(show->country) == 0) {
        printf("NaN ## ");
    } else {
        printf("%s ## ", show->country);
    }
    
  
    if (show->date_added == NULL) {
        printf("March 1, 1900 ## ");
    } else {
        const char *months[] = {"January", "February", "March", "April", "May", "June", 
                               "July", "August", "September", "October", "November", "December"};
        printf("%s %d, %d ## ", 
               months[show->date_added->tm_mon],
               show->date_added->tm_mday,
               show->date_added->tm_year + 1900);
    }
    
 
    printf("%d ## %s ## %s ## ", 
           show->release_year, 
           show->rating, 
           show->duration);
    
  
    if (show->listed_in_count == 0 || show->listed_in == NULL) {
        printf("[NaN] ##");
    } else {
        printf("[");
        for (int i = 0; i < show->listed_in_count; i++) {
            if (show->listed_in[i] != NULL) {
                printf("%s", show->listed_in[i]);
                if (i < show->listed_in_count - 1) printf(", ");
            }
        }
        printf("] ##");
    }
    
    printf("\n");
}


void free_show(Show *show) {
    if (show == NULL) return;
    
    // Free cast array
    if (show->cast != NULL) {
        for (int i = 0; i < show->cast_count; i++) {
            if (show->cast[i] != NULL) {
                free(show->cast[i]);
            }
        }
        free(show->cast);
        show->cast = NULL;
    }
    

    if (show->listed_in != NULL) {
        for (int i = 0; i < show->listed_in_count; i++) {
            if (show->listed_in[i] != NULL) {
                free(show->listed_in[i]);
            }
        }
        free(show->listed_in);
        show->listed_in = NULL;
    }
    
 
    if (show->date_added != NULL) {
        free(show->date_added);
        show->date_added = NULL;
    }
}


void free_csv_lines() {
    if (csv_lines == NULL) return;
    
    for (int i = 0; i < csv_line_count; i++) {
        if (csv_lines[i] != NULL) {
            free(csv_lines[i]);
        }
    }
    free(csv_lines);
    csv_lines = NULL;
}


bool is_end(char *str) {
    return (str != NULL && strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
}


int convert_str_to_int(char *str) {
    if (str == NULL || strlen(str) == 0) return 0;
    
    int value = 0;
    for (int i = 0; i < strlen(str); i++) {
        if (isdigit(str[i])) {
            value = value * 10 + (str[i] - '0');
        }
    }
    
    return value;
}

int main() {
    char input[100];
    Show shows[MAX_SHOWS];
    int count = 0;
    

    read_file("/tmp/disneyplus.csv");
    

    if (fgets(input, sizeof(input), stdin) != NULL) {
        input[strcspn(input, "\n")] = 0; // Remove newline
        
        while (!is_end(input)) {
            int index = convert_str_to_int(input);
            
            if (index >= 0 && index < csv_line_count && csv_lines != NULL && csv_lines[index] != NULL) {
                init_show(&shows[count]);
                read_show(&shows[count], csv_lines[index]);
                count++;
            }
            
            if (fgets(input, sizeof(input), stdin) == NULL) break;
            input[strcspn(input, "\n")] = 0; // Remove newline
        }
        
     
        for (int i = 0; i < count; i++) {
            print_show(&shows[i]);
            free_show(&shows[i]);
        }
        
        free_csv_lines();
    }
    
    return 0;
}