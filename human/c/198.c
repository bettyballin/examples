#include <iostream>
#include <string>

class Trans {
public:
    void processConnection(const char* cip, int cport, const char* dip, int dport) {
        std::cout << "Processing connection from " << cip << ":" << cport << " to " << dip << ":" << dport << std::endl;
    }

    void processURI(const char* uri, const char* method, const char* vers) {
        std::cout << "Processing URI: " << uri << " with method: " << method << " and version: " << vers << std::endl;
    }

    void intervention(int it) {
        std::cout << "Intervention: " << it << std::endl;
    }
};

int main() {
    std::string cip = "192.168.1.100";
    int cport = 1234;
    std::string dip = "192.168.1.200";
    int dport = 5678;
    std::string uri = "/path/to/resource";
    std::string method = "GET";
    std::string vers = "HTTP/1.1";
    int it = 1;

    Trans trans;
    trans.processConnection(cip.c_str(), cport, dip.c_str(), dport);
    trans.processURI(uri.c_str(), method.c_str(), vers.c_str());
    trans.intervention(it);

    return 0;
}