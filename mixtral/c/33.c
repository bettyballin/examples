#include <stdint.h>
#include <string.h>

uint32_t jenkins_one_at_a_time(const char *key, uint64_t len) {
    uint32_t hash = 0;

    for (size_t i=0 ; i<len ; ++i )
        hash += key[i];

    // Mix the bits
    hash ^= ((hash >> 17) | (hash << 15));

    return hash + (uint32_t)len * 3;
}

int main() {
    const char *key = "Hello, World!";
    uint64_t len = strlen(key);
    uint32_t hash = jenkins_one_at_a_time(key, len);
    return 0;
}