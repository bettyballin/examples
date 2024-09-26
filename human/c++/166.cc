cpp
#include <iostream>
#include <vector>

class Source {
public:
    virtual bool Pump(int amount) = 0;
    virtual void PumpAll() = 0;
};

class StringSource : public Source {
public:
    bool Pump(int amount) override {
        return true; // Replace with actual implementation
    }

    void PumpAll() override {
        // Replace with actual implementation
    }
};

int main() {
    const unsigned int threshold = 5;
    std::vector<StringSource*> strSources(threshold);

    for (unsigned int i = 0; i < threshold; i++) {
        strSources[i] = new StringSource();
    }

    while (strSources[0]->Pump(256)) {
        for (unsigned int i = 1; i < threshold; i++) {
            strSources[i]->Pump(256);
        }
    }

    for (unsigned int i = 0; i < threshold; i++) {
        strSources[i]->PumpAll();
    }

    for (unsigned int i = 0; i < threshold; i++) {
        delete strSources[i];
    }

    return 0;
}