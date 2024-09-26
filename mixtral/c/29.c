#include <stdio.h>

int main() {
    FILE *fin = NULL;
    FILE *fout = NULL;
    errno_t err1 = fopen_s(&fin, "ifp", "r");
    if (err1 != 0) {
        printf("Error opening input file\n");
    }

    errno_t err2 = fopen_s(&fout, "ofp", "w");
    if(err2 != 0){
       printf("Error opening output file\n");
    }

    // If both files are opened successfully
    else {
        // Your action here

        if (fin)
            fclose(fin);

        if (fout)
           fclose(fout);
    }
    return 0;
}