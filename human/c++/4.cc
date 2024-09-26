cpp
#include <iostream>

class myclass {
private:
    int x;

public:
    myclass() : x(0) {}

    // delete copy constructor
    myclass(const myclass&) = delete;

    // delete assignment operator
    myclass& operator=(const myclass&) = delete;
};

int main() {
    myclass m;
    // myclass m2(m); // error: use of deleted function 'myclass::myclass(const myclass&)'
    myclass m3;
    // m3 = m; // error: use of deleted function 'myclass& myclass::operator=(const myclass&)'

    return 0;
}