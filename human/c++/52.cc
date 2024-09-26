cpp
#include <cstdarg>
#include <cstdio>
#include <cstdlib>

/*@manual log
Reports error message and exits with code 128.
*/
#ifdef _MSC_VER

__declspec(noreturn) void pbc_die(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
    exit(128);
}

#else

void pbc_die(const char *err, ...) __attribute__((__noreturn__))
__attribute__((format(printf, 1, 2)));

void pbc_die(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
    exit(128);
}

#endif

/*@manual log
Reports informational message.
*/
#ifdef _MSC_VER

void pbc_info(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vprintf(err, args);
    va_end(args);
}

#else

void pbc_info(const char *err, ...) __attribute__((format(printf, 1, 2)));

void pbc_info(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vprintf(err, args);
    va_end(args);
}

#endif

/*@manual log
Reports warning message.
*/
#ifdef _MSC_VER

void pbc_warn(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
}

#else

void pbc_warn(const char *err, ...) __attribute__((format(printf, 1, 2)));

void pbc_warn(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
}

#endif

/*@manual log
Reports error message.
*/
#ifdef _MSC_VER

void pbc_error(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
}

#else

void pbc_error(const char *err, ...) __attribute__((format(printf, 1, 2)));

void pbc_error(const char *err, ...) {
    va_list args;
    va_start(args, err);
    vfprintf(stderr, err, args);
    va_end(args);
}

#endif

int main() {
    pbc_die("This is a fatal error: %d\n", 1);
    pbc_info("This is an info message: %d\n", 2);
    pbc_warn("This is a warning message: %d\n", 3);
    pbc_error("This is an error message: %d\n", 4);
    return 0;
}