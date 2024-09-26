#include <stdio.h>
#include <string.h>

#define MSG_LEN 256

int main() {
    char msg[MSG_LEN];

    while (1) {
        size_t len;

        putchar(':');

        if (!fgets(msg, sizeof(msg), stdin)) break;

        msg[strcspn(msg, "\r\n")] = '\0';

        printf("%s", msg);

        len = strlen(msg);

        if (len == MSG_LEN - 1) {
            putchar('\n');

            int c;

            while ((c = getchar()) != '\n' && c != EOF){}

            continue;
        }
    }

    return 0;
}