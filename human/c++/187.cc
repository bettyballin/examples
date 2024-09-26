cpp
#include <cryptopp/rsa.h>
#include <cryptopp/randpool.h>
#include <cryptopp/integer.h>
#include <cryptopp/nbtheory.h>
#include <cryptopp/algparam.h>

using namespace CryptoPP;

class InvertibleRSAFunction : public RSAFunction
{
public:
    void GenerateRandom(RandomNumberGenerator &rng, const NameValuePairs &alg)
    {
        int modulusSize = 2048;
        alg.GetIntValue(Name::ModulusSize(), modulusSize) || alg.GetIntValue(Name::KeySize(), modulusSize);

        CRYPTOPP_ASSERT(modulusSize >= 16);
        if (modulusSize < 16)
            throw InvalidArgument("InvertibleRSAFunction: specified modulus size is too small");

        m_e = alg.GetValueWithDefault(Name::PublicExponent(), Integer(17));

        CRYPTOPP_ASSERT(m_e >= 3); CRYPTOPP_ASSERT(!m_e.IsEven());
        if (m_e < 3 || m_e.IsEven())
            throw InvalidArgument("InvertibleRSAFunction: invalid public exponent");

        RSAPrimeSelector selector(m_e);
        AlgorithmParameters primeParam = MakeParametersForTwoPrimesOfEqualSize(modulusSize)
            (Name::PointerToPrimeSelector(), selector.GetSelectorPointer());
        m_p.GenerateRandom(rng, primeParam);
        m_q.GenerateRandom(rng, primeParam);

        m_d = m_e.InverseMod(LCM(m_p-1, m_q-1));
        CRYPTOPP_ASSERT(m_d.IsPositive());

        m_dp = m_d % (m_p-1);
        m_dq = m_d % (m_q-1);
        m_n = m_p * m_q;
        m_u = m_q.InverseMod(m_p);   
    }

    Integer GetPrivateExponent() const { return m_d; }
    Integer GetPublicExponent() const { return m_e; }
    Integer GetModulus() const { return m_n; }

private:
    Integer m_p, m_q, m_n, m_e, m_d, m_dp, m_dq, m_u;
};

int main()
{
    AutoSeededRandomPool rng;
    InvertibleRSAFunction rsa;
    rsa.GenerateRandom(rng, MakeParameters(Name::ModulusSize(), 2048));

    Integer n = rsa.GetModulus();
    Integer e = rsa.GetPublicExponent();
    Integer d = rsa.GetPrivateExponent();

    std::cout << "Modulus: " << n << std::endl;
    std::cout << "Public Exponent: " << e << std::endl;
    std::cout << "Private Exponent: " << d << std::endl;

    return 0;
}