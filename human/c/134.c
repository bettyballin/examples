#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NOTES 5
#define MAX_NOTE_LENGTH 100

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <note>\n", argv[0]);
        return 1;
    }

    FILE *file = fopen("notes.txt", "r");
    if (file == NULL) {
        file = fopen("notes.txt", "w");
        if (file == NULL) {
            printf("Error opening file.\n");
            return 1;
        }
        fclose(file);
        file = fopen("notes.txt", "r");
        if (file == NULL) {
            printf("Error opening file.\n");
            return 1;
        }
    }

    char notes[MAX_NOTES][MAX_NOTE_LENGTH];
    int num_notes = 0;

    char buffer[MAX_NOTE_LENGTH];
    while (fgets(buffer, MAX_NOTE_LENGTH, file) != NULL) {
        strncpy(notes[num_notes], buffer, MAX_NOTE_LENGTH);
        notes[num_notes][MAX_NOTE_LENGTH - 1] = '\0';
        num_notes++;
        if (num_notes >= MAX_NOTES) {
            break;
        }
    }

    fclose(file);

    if (num_notes == 0) {
        printf("No notes found.\n");
        return 0;
    }

    printf("Notes:\n");
    for (int i = 0; i < num_notes; i++) {
        printf("%s", notes[i]);
    }

    return 0;
}