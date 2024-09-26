cpp
#include <string>
#include <fstream>
#include <cstdint>

using byte = uint8_t;

class FileSink {
public:
    FileSink(const std::string& filename, bool binary) : file_(filename, binary ? std::ios::binary : std::ios::out) {}

    void Put(const byte* data, size_t size) {
        file_.write(reinterpret_cast<const char*>(data), size);
    }

private:
    std::ofstream file_;
};

class HexDecoder {
public:
    HexDecoder(FileSink* sink) : sink_(sink) {}

    void Put(const byte* data, size_t size) {
        for (size_t i = 0; i < size; ++i) {
            int value;
            sscanf(reinterpret_cast<const char*>(data) + i, "%2x", &value);
            byte b = static_cast<byte>(value);
            sink_->Put(&b, 1);
            ++i; // skip the next character as it's already processed
        }
    }

    void MessageEnd() {}

private:
    FileSink* sink_;
};

int main() {
    std::string dek("30819D300D06092A864886F70D010101050003818B0030818702818100B126088"
                    "1BDFE84463D88C6AB8DB914A2E593893C10508B8A5ABDF692E9A5419A3EDBAE86"
                    "A052849983B75E3B425C18178B260003D857DF0B6505C6CF9C84F5859FCE3B63F"
                    "1FB2D4818501F6C5FA4AD1430EEB081A74ABD74CD1F4AA1FCCA3B88DD0548AED3"
                    "4443CEB52444EAE9099AA4FE66B2E6224D02381C248025C7044079020111");

    FileSink sink("key.der", true);
    HexDecoder decoder(&sink);
    decoder.Put(reinterpret_cast<const byte*>(dek.data()), dek.size());
    decoder.MessageEnd();

    return 0;
}