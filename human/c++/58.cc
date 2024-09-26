cpp
#include <algorithm>
#include <iostream>

int main() {
    int i_s_len = 10; // replace with actual length
    char* pSig = new char[i_s_len]; // replace with actual data

    std::reverse(pSig, pSig + i_s_len); // need to convert to little endian for WinCrypt

    delete[] pSig;
    return 0;
}