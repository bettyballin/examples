#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* concat(char s[], char t[]){
    int i, j;
    i = j = 0;
    char* u = (char*)malloc(strlen(s) + strlen(t)+1);//new string with enough space for both and \0
    while (s[i] != '\0') {
        u[i]=s[i];
        i++;
   }
    while ((u[i++]=t[j++]) != '\0');
    u[i] = '\0'; // Add null terminator
    return u;
}

int main() {
    char str1[] = "Hello";
    char str2[] = "World";
    char* result = concat(str1, str2);
    printf("%s\n", result);
    free(result);
    return 0;
}