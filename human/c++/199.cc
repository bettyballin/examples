cpp
#include <iostream>
#include <string>
#include <map>

// assuming headerType is a map
typedef std::map<std::string, std::string> headerType;

class Transaction {
public:
    void addRequestHeader(const std::string& key, const std::string& val) {
        // implement your logic here
        std::cout << "Adding header: " << key << ": " << val << std::endl;
    }
};

int main() {
    headerType header;
    header["Content-Type"] = "application/json";
    header["Authorization"] = "Bearer token";

    Transaction* trans = new Transaction();

    for(auto it = header.begin(); it != header.end(); ++it) {
        const std::string key = it->first;  // key
        const std::string val = it->second; // val
        trans->addRequestHeader(key, val);
    }

    delete trans;
    return 0;
}