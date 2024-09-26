cpp
#include <boost/asio.hpp>
#include <boost/bind/bind.hpp>
#include <iostream>

class SecureBuffer {
public:
    SecureBuffer(const std::string& data) : data_(data) {}

    const char* data() const { return data_.c_str(); }
    size_t size() const { return data_.size(); }

private:
    std::string data_;
};

class AsyncWriter {
public:
    AsyncWriter(boost::asio::io_service& io_service)
        : sock_(io_service) {}

    void set_data(const std::string& data) { secret_.reset(new SecureBuffer(data)); }

    void write() {
        boost::asio::async_write(sock_,
            boost::asio::buffer(secret_->data(), secret_->size()),
            boost::bind(&AsyncWriter::handle_write, this, boost::asio::placeholders::error));
    }

    void handle_write(const boost::system::error_code& ec) {
        if (ec) std::cerr << "Error: " << ec.message() << std::endl;
        else std::cout << "Write successful" << std::endl;
    }

private:
    boost::asio::ip::tcp::socket sock_;
    std::unique_ptr<SecureBuffer> secret_;
};

int main() {
    boost::asio::io_service io_service;
    AsyncWriter writer(io_service);

    writer.set_data("Hello, world!");
    writer.write();

    io_service.run();

    return 0;
}