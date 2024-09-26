cpp
#include <iostream>

template <typename T>
class t_secure_destruct {
public:
  t_secure_destruct() : ptr_(new T()) {}

  ~t_secure_destruct() {
    delete ptr_;
  }

  T& get() {
    return *ptr_;
  }

private:
  T* ptr_;
};

class t_test {
public:
  t_test() : a(-1) {
    std::cout << "construct\n";
  }

  ~t_test() {
    std::cout << "destruct\n";
  }

public:
  void print() const {
    std::cout << "a = " << a << "\n";
  }

public:
  int a;
};

int main(int argc, const char* argv[]) {
  t_secure_destruct<t_test> test;
  test.get().print();
  test.get().a = 100;
  test.get().print();
  return 0;
}