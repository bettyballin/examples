#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <inttypes.h>

const char base58[] =
    "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

uintmax_t base58_decode(const char *s) {
  printf("<%s>", s);
  uintmax_t val = 0;
  while (*s) {
    const char *pos = strchr(base58, *s);
    if (pos == NULL) {
      printf("\nInvalid <%c>\n", *s);
      exit(-1);
    }
    val = val * 58 + (pos - base58);
    s++;
  }
  printf(" %ju\n", val);
  return val;
}

int main() {
  base58_decode("BukQL");
  base58_decode("BukQLKksdjkL7asSld");  // Error out on 'l'
  return 0;
}