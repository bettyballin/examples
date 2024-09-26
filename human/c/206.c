#include <stdio.h>
#include <stdlib.h>

typedef unsigned short int UINT16;

const UINT16 sbox_table[16] = {0xE, 0x4, 0xD, 0x1, 0x2, 0xF, 0xB, 0x8, 0x3, 0xA,
    0x6, 0xC, 0x5, 0x9, 0x0, 0x7};

int lin_appr_table[16][16];

unsigned count1(unsigned i) {
  unsigned count = 0;
  while (i) {
    count += i & 1;
    i >>= 1;
  }
  return count;
}

void construct_lin_appr_table() {
  UINT16 i, j, k;
  UINT16 X, Y;
  UINT16 X_xor, Y_xor;
  int counter;

  for (i = 0; i < 16; i++) {
    for (j = 0; j < 16; j++) {
      X = i;
      Y = j;

      counter = 0;
      for (k = 0; k < 16; k++) {
        X_xor = X & k;
        Y_xor = Y & sbox_table[k];

        if ((count1(X_xor ^ Y_xor) & 1) == 0)
          counter++;
      }
      lin_appr_table[i][j] = counter - 8;
    }
  }

  for (i = 0; i < 16; i++) {
    for (j = 0; j < 16; j++) {
      printf("%d ", lin_appr_table[i][j]);
    }
    printf("\n");
  }
}

int main() {
  construct_lin_appr_table();
  return 0;
}