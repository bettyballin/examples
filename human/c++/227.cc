cpp
#include <iostream>

class BufferedTransformation {
public:
    virtual void write(const unsigned char* data, size_t size) = 0;
};

class Point {
public:
    unsigned char x[32];
    unsigned char y[32];
};

class ECP {
public:
    void EncodePoint(BufferedTransformation &bt, const Point &P, bool compressed) {
        if (compressed) {
            unsigned char buffer[33];
            buffer[0] = 2 + (P.y[31] & 1);
            memcpy(buffer + 1, P.x, 32);
            bt.write(buffer, 33);
        } else {
            unsigned char buffer[65];
            buffer[0] = 4;
            memcpy(buffer + 1, P.x, 32);
            memcpy(buffer + 33, P.y, 32);
            bt.write(buffer, 65);
        }
    }
};

class ConcreteBufferedTransformation : public BufferedTransformation {
public:
    void write(const unsigned char* data, size_t size) override {
        for (size_t i = 0; i < size; ++i) {
            std::cout << std::hex << (int)data[i];
        }
    }
};

int main() {
    ECP ecp;
    Point point;
    ConcreteBufferedTransformation cbt;
    ecp.EncodePoint(cbt, point, true);
    return 0;
}