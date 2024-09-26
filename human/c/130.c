#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NAME 80
#define MAX_NOTES 100
#define MAX_NOTESIZE 100

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <note_name>\n", argv[0]);
        return 1;
    }

    char *note_name = argv[1];
    char notes[MAX_NOTES][MAX_NAME];
    char note_contents[MAX_NOTES][MAX_NOTESIZE];
    int note_count = 0;

    // Initialize notes array
    for (int i = 0; i < MAX_NOTES; i++) {
        strcpy(notes[i], "");
        strcpy(note_contents[i], "");
    }

    // Load existing notes
    FILE *fp = fopen("notes.dat", "r");
    if (fp != NULL) {
        while (fscanf(fp, "%s %s", notes[note_count], note_contents[note_count]) == 2) {
            note_count++;
            if (note_count >= MAX_NOTES) break;
        }
        fclose(fp);
    }

    // Find note
    int found = 0;
    for (int i = 0; i < note_count; i++) {
        if (strcmp(note_name, notes[i]) == 0) {
            printf("Note found: %s\n", note_contents[i]);
            found = 1;
            break;
        }
    }

    if (!found) {
        printf("Note not found.\n");
    }

    return 0;
}