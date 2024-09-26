cpp
#include <iostream>
#include <string>
#include <cstdint>
#include <arpa/inet.h>
#include <gmpxx.h>

void writeZZ(std::ostream& os, const mpz_class& a) {
  uint32_t size = htonl(a.get_n().size());
  std::string buf(size, 0);
  mpz_export((void*)buf.data(), NULL, 1, 1, 1, 0, a.get_n());
  os.write((char*)&size, sizeof(uint32_t));
  os.write(buf.data(), size);
}

mpz_class readZZ(std::istream& is) {
  uint32_t size;
  is.read((char*)&size, sizeof(uint32_t));
  size = ntohl(size);
  std::string buf(size, 0);
  is.read(buf.data(), size);
  mpz_class result;
  mpz_import(result.get_n(), size, 1, 1, 1, 0, (void*)buf.data());
  return result;
}

int main() {
  mpz_class value = 1234567890123456789_mpz;
  std::stringstream ss;
  writeZZ(ss, value);
  std::cout << "Written value: " << ss.str() << std::endl;
  mpz_class readValue;
  ss.seekg(0);
  readValue = readZZ(ss);
  std::cout << "Read value: " << readValue << std::endl;
  return 0;
}