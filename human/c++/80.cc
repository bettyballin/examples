cpp
#include <iostream>
#include <string>

class Integer {
public:
    Integer(int value) : value_(value) {}
    int GetValue() const { return value_; }

private:
    int value_;
};

class Params {
public:
    void SetModulus(const Integer& n) { modulus_ = n; }
    void SetPrime1(const Integer& p) { prime1_ = p; }
    void SetPrime2(const Integer& q) { prime2_ = q; }
    void SetPrivateExponent(const Integer& d) { private_exponent_ = d; }
    void SetPublicExponent(const Integer& e) { public_exponent_ = e; }

    const Integer& GetModulus() const { return modulus_; }
    const Integer& GetPrime1() const { return prime1_; }
    const Integer& GetPrime2() const { return prime2_; }
    const Integer& GetPrivateExponent() const { return private_exponent_; }
    const Integer& GetPublicExponent() const { return public_exponent_; }

private:
    Integer modulus_;
    Integer prime1_;
    Integer prime2_;
    Integer private_exponent_;
    Integer public_exponent_;
};

int main() {
    Params params;
    params.SetModulus(Integer(10));
    params.SetPrime1(Integer(2));
    params.SetPrime2(Integer(5));
    params.SetPrivateExponent(Integer(3));
    params.SetPublicExponent(Integer(7));

    const Integer& n = params.GetModulus();
    const Integer& p = params.GetPrime1();
    const Integer& q = params.GetPrime2();
    const Integer& d = params.GetPrivateExponent();
    const Integer& e = params.GetPublicExponent();

    std::cout << "n: " << n.GetValue() << std::endl;
    std::cout << "p: " << p.GetValue() << std::endl;
    std::cout << "q: " << q.GetValue() << std::endl;
    std::cout << "d: " << d.GetValue() << std::endl;
    std::cout << "e: " << e.GetValue() << std::endl;

    return 0;
}