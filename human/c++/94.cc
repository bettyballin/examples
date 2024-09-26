cpp
#include <array>
#include <iostream>
#include <windows.h>

struct SecureBuffer
{
    ~SecureBuffer() { shred(); }
    size_t      size() const { return length_; }
    char const* data() const { return data_.data(); }

    void write(const char* data, size_t length) {
        if (length > data_.size()) {
            throw std::runtime_error("Buffer overflow");
        }
        std::copy(data, data + length, data_.begin());
        length_ = length;
    }

private:
    void shred() {
        SecureZeroMemory(data_.data(), data_.size());
    }

    std::array<char, 1024> data_ = {0};
    size_t length_ = 0u;
};

int main() {
    SecureBuffer buffer;
    buffer.write("Hello, World!", 13);
    std::cout << "Buffer size: " << buffer.size() << std::endl;
    std::cout << "Buffer data: " << buffer.data() << std::endl;
    return 0;
}