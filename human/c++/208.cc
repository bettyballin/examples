cpp
#include <iostream>

int main(void)
{
    int* arr = new int[5];
    int* a = new int;
    delete[] arr;
    delete a;
    return 0;
}