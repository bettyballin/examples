#include <stdio.h>
#include <pwd.h>
#include <string.h>
#include <unistd.h>

int main() {
    // Prompt user for username and password
    char username[100];
    char password[100];
    printf("Enter your username: ");
    fgets(username, 100, stdin);
    username[strcspn(username, "\n")] = '\0'; // Remove newline character

    printf("Enter your password: ");
    fgets(password, 100, stdin);
    password[strcspn(password, "\n")] = '\0'; // Remove newline character

    // Get the user's password entry using getpwuid()
    struct passwd *pwd;
    pwd = getpwuid(getuid());

    // Verify the password
    if (strcmp(password, pwd->pw_passwd) == 0) {
        printf("Authentication successful!\n");
    } else {
        printf("Incorrect password\n");
    }

    return 0;
}