cpp
#include <boost/function_traits.hpp>
#include <boost/typeof/typeof.hpp>

template<typename T>
unsigned long getArgCount()
{
    return boost::function_traits<boost::remove_pointer<T>::type>::arity;
}

int main()
{
    void (*pFunc)(int, int);
    unsigned long argCount = getArgCount<BOOST_TYPEOF(pFunc)>();
    return 0;
}