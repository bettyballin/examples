cpp
#include <stdio.h>
#include <Shlwapi.h>

#pragma comment(lib, "Shlwapi.lib")

#define HASH_LEN 32

int main(int argc, char* argv[])
{
  const char* data = "foobarbaz";
  unsigned char hash[HASH_LEN] = {0};

  HashData((LPBYTE)data, strlen(data),(LPBYTE)hash, HASH_LEN);

  printf("Hash: ");

  for (int i = 0; i < HASH_LEN; i++) {
    printf("%02x ", hash[i]);
  }

  printf("\n");

  return 0;
}