#include <stdbool.h>
#include <stdint.h>

int ArrayMod10BiasDetect(const unsigned char *a, size_t n, bool *biasptr) {
  bool bias = true;
  int mod10 = 0;
  int base = (UINT8_MAX + 1) % 10;  
  for (size_t i = n; i-- > 0;  ) {
    mod10 = (base*mod10 + a[i]) % 10;
    if (n > 0) {
      if (a[i] < UINT8_MAX) bias = false;
    } else {
      if (a[i] < UINT8_MAX + 1 - base) bias = false;
    }
    base = (base * base) % 10;
  }
  *biasptr = bias;
  return mod10;
}