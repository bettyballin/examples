cpp
#include <iostream>
#include <string>
using namespace std;

void Test(std::string x, int key)
{
    int length = (int)x.length();
    std::cout << "The key is  " << key << endl;
    std::cout << endl;
    for (int j = 0; j < length; j++)
    {
        if (x[j] == ' ')
        {
            x[j] = ' ';
            std::cout << x[j];
        }
        else {
            x[j] = tolower(x[j]);
            x[j] -= 97;
            x[j] -= key;
            if (x[j] < 0)
            {
                x[j] += 26;

            }
            x[j] += 97;
        }
        std::cout << x[j];
    }

    std::cout << endl;
}

int main() {
    std::string x;
    int key;
    cout << "Enter a string: ";
    getline(cin, x);
    cout << "Enter a key: ";
    cin >> key;
    Test(x, key);
    return 0;
}