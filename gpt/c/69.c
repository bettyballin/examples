
void encrypt(int rail, char *plain) {
    char railfence[rail][MAX], buf[2];
    int i, j;
    int number = 0, increment = 1;
    int charCount = 0; // New variable to track the number of characters printed

    buf[1] = '\0';
    for (i = 0; i < rail; i++)
        railfence[i][0] = '\0';

    for (i = 0; plain[i] != '\0'; i++) {
        if (number + increment == rail)
            increment = -1;
        else if (number + increment == -1)
            increment = 1;

        buf[0] = plain[i];
        strcat(railfence[number], buf);
        number += increment;
    }

    for (i = 0; i < rail; i++) {
        for (j
