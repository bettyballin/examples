cpp
#include <iostream>
using namespace std;

enum InputOutputType {
    DisplayOnly = 0,
    DisplayYesNo = 1,
    KeyboardOnly = 2,
    NoInputNoOutput = 3,
    KeyboardDisplay = 4
};

int main() {
    cout << "0\tDisplayOnly" << endl;
    cout << "1\tDisplayYesNo" << endl;
    cout << "2\tKeyboardOnly" << endl;
    cout << "3\tNoInputNoOutput" << endl;
    cout << "4\tKeyboardDisplay" << endl;
    return 0;
}