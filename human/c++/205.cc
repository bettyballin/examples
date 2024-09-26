cpp
#include <iostream>
#include <vector>
#include <string>

// Secure erazing of memory macro for Windows and non-Windows systems
#if defined(_WIN32)
#include <windows.h>
#define secure_zeromem(mem,size) do { RtlSecureZeroMemory (mem, size); } while (0)
#else
#define secure_zeromem(mem,size) do { volatile char *burnm = (volatile char *)(mem); int burnc = size; while (burnc--) *burnm++ = 0; } while (0)
#endif

template <class T>
class SecureAllocator
    : public std::allocator<T>
{
public:
    template<class U> struct rebind
    {
        typedef SecureAllocator<U> other;
    };

    SecureAllocator() throw()
        : std::allocator<T>()
    {

    }

    SecureAllocator(const SecureAllocator& other) throw()
        : std::allocator<T>(other)
    {

    }

    template <class U> SecureAllocator(const SecureAllocator<U>& other) throw()
        : std::allocator<T>(other)
    {

    }

    void deallocate(T* ptr, std::size_t n) {
        if (ptr != nullptr && n > 0) {
            secure_zeromem(ptr, n * sizeof(T));
        }
        std::allocator<T>::deallocate(ptr, n);
    }
};

typedef std::vector<unsigned char, SecureAllocator<unsigned char> > SecureVector;
typedef std::basic_string<char, std::char_traits<char>, SecureAllocator<char> > SecureString;

int main() {
    SecureVector vec = {1, 2, 3, 4, 5};
    SecureString str = "Hello, World!";

    std::cout << "Secure Vector: ";
    for (auto& elem : vec) {
        std::cout << elem << " ";
    }
    std::cout << std::endl;

    std::cout << "Secure String: " << str << std::endl;

    return 0;
}