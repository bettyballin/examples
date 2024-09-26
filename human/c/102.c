#include <stdio.h>
#include <stdlib.h>

int main() {
  char *a = malloc(100);
  char *b = malloc(200); // Changed to 200 to prevent buffer overflow
  char *c = malloc(100);
  for (int i = 0; i < 200; i++) {
      b[i] = 'Z';
  }
  free(a);
  free(b);
  free(c);
  return 0;
}