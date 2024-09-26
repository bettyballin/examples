#include <pthread.h>
#include <stdio.h>

void* thread_func(void* arg) {
    volatile int* c = (volatile int*)arg;
    *c = 0;
    return NULL;
}

int main() {
    volatile int c = 1;
    pthread_t thread;
    void *ptr = (void *)&c;

    pthread_create(&thread, NULL, thread_func, ptr);

    while(c) {
        // ...
    }

    pthread_join(thread, NULL);
    return 0;
}