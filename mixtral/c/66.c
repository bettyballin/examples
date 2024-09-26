#include <stdio.h>
#include <stdlib.h>
#define MAX_SIZE 1024

void concat(char s[], char t[]) {
    int i = 0;

    // Copy the first string
    while (s[i] != '\0')
        ++i;

    // Concatenate second string
    for (int j=0 ; t[j]; )
       s[i++] = t[j++];

   // Null terminate
   s[i]='\0';
}

int main() {

     char a[MAX_SIZE] = "hello ";
     char b[] = "world";

    concat(a, b);

    printf("%s\n", a);

  return EXIT_SUCCESS;

}