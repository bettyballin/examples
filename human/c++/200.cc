cpp
#include <iostream>

class Transaction {
public:
    void processRequestHeaders() {
        std::cout << "Processing request headers..." << std::endl;
    }

    void intervention(void (*it)()) {
        it();
    }
};

void interventionFunction() {
    std::cout << "Intervention function called!" << std::endl;
}

int main() {
    Transaction* trans = new Transaction();
    trans->processRequestHeaders();
    trans->intervention(interventionFunction);

    delete trans;
    return 0;
}