cpp
#include <iostream>
#include <string>

int main() {
    std::string uname = "Linux valkyrie 4.19.4-arch1-1-ARCH #1 SMP PREEMPT Fri Nov 23 09:06:58 UTC 2018 x86_64 GNU/Linux";
    std::string gccVersion = "gcc (GCC) 8.2.1 20180831";

    std::cout << uname << std::endl;
    std::cout << gccVersion << std::endl;

    std::cout << "Copyright (C) 2018 Free Software Foundation, Inc." << std::endl;
    std::cout << "This is free software; see the source for copying conditions.  There is NO" << std::endl;
    std::cout << "warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE." << std::endl;

    return 0;
}