cpp
#include "filters.h"
#include "osrng.h"
#include "modes.h"
#include "files.h"
#include "aes.h"
using namespace CryptoPP;

#include <iostream>
#include <string>
using namespace std;

int main(int argc, char* argv[])
{
  AutoSeededRandomPool prng;
  string plain = "Now is the time for all good men to come to the aide of their country";
  string cipher, recover;

  SecByteBlock key(AES::DEFAULT_KEYLENGTH), iv(AES::BLOCKSIZE);
  prng.GenerateBlock(key, key.size());
  prng.GenerateBlock(iv, iv.size());

  AES::Encryption aes1(key, key.size());
  CBC_Mode_ExternalCipher::Encryption cbc1(aes1, iv);
  StringSource ss1(plain, true, new StreamTransformationFilter(cbc1, new StringSink(cipher)));

  AES::Decryption aes2(key, key.size());
  CBC_Mode_ExternalCipher::Decryption cbc2(aes2, iv);
  StringSource ss2(cipher, true, new StreamTransformationFilter(cbc2, new StringSink(recover)));

  cout << "Plain: " << plain << endl;
  cout << "Recover: " << recover << endl;

  return 0;
}