cpp
#include <iostream>

void library_code()
{
    char x;
    char* p = &x;
    *(p - 2) = 23;  
    *(p + 54) = 99; 
}

int main() {
    library_code();
    return 0;
}