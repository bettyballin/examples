cpp
#include <iostream>
#include <string>
#include <openssl/rsa.h>
#include <openssl/pem.h>

int main() {
    std::string pri_key_str = "-----BEGIN RSA PRIVATE KEY-----\n\
MIIEogIBAAKCAQEAnwOBG9cKqGZhEv3ikSQjrpdEY/qDOB3ZOjoiIT/XJIoPAmXh\n\
i8aAPJ1XgT1enXltvvCmwQDMmcjyAwgKv/215jWN9bcBmRSgTbyJyYCJS4BOs46G\n\
8UKuclXt9JSQGi7ajySdv24qaB+LcchddGIEBtBIWhDx6Je1UxfV9IWk3Ai5zZ5M\n\
e5Ux3mHQz5xUwPncZTN5jBQ3iJTw0Q+NCbHrNZbWKgWEaWJrTGguH1IYVVUcf7qi\n\
PSIPe8jIZeVNVrBkIpX2QYLW2PZxdPPDmFg7dqsTeQRjLwr6grv3arNySMYiU5kQ\n\
VLRyri9FSR5IaqH6tGxjfcNU+7cW3u7gDyD/LwIBAwKCAQBqAlYSj1xwREC3U+xg\n\
wsJ0ZNhCpwIlaTt8JsFrf+TDBrSsQ+uyhFV9vjpWKOm+UPPUoG8rVd2720wCBVx/\n\
/nlEI7P5JKu7YxWJKFvbqwYyVYnNCa9Lgcmhjp6jDbVmyecKGGkqSXGav7JL2uj4\n\
QVgEitrmtfabD843ZTlNrm3oBMQF0rLU888eT/InM424ny0EFjxTARPpEFq0F7jj\n\
95y4FVlHKdAMIhyyUuBe9OEWyl9ALPiIlQNb+5ty1VxF7ZVEJzfwESUzwT9bI+Hj\n\
pYiZAe9vsK/mBYCBJ3X2+qtX56cmCIpk2jnkHFYMnZBrwma108tt3l6Z9kQXBQt2\n\
PNWbAoGBANDyJYvExXkHcxSaElrilWpOG+0cNEGjevgLL54wtQ7e9xGGdJGIo3n4\n\
GmSLrAa9TKrxIMFrKAH/TLEvKyCYnCTpp6lVVRikwUi01rSnm0J0mIZo5VQblgQO\n\
GLrb2yvhFhTV7/WHUFsY7cOQy5EHQKoDYwxkmM31TVQr5A5pbmbVAoGBAMLSvLR3\n\
YgIpdtD6vKVJda6Q9jHzXlgHgXC3vFmDCXFCf7640jrOi8ZI0XkFNr/12OKuVmwF\n\
Gohygq4KeiJVL99Ss3kEFAZmk0m3ZzwbRKwcj6Xolgc6bLWy6AucYEVj1JLEnEs2\n\
HMC/FwClZl7BvbagS6X0XPkfeFyQg0B0V1fzAoGBAItMGQfYg6YE92MRYZHsY5w0\n\
Ep4SzYEXp1AHdRQgeLSUpLZZowuwbPv6vEMHyAR+MxygwIDyGqv/iHYfchW7EsNG\n\
b8Y442XDK4XN5HhvvNb4Za7wmOK9Dq1euyc9PMfrZA3j9U5aNZIQnoJgh7YE1cas\n\
7LLtuzP43jgdQrRGSZnjAoGBAIHh0yL6QVbGTzX8fcOGTnRgpCFM6ZAFAPXP0uZX\n\
W6DW/9R7NtHfB9mF4PtYzyqj5ex0OZ1YvFr3AclcUWw4ypThzPtYDVmZt4Z6RNK8\n\
2HK9tRlFuVom8yPMmrJoQC5CjbctvYd5aIB/ZKsY7unWfnnAMm6i6KYU+uhgV4BN\n\
j4/3AoGACTKWj1cZCKLV7GUnghNooNV5YvOu3xOKGWgoNuey9C6+onFWGXwYbb+N\n\
ArIZraExbCm6OHYfMoR7Zb4rgj5RY9zNoELYQnuTk5MnQJCtzEqEolUuXVAUP8Vn\n\
Xzuh6GkK20/n4PKyIj2ZjN6b534GNPPJYpohhejjdOyetUz4cUI=\n\
-----END RSA PRIVATE KEY-----\n";

    BIO* bo = BIO_new_mem_buf(pri_key_str.c_str(), -1);
    RSA* rsa = PEM_read_bio_RSAPrivateKey(bo, NULL, NULL, NULL);
    if (rsa == NULL) {
        std::cerr << "Failed to load RSA private key." << std::endl;
        return 1;
    }

    // Use the loaded RSA private key
    // ...

    RSA_free(rsa);
    BIO_free(bo);

    return 0;
}