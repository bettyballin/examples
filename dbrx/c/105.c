#include <pthread.h>

int main() {
    volatile int c = 1;
    pthread_t thread;
    void *ptr = (void *)&c;
    return 0;
}