#include <stdio.h>

// Define some_type and another_type for demonstration purposes
typedef int some_type;
typedef int another_type;

some_type function_name(another_type parameter_name) {
    // Example function body, replace with actual implementation
    return parameter_name;
}

int main() {
    another_type value = 10;
    some_type result = function_name(value);
    printf("Result: %d\n", result);
    return 0;
}