cpp
#include <iostream>

template<typename T>
bool next_combination(T* data_begin, T* data_end, T* _max, short* pos)
{
    if (data_begin == data_end) return false;

    T* data_cur = data_begin;
    while (++*data_cur == _max[*pos])
    {
        *data_cur = 0;
        ++data_cur;
        ++*pos;
        if (data_cur == data_end)
            return false;
    }

    *pos = 0;
    return true;
}

int main()
{
    short dataMax[] = {3, 4, 2};
    short n = 3;

    short* data = new short[n]{0};
    short pos = 0;

    std::cout << "List of all combinations:" << std::endl;
    do {
        for(int i = 0; i < n; i++) std::cout << data[i];
        std::cout << '\n';
    } while(next_combination<short>(&data[0], &data[n], dataMax, &pos));

    delete[] data;
    return 0;
}