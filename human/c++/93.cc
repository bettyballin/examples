cpp
#include <asio.hpp>

class MyClass {
public:
    MyClass(asio::io_context& io_context) : sock_(io_context) {}

    void writeResponse() {
        std::string response = "OK\r\n\r\n";
        asio::async_write(sock_, asio::buffer(response),
            [this](const asio::error_code& error, std::size_t bytes_transferred) {
                if (error) {
                    // handle error
                }
            });
    }

private:
    asio::ip::tcp::socket sock_;
};

int main() {
    asio::io_context io_context;
    MyClass my_class(io_context);
    my_class.writeResponse();
    io_context.run();
    return 0;
}