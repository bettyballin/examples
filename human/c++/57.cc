cpp
#include <algorithm>
#include <cstdint>

struct AlgoSpecific {
    struct RSA {
        uint8_t s[1024];
    } rsa;
} p_sig;

int main() {
    int i_s_len = 1024; // assuming a fixed size for demonstration purposes
    std::reverse(p_sig.algo_specific.rsa.s, p_sig.algo_specific.rsa.s + i_s_len);
    return 0;
}