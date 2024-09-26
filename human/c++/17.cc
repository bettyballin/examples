cpp
#include <string>
#include <windows.h>

namespace secure
{
  template <class T> class allocator : public std::allocator<T>
  {
  public:

    template<class U> struct rebind { typedef allocator<U> other; };
    allocator() throw() {}
    allocator(const allocator &) throw() {}
    template <class U> allocator(const allocator<U>&) throw() {}

    void deallocate(pointer p, size_type num)
    {
      SecureZeroMemory((void *)p, num);
      std::allocator<T>::deallocate(p, num);
    }
  };

  typedef std::basic_string<char, std::char_traits<char>, allocator<char> > string;
}

int main()
{
  {
    secure::string bar("bar");
    secure::string longbar("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaar");
  }
  return 0;
}