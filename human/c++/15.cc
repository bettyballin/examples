cpp
#include <iostream>
#include <string>
#include <openssl/evp.h>
#include <openssl/pem.h>

class BioBox {
public:
    BioBox() : bio_(BIO_new(BIO_s_mem())) {}
    ~BioBox() { BIO_free(bio_); }

    BIO* Bio() { return bio_; }

    void NewBuffer() { BIO_reset(bio_); }

    struct Buffer {
        char* buf;
        int size;
    };

    Buffer ReadAll() {
        char* buf;
        int size = BIO_get_mem_data(bio_, &buf);
        return { buf, size };
    }

private:
    BIO* bio_;
};

class EvpBox {
public:
    EvpBox(void* keypair) : evp_(keypair) {}

    void* Key() { return evp_; }

private:
    void* evp_;
};

class AccessCard {
public:
    AccessCard() : keypair_(nullptr) {}

    void PrivateKey(std::string& pem, const std::string& passphrase) const {
        CheckKey();
        BioBox bio;
        bio.NewBuffer();

        EvpBox evp(keypair_);
        int ret = PEM_write_bio_PKCS8PrivateKey(bio.Bio(), evp.Key(),
                                                EVP_aes_256_cbc(),
                                                const_cast<char*>(passphrase.c_str()),
                                                passphrase.size(), NULL, NULL);
        if (!ret)
            throw std::runtime_error("Error reading private key");
        const BioBox::Buffer& buf = bio.ReadAll();
        pem = std::string(reinterpret_cast<const char*>(buf.buf), buf.size);
    }

private:
    void CheckKey() { /* implement your key checking logic here */ }
    void* keypair_;
};

int main() {
    AccessCard card;
    std::string pem;
    std::string passphrase = "your_passphrase";
    card.PrivateKey(pem, passphrase);
    std::cout << pem << std::endl;
    return 0;
}