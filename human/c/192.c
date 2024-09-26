#include <stdio.h>

int main() {
    unsigned char result[] = {0x12, 0x34, 0x56, 0x78};
    int resultlen = sizeof(result);

    for (unsigned int i = 0; i < resultlen; i++){
      printf("%02hhX", result[i]); 
    }
    return 0;
}