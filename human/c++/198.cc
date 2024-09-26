cpp
#include <iostream>
#include <string>

class Transaction {
public:
    void processConnection(const char* cip, int cport, const char* dip, int dport) {
        std::cout << "Connected from " << cip << ":" << cport << " to " << dip << ":" << dport << std::endl;
    }

    void processURI(const char* uri, const char* method, const char* vers) {
        std::cout << "Request: " << method << " " << uri << " " << vers << std::endl;
    }

    void intervention(int it) {
        std::cout << "Intervention: " << it << std::endl;
    }
};

int main() {
    Transaction* trans = new Transaction();
    std::string cip = "192.168.1.100";
    int cport = 8080;
    std::string dip = "192.168.1.200";
    int dport = 8081;
    std::string uri = "/path/to/resource";
    std::string method = "GET";
    std::string vers = "HTTP/1.1";
    int it = 1;

    // phase 0
    trans->processConnection(cip.c_str(), cport, dip.c_str(), dport);
    trans->processURI(uri.c_str(), method.c_str(), vers.c_str());
    trans->intervention(it);

    delete trans;
    return 0;
}