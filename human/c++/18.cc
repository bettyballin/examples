cpp
#include <iostream>

class Resource {
public:
    void acquire() {
        std::cout << "Resource acquired." << std::endl;
    }

    void release() {
        std::cout << "Resource released." << std::endl;
    }

    void doStuff() {
        std::cout << "Doing stuff..." << std::endl;
        // Simulating an exception
        throw std::runtime_error("Something went wrong.");
    }
};

int main() {
    Resource resource;
    try {
        resource.acquire();
        resource.doStuff();
    } catch (const std::exception& e) {
        std::cerr << e.what() << std::endl;
    }
    resource.release();
    return 0;
}