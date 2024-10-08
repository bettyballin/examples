#include <iostream>
#include <boost/algorithm/hex.hpp>
#include <openssl/bn.h>
#include <vector>

int main()
{
    std::string in = "200ec31326d7a933222e3b43a7d6c920a1d2e8a74d1e6f4980ca78b2d9c1aaba6c2ad71f0f1d0cbb40695f27be048982589bccf30066a8735db4a6b0928925077e";
    std::vector<unsigned char> out;
    // convert hex to binary bytes
    boost::algorithm::unhex(in.begin(), in.end(), std::back_inserter(out));
    BIGNUM *eccsig_r = nullptr;
    // convert bytes to a BIGNUM object
    eccsig_r = BN_bin2bn(&out[1], 32, nullptr);
    std::cout << BN_bn2dec(eccsig_r) << std::endl; // print BIGNUM as decimal
    BN_free(eccsig_r); // free the BIGNUM object
    return 0;
}