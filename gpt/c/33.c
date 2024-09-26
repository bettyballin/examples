
#include <string.h>

int main() {
    char sensitive_data[] = "This is very sensitive";
    // Use memset_s to securely zero the memory
    memset_s(sensitive_data, sizeof(sensitive_data), 0, sizeof(sensitive_data));
    return 0;
}

