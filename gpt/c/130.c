
#include <ctype.h> // for isupper and islower

char cypher_charac(char charac, int key) {
    if (islower(charac)) {
        // Ensure the value is non-negative before modulo operation
        charac = 'a' + (26 + (charac - 'a' + key) % 26) % 26;
        return charac;
    } else if (isupper(charac)) {
        // Ensure the value is non-negative before modulo operation
        charac = 'A' + (26 + (charac - 'A' + key) % 26) % 26;
        return charac;
    } else {
        return charac;
