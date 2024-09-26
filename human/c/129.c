#include <stdio.h>
#include <string.h>

#define USERNAME "user123"
#define DEBUG 1

void printNotes(int fd, int uid, char *searchstring) {
    char note_buffer[100];

    if (DEBUG) printf("[DEBUG] found a %lu byte note for user id %d\n", strlen(note_buffer), uid);

    printf("-------[ end of note data ]-------\n");
}

int findUserNote(int fd, int uid) {
    return 1; // Return a valid user ID
}

int main() {
    int fd = 1; // Replace with a valid file descriptor
    int uid = 1000;
    char searchstring[100] = "test";

    if (findUserNote(fd, uid)) {
        printNotes(fd, uid, searchstring);
    }

    return 0;
}