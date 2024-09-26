#include <unistd.h>

int main() {
    char *file = "test.txt";
    execl("/usr/bin/touch", "touch", file, (char *)NULL);
}