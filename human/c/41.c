#include <stdio.h>

short gfMultiply(short h1, short h2)
{
    short r;
    if(h1==0x01)
        return h2;
    if(h1==0x02)
    {
        r = (h2<<1);
        if(r>0xFF)
            r = r^0x11b;
    }
    else
    {
        r = (h2<<1);
        if(r>0xFF)
            r = r^0x11b;
        r = r^h2;
    }
    return r;
}

int main() {
    short h1 = 0x02;
    short h2 = 0x05;
    short result = gfMultiply(h1, h2);
    printf("%x\n", result);
    return 0;
}