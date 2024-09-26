cpp
#include <iostream>
#include <cstdlib>
#include <cstdint>

template<typename T>
class t_secure_destruct {
  static const size_t Size = sizeof(T);
  static const size_t Align = alignof(T);
public:
  t_secure_destruct() : d_memory() {
    new(this->d_memory)T;
  }

  ~t_secure_destruct() {
    reinterpret_cast<T*>(this->d_memory)->~T();
    this->scribble();
  }

  t_secure_destruct(const t_secure_destruct& other) : d_memory() {
    new(this->d_memory)T(other.get());
  }

  t_secure_destruct& operator=(const t_secure_destruct& other) {
    if (this != &other) {
      reinterpret_cast<T*>(this->d_memory)->~T();
      new(this->d_memory)T(other.get());
    }
    return *this;
  }

  t_secure_destruct(t_secure_destruct&& other) : d_memory() {
    new(this->d_memory)T(std::move(other.get()));
  }

  t_secure_destruct& operator=(t_secure_destruct&& other) {
    if (this != &other) {
      reinterpret_cast<T*>(this->d_memory)->~T();
      new(this->d_memory)T(std::move(other.get()));
    }
    return *this;
  }

public:
  T& get() {
    return *reinterpret_cast<T*>(this->d_memory);
  }

  const T& get() const {
    return *reinterpret_cast<const T*>(this->d_memory);
  }

private:
  void scribble() {
    for (size_t idx(0); idx < Size; ++idx) {
      this->d_memory[idx] = std::rand() % 256;
    }
  }

private:
  __attribute__((aligned(Align))) char d_memory[Size];
};

int main() {
  t_secure_destruct<int> secure_int;
  secure_int.get() = 10;
  std::cout << "Value: " << secure_int.get() << std::endl;

  t_secure_destruct<int> secure_int2(secure_int);
  std::cout << "Value 2: " << secure_int2.get() << std::endl;

  t_secure_destruct<int> secure_int3;
  secure_int3 = secure_int;
  std::cout << "Value 3: " << secure_int3.get() << std::endl;

  t_secure_destruct<int> secure_int4;
  secure_int4 = std::move(secure_int);
  std::cout << "Value 4: " << secure_int4.get() << std::endl;

  return 0;
}