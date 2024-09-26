cpp
#include <QString>
#include <iostream>

int main() {
    QString part1 = "ace12acaae2b1ccc0e969709665bc62f";
    QString part2 = "32ef031ec4b7ad76b6270bd8c8f971d0";

    QString password = part1.leftRef(5) + part2.leftRef(5);

    std::cout << password.toStdString() << std::endl;

    return 0;
}