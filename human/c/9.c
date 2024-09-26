#include <stdio.h>
#include <string.h>

typedef struct {
    unsigned char tag;
    unsigned short length;
    char value[256];
} TLV;

int main() {
    TLV tlv[3];

    tlv[0].tag = 0x10;
    tlv[0].length = 0x0018;
    strcpy(tlv[0].value, "user data");

    tlv[1].tag = 0x11;
    tlv[1].length = 0x0003;
    strcpy(tlv[1].value, "tom");

    tlv[2].tag = 0x12;
    tlv[2].length = 0x000F;
    strcpy(tlv[2].value, "tom@hotmail.com");

    printf("Tag: 0x%02X User data. Length: 0x%04X Value: %s\n", 
           tlv[0].tag, tlv[0].length, tlv[0].value);
    printf("    Tag 0x%02X: user name Length: 0x%04X Value = %s\n", 
           tlv[1].tag, tlv[1].length, tlv[1].value);
    printf("    Tag 0x%02X: email. Length: 0x%04X. Value = %s\n", 
           tlv[2].tag, tlv[2].length, tlv[2].value);

    return 0;
}