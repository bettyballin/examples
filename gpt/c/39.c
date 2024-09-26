
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int is_valid_option(const char *option) {
    // Define a whitelist of valid characters for the option.
    // For `ls`, this might include characters like 'l', 'a', 'h', etc.
    const char *valid_options = "lah";

    // Check each character in the option
    while (*option) {
        if (strchr(valid_options, *option) == NULL) {
            // If the character is not in the whitelist, return false.
            return 0;
