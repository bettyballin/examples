cpp
#include <iostream>
#include <string>
#include <bitset>
#include <cstdlib> // added for atoi

int main()
{
    std::string strNumber = "20";
    int number = std::atoi(strNumber.c_str());
    std::string s = std::bitset<64>(number).to_string(); // string conversion
    std::cout << s << std::endl;
    
    return 0;
}