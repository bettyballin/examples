cpp
#include <iostream>

typedef unsigned long long ull;

ull const M  = 10000000000ull;

ull pow_mod10_10(ull n, ull p) {
  ull const m2 = 1024;    // 2^10
  ull const m5 = 9765625; // 5^10
  ull const M2 = 9765625; // 5^10 = M / m2
  ull const M5 = 1024;    // 2^10 = M / m5
  ull const u2 = 841;     // u2*M2 = 1 mod m2
  ull const u5 = 1745224; // u5*M5 = 1 mod m5

  ull b2 = 1;
  ull b5 = 1;
  ull n2 = n % m2;
  ull n5 = n % m5;

  while(p) {
    if(p%2 == 1) {
      b2 = (b2*n2)%m2;
      b5 = (b5*n5)%m5;
    }
    n2 = (n2*n2)%m2;
    n5 = (n5*n5)%m5;
    p /= 2;
  }

  ull np = (((b2*u2)%M)*M2)%M;
  np    += (((b5*u5)%M)*M5)%M;
  np    %= M;
  return np;
}

int main() {
  ull n, p;
  std::cout << "Enter base: ";
  std::cin >> n;
  std::cout << "Enter exponent: ";
  std::cin >> p;
  std::cout << "Result: " << pow_mod10_10(n, p) << std::endl;
  return 0;
}