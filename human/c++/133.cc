cpp
#include <Windows.h>

int main() {
    SetDefaultDllDirectories(LOAD_LIBRARY_SEARCH_SYSTEM32);
    return 0;
}