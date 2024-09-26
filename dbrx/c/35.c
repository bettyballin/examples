#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <wctype.h>

wchar_t *Crypto(wchar_t *a, int k);

int main(int argc, wchar_t **argv)
{
    int k = 3; // Define the shift value

    wprintf(L"Enter the text you want to encrypt: ");
    wchar_t a[1024];
    fgetws(a, sizeof(a) / sizeof(wchar_t), stdin);
    wcscpy(a, wcschr(a, L'\n') ? L"" : a);

    wchar_t *b = Crypto(a, k);
    wprintf(L"%ls\n", b);  // Use %ls for wide-character strings

    return 0;
}

wchar_t *
Crypto(wchar_t *a, int k)
{
    size_t len = wcslen(a);
    int i;

    setlocale(LC_ALL, "");

    for (i = 0; i < len; ++i) {
        if (iswalpha((wint_t)a[i])) { // Use isw* functions instead of is*
            a[i] += k;
            while ((a[i] > L'Z' && iswupper((wint_t)a[i])) || (a[i] > L'z' && iswlower((wint_t)a[i]))) {
                if (iswupper((wint_t)a[i]))
                    a[i] -= 26;   // Wrap around to 'A'
                else
                    a[i] -= 26;    // Wrap around to 'a'
            }
        } else {                   // Non-alphabetic characters are left unchanged
            continue;
        }
    }

    return a;
}