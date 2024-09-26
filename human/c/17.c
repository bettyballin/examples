#include <stdbool.h>
#include <stdint.h>

#define DES_BLOCKSIZE 8

bool AdjustDESKeyParity(uint8_t* pucKey, int nKeyLen)
{
   int cPar;
   for(int i = 0; i < nKeyLen; i++)
   {
      cPar = 0;
      for(int j = 0; j < DES_BLOCKSIZE; j++)
      {
         if(pucKey[i] & (0x01 << j))
            cPar = !cPar;
      }
      if(!cPar)
         pucKey[i] ^= 0x01;
   }
   return true;
}

int main() {
    uint8_t key[] = {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08};
    int keyLen = sizeof(key);
    AdjustDESKeyParity(key, keyLen);
    return 0;
}