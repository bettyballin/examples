#include <stdio.h>
#include <ctype.h>

int main() {
    char copy[] = "HELLO WORLD";
    char enc[20];
    int k = 3;
    char copykey[] = "KEY";
    int t = strlen(copy);
    int i, j = 0;

    for (i=0;i<=t;i++)
    {
        if (isupper(copy[i]))
        {
            enc[i]=(copy[i]+copykey[j])%26+'A';
            j++;
            if (j >= k)
                j=0;
        }
        else enc[i]=copy[i];
    }

    printf("%s\n", enc);
    return 0;
}