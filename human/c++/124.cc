cpp
#include <iostream>

int main() {
    char c = 'q';  // c is you character q for example
    int i;       // i is output number 

    if ((c >= 'a') && (c <= 'z')) 
        i = c - 'a';
    else 
        i = c - 'A';

    std::cout << i << std::endl;

    return 0;
}