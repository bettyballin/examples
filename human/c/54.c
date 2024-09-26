#include <stdio.h>
#include <string.h>

int main() {
    unsigned char step1_buf[] = "your_data_here";
    int i;

    printf("a4 aes en data is \n");
    for(i = 0; i < strlen((char*)step1_buf); i++)
        printf("%02x", step1_buf[i]);
    printf("\n");

    return 0;
}