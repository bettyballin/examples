
char *decryption(char Ciphered[MAXSIZE], int A, int B, int inverse) {
    static char NewPlaintext[MAXSIZE];
    int i;
    int x;
    int index;
    for (i = 0; i < strlen(Ciphered); i++) {
        if (Ciphered[i] == ' ') {
            NewPlaintext[i] = ' ';
        } else {
            index = (int)Ciphered[i] - 'a';
            x = (
