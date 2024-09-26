
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <crypt.h>

int main(void)
{
  char salt[] = "00";
  char *password;
  char *guess;
  char stored_password[256]; // Make sure this buffer is large enough to hold the encrypted password

  password = crypt(getpass("Enter Password1:"), salt);
  strncpy(stored_password, password, sizeof(stored_password) - 1); // Copy the result
  stored_password[sizeof(stored_password) - 1] = '\0'; // Ensure null termination
