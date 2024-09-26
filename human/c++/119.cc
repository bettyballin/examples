cpp
#include <cstdint>
#include <cstring>

typedef struct {
    uint32_t Intermediate_Hash[5];
    uint32_t Length_Low;
    uint32_t Length_High;
    uint8_t Message_Block[64];
    int Message_Block_Index;
} SHA1Context;

void SHA1ProcessMessageBlock(SHA1Context* context) {
    // Your SHA1ProcessMessageBlock implementation here
}

void SHA1PadMessage(SHA1Context* context) {
    if (context->Message_Block_Index > 55) {
        context->Message_Block[context->Message_Block_Index++] = 0x80;
        while (context->Message_Block_Index < 64) {
            context->Message_Block[context->Message_Block_Index++] = 0;
        }

        SHA1ProcessMessageBlock(context);

        while (context->Message_Block_Index < 56) {
            context->Message_Block[context->Message_Block_Index++] = 0;
        }
    } else {
        context->Message_Block[context->Message_Block_Index++] = 0x80;
        while (context->Message_Block_Index < 56) {
            context->Message_Block[context->Message_Block_Index++] = 0;
        }
    }

    context->Message_Block[56] = context->Length_High >> 24;
    context->Message_Block[57] = context->Length_High >> 16;
    context->Message_Block[58] = context->Length_High >> 8;
    context->Message_Block[59] = context->Length_High;
    context->Message_Block[60] = context->Length_Low >> 24;
    context->Message_Block[61] = context->Length_Low >> 16;
    context->Message_Block[62] = context->Length_Low >> 8;
    context->Message_Block[63] = context->Length_Low;

    SHA1ProcessMessageBlock(context);
}

int main() {
    SHA1Context context;
    // Initialize the context
    context.Length_Low = 0;
    context.Length_High = 0;
    context.Message_Block_Index = 0;
    memset(context.Message_Block, 0, 64);

    // Your message here
    uint8_t message[] = "Hello, World!";
    for (int i = 0; i < strlen((char*)message); i++) {
        context.Message_Block[context.Message_Block_Index++] = message[i];
    }

    SHA1PadMessage(&context);

    return 0;
}