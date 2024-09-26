#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <stdlib.h>

// md5 hash implementation
void md5_hash(const uint8_t *data, size_t len, uint8_t *digest) {
  uint32_t h[4] = {0x67452301, 0xefcdab89, 0x98badcfe, 0x10325476};
  uint32_t w[16];

  for (size_t i = 0; i < len; i += 64) {
    for (int j = 0; j < 16; j++) {
      w[j] = ((uint32_t*)data)[i / 4 + j];
    }

    uint32_t a = h[0], b = h[1], c = h[2], d = h[3];
    for (int i = 0; i < 64; i++) {
      uint32_t f, g;

      if (i < 20) {
        f = (b & c) | ((~b) & d);
        g = i;
      } else if (i < 40) {
        f = (b ^ c ^ d);
        g = (5 * i + 1) % 16;
      } else if (i < 60) {
        f = (b & c) | (b & d) | (c & d);
        g = (3 * i + 5) % 16;
      } else {
        f = (b ^ c ^ d);
        g = (7 * i) % 16;
      }

      f = (f + a + w[g]) & 0xffffffff;
      a = d;
      d = c;
      c = b;
      b = (b + (f << 3) - (f >> 29)) & 0xffffffff;
    }

    h[0] = (h[0] + a) & 0xffffffff;
    h[1] = (h[1] + b) & 0xffffffff;
    h[2] = (h[2] + c) & 0xffffffff;
    h[3] = (h[3] + d) & 0xffffffff;
  }

  for (int i = 0; i < 4; i++) {
    digest[i * 4] = (h[i] >> 24) & 0xff;
    digest[i * 4 + 1] = (h[i] >> 16) & 0xff;
    digest[i * 4 + 2] = (h[i] >> 8) & 0xff;
    digest[i * 4 + 3] = h[i] & 0xff;
  }
}

int main() {
  uint8_t digest[16];
  char str1[] = "12345";
  char str2[] = "12345";

  md5_hash((uint8_t*)str1, strlen(str1), digest);
  printf("MD5 (str1) = ");
  for (int i = 0; i < 16; i++) {
    printf("%02x", digest[i]);
  }
  printf("\n");

  md5_hash((uint8_t*)str2, strlen(str2), digest);
  printf("MD5 (str2) = ");
  for (int i = 0; i < 16; i++) {
    printf("%02x", digest[i]);
  }
  printf("\n");

  return 0;
}