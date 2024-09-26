#include <stdio.h>
#include <string.h>
#include <stdlib.h>

enum {SIZE = 50};

char target_1 = 'Z';
char name[SIZE] = "Help";
char target_2 = 'Z';

static void read(char *s)
{
   char buffer[2*SIZE];
   int i = 0; 
   int c;

   while ((c = getchar()) != EOF && c != '\n')
      buffer[i++] = c;
   buffer[i] = '\0';

   for (int j = 0; j < i; j++) 
      s[j] = buffer[j];
   s[i] = '\0';
}


int main(void) 
{
   printf("Data-1: %c %s %c\n", target_1, name, target_2);
   read(name);
   printf("Data-2: %c %s %c\n", target_1, name, target_2);
   return(0);
}