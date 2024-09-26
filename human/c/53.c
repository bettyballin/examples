#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    system("sudo touch foo.conf");
    system("sudo touch foo.conf-insecure-sample");
    system("mv -f foo.conf-insecure-sample foo.conf");
    return 0;
}