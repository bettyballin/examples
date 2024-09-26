
#include <stdio.h>
#include <errno.h>

int main() {
    FILE *fin = NULL;
    FILE *fout = NULL;
    char ifp[260]; // Adjust the size as needed for the file path
    char ofp[260];

    // Get file paths from the user
    printf("Enter the input file path: ");
    scanf("%259s", ifp); // Always specify a limit to prevent buffer overflow
    printf("Enter the output file path: ");
    scanf("%259s", ofp);

    // Use fopen_s to open files
    errno_t errIn = fopen_s(&fin, ifp, "r");
    errno_t errOut = fopen_s(&fout, ofp, "w");

    if (errIn != 0
