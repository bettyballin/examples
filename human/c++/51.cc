cpp
#include <cstdarg>
#include <cstdio>
#include <cstdlib>

void pbc_die(const char *err, ...)
    __attribute__((__noreturn__))
    __attribute__((format (printf, 1, 2)))
{
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
    fputc('\n', stderr);
    exit(128);
}

void pbc_info(const char *err, ...)
    __attribute__((format (printf, 1, 2)))
{
    va_list args;
    va_start(args, err);
    vfprintf(stdout, err, args);
    va_end(args);
    fputc('\n', stdout);
}

void pbc_warn(const char *err, ...)
    __attribute__((format (printf, 1, 2)))
{
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
    fputc('\n', stderr);
}

void pbc_error(const char *err, ...)
    __attribute__((format (printf, 1, 2)))
{
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
    fputc('\n', stderr);
}

int main() {
    pbc_info("Info message");
    pbc_warn("Warning message");
    pbc_error("Error message");
    // pbc_die("Die message");  // This will exit the program
    return 0;
}