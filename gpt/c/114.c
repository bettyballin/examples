
#include <stdio.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char *argv[]) // Use char* instead of string typedef
{
    if(argc != 2)
    {
        printf("Usage: ./crack1 hash\n");
        return 1;
    }

    printf("Input the salt: ");
    char salt[3]; // Allocate space for two chars plus the null terminator
    scanf("%2s", salt); // Read only two characters for the salt

   
