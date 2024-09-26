cpp
#include <iostream>
using namespace std;

long long powmod(long long x, long long n, long long m) {
    if (n == 0) return 1;
    if (n == 1) return x % m;
    long long temp = powmod(x, n / 2, m);
    temp = temp * temp % m;
    if (n % 2 == 1) return temp * x % m;
    return temp;
}

int main() {
    long long x, m;
    cout << "Enter base (x): ";
    cin >> x;
    cout << "Enter modulus (m): ";
    cin >> m;
    long long result = powmod(x, 65537, m);
    cout << x << "^65537 mod " << m << " = " << result << endl;
    return 0;
}