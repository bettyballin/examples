cpp
#include <fstream>
#include <string>

class DataSink_Stream {
public:
    DataSink_Stream(const std::string& pathname, bool use_binary = false) {
        if (use_binary) {
            file_.open(pathname, std::ios::binary);
        } else {
            file_.open(pathname);
        }

        if (!file_.is_open()) {
            // handle error
        }
    }

    ~DataSink_Stream() {
        file_.close();
    }

private:
    std::ofstream file_;
};