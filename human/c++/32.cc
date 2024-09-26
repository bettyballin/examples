cpp
#include <iostream>
#include <string>
#include <cstdint>
#include <sstream>

std::string toHexString(const uint8_t *buf, uint32_t size) 
{ 
  std::stringstream ss;
  for (uint32_t i = 0; i < size; ++i) {
    ss << std::hex << std::setw(2) << std::setfill('0') << static_cast<int>(buf[i]);
  }
  return ss.str();
}

int main() {
  uint8_t buf[] = {0x12, 0x34, 0x56, 0x78};
  std::cout << toHexString(buf, sizeof(buf)) << std::endl;
  return 0;
}