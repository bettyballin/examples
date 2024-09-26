#include <limits.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

int ArrayMod10(const unsigned char *a, size_t n) {
  int mod10 = 0;
  int base = (UCHAR_MAX + 1) % 10;
  for (size_t i = n; i-- > 0;  ) {
    mod10 = (base*mod10 + a[i]) % 10;
    base = (base * base) % 10;
  }
  return mod10;
}

int test10(size_t n) {
  unsigned char a[n];

  // seed random number generator
  srand(time(NULL));

  // fill array with random numbers
  for (size_t i = 0; i < n; i++) a[i] = rand() % 256;

  return ArrayMod10(a, n) + 1;
}

int main() {
  size_t n = 10; // choose a size
  int result = test10(n);
  printf("Result: %d\n", result);
  return 0;
}