#include <stdbool.h>
#include <limits.h>

bool isValidAddition(unsigned short x, unsigned short y)
{
    if (y <= USHRT_MAX - x)
        return true;

    // Handle overflow
    else
        return false;
}

int main()
{
    unsigned short x = 65530;
    unsigned short y = 10;
    printf("%d\n", isValidAddition(x, y));
    return 0;
}