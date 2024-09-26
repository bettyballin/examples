#include <windows.h>

#define n 100

struct pdata
{
     PIMAGE_THUNK_DATA p_thunk_data;
     PIMAGE_THUNK_DATA pf_thunk_data;
};

struct pdata pdatas[n];

int main() {
    return 0;
}