#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* strtrns(const char *srcstr, const char *oldtxt, const char *newtxt, char* result)
{
    char *p = strstr(result, oldtxt);
    while (p != NULL)
    {
        strcpy(p, newtxt);
        p = strstr(p + strlen(newtxt), oldtxt);
    }
    return result;
}

char* alloc_strtrns(const char *srcstr, const char *oldtxt, const char *newtxt)
{
    if (strlen(oldtxt) != strlen(newtxt))
    {
        return NULL;    /* Old and New lengths MUST match */
    }

    char* result = strdup(srcstr);    
    if (result == NULL) 
    {
        return NULL;    /* Memory allocation failed */
    }

    return strtrns(srcstr, oldtxt, newtxt, result);
}

int main()
{
    const char* srcstr = "Hello, world! Hello again!";
    const char* oldtxt = "Hello";
    const char* newtxt = "Goodbye";
    char* result = alloc_strtrns(srcstr, oldtxt, newtxt);
    if (result != NULL)
    {
        printf("Result: %s\n", result);
        free(result);
    }
    else
    {
        printf("Memory allocation failed\n");
    }
    return 0;
}