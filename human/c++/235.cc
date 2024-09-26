cpp
#include <iostream>
#include <string>
#include <bmp_uint1024.h>

bool verify(std::string const& address, std::size_t const stripped_prefix_size)
{
    auto is_address_correct{false};
    
    bmp::uint1024_t const p = bmp::uint1024_t{"0xfffffffffffffffffffffffffffffffffffffffffffffffffffffffefffffc2f"};
    bmp::uint1024_t const a{"0x0000000000000000000000000000000000000000000000000000000000000000"};
    bmp::uint1024_t const b{"0x0000000000000000000000000000000000000000000000000000000000000007"};

    bmp::uint1024_t x{std::string{"0x"} + address.substr(2, address.size() - stripped_prefix_size)};
    bmp::uint1024_t right = (bmp::powm(x, 3, p) + (a * x) + b) % p;     
    bmp::uint1024_t y = bmp::powm(right, (p + 1) / 4, p); // even, i.e. equals the searched y value because of leading 0x02 byte
    bmp::uint1024_t left = bmp::powm(y, 2, p);
 
    std::cout << "x: " << x << std::endl;           // x: 56689369228784262545363082847328735491157691224156776757613891264163121815791
    std::cout << "y: " << y << std::endl;           // y: 113852322045593354727100676608445520152048120867463853258291211042951302108728
    std::cout << "right: " << right << std::endl;   // right: 33769945388650438579771708095049232540048570303667364755388658443270938208149 
    std::cout << "left: " << left << std::endl;     // left: 33769945388650438579771708095049232540048570303667364755388658443270938208149
    is_address_correct = (left == right);

    return is_address_correct;
}

int main() {
    std::string address = "0x1234567890abcdef";
    std::size_t stripped_prefix_size = 2;
    bool result = verify(address, stripped_prefix_size);
    std::cout << "Result: " << result << std::endl;
    return 0;
}