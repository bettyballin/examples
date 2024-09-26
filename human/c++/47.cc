cpp
#include <QString>
#include <iostream>

int main() {
    QString part1 = "ace12";
    QString part2 = "32ef0";
    QString password = part1 + part2;
    std::cout << password.toStdString() << std::endl;
    return 0;
}