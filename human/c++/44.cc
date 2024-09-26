cpp
#include <Windows.h>
#include <vector>

std::vector<char> RData;

void Resource(int id)
{
    size_t Rsize;

    HRSRC hResource = FindResource(NULL, MAKEINTRESOURCE(1), RT_RCDATA);
    HGLOBAL temp = LoadResource(NULL, hResource);
    Rsize = SizeofResource(NULL, hResource);
    RData.resize(Rsize);
    memcpy((void*)RData.data(), LockResource(temp), Rsize);
}

int main()
{
    Resource(1);
    return 0;
}