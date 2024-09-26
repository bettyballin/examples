cpp
#include <iostream>
#include <stdexcept>

// Assuming RandomNumberGenerator and MakeParameters are defined elsewhere
class RandomNumberGenerator {};
class Parameters {
public:
    Parameters(const std::string& name, int value) {}
};

class GeneratableCryptoMaterial {
public:
    void GenerateRandom(RandomNumberGenerator &rng, Parameters params) {
        // Assuming this function is defined elsewhere
    }

    void GenerateRandomWithKeySize(RandomNumberGenerator &rng, unsigned int keySize) {
        GenerateRandom(rng, MakeParameters("KeySize", (int)keySize));
    }

private:
    Parameters MakeParameters(const std::string& name, int value) {
        return Parameters(name, value);
    }
};

int main() {
    try {
        RandomNumberGenerator rng;
        GeneratableCryptoMaterial material;
        material.GenerateRandomWithKeySize(rng, 256);
    } catch (const std::exception& e) {
        std::cerr << "Exception caught: " << e.what() << '\n';
    }
    return 0;
}