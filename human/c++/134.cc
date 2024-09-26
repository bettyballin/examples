cpp
#include <iostream>
using namespace std;

long long power(long long x, long long y, long long M) {
    long long res = 1;
    x = x % M;
    while (y > 0) {
        if (y & 1)
            res = (res * x) % M;
        y = y >> 1;
        x = (x * x) % M;
    }
    return res;
}

int main() {
    long long x = 2; // example value
    long long M = 1000000007; // example modulus
    long long res1 = power(x, 11, M);
    long long temp1 = power(x, 1, M);
    long long temp2 = power(x, 2, M);
    long long temp3 = (temp1 * temp2) % M;
    long long temp4 = power(x, 8, M);
    long long res2 = (temp3 * temp4) % M;
    cout << (res1 == res2) << endl; // 1 means true
    return 0;
}