pp
#include <iostream>
#include <string>
#include <map>

// Assuming headerType is a std::map
std::map<std::string, std::string> headerType;

// Assuming trans has a method addRequestHeader
class Trans {
public:
    void addRequestHeader(const std::string& key, const std::string& val) {
        // implementation of addRequestHeader
    }
};

int main() {
    Trans* trans = new Trans();

    // populate headerType
    headerType["key1"] = "val1";
    headerType["key2"] = "val2";

    for (auto it = headerType.begin(); it != headerType.end(); ++it) {
        const std::string key = it->first;  // key
        const std::string val = it->second; // val
        trans->addRequestHeader(key, val);
    }

    return 0;
}