cpp
#include <iostream>
#include <cstdlib>

int main() {
    // Setting MALLOC_CHECK_ to 0, 1, 2, or 3
    setenv("MALLOC_CHECK_", "0", 1); // Silently ignore any issues

    // Example usage
    void* ptr = malloc(10);
    free(ptr);

    // Setting MALLOC_CHECK_ to 1
    setenv("MALLOC_CHECK_", "1", 1); // Send error message to stderr

    // Example usage
    ptr = malloc(10);
    free(ptr);
    free(ptr); // This will send an error message to stderr

    // Setting MALLOC_CHECK_ to 2
    setenv("MALLOC_CHECK_", "2", 1); // abort() is called immediately

    // Example usage
    ptr = malloc(10);
    free(ptr);
    free(ptr); // This will call abort() immediately

    // Setting MALLOC_CHECK_ to 3
    setenv("MALLOC_CHECK_", "3", 1); // Do both '1' and '2'

    // Example usage
    ptr = malloc(10);
    free(ptr);
    free(ptr); // This will send an error message to stderr and call abort()

    return 0;
}