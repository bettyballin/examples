cpp
#include <iostream>
using namespace std;

int main() {
    int MX = 10;
    int v[] = {1, 2, 3, 4, 5};
    int p = 2;
    int y;

    v[p] -= MX; 
    y = v[p];

    cout << "y: " << y << endl;

    return 0;
}