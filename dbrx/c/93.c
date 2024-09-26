#include <ctype.h>

int main() {
    char ans[] = "Yes";
    if (tolower((unsigned char) ans[0]) == 'y') {
        // ...
    }
    return 0;
}