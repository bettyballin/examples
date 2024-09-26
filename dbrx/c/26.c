#include <stdio.h>
#include <stdlib.h>

int main()
{
    char ifp[256];
    FILE *fin;

    printf("Enter the file path: ");
    scanf("%255s", ifp);

    fin = fopen(ifp, "r");

    if (fin == NULL)
        printf("Error opening file\n");
    else
    {
        // action
        fclose(fin);
    }

    return 0;
}