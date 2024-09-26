#include <stdio.h>
#include <stdlib.h>

// Define the structure of a chunk
typedef struct chunk {
    size_t prev_size;
    size_t size;
    void* fd;
    void* bk;
} chunk;

int main() {
    // Create a new chunk
    chunk* c = (chunk*) malloc(sizeof(chunk) + 16); // 16 bytes of user data

    // Initialize the chunk
    c->prev_size = 0;
    c->size = sizeof(chunk) + 16;
    c->fd = NULL;
    c->bk = NULL;

    // Print the chunk's contents
    printf("Chunk address: %p\n", (void*) c);
    printf("Prev size: %zu\n", c->prev_size);
    printf("Size: %zu\n", c->size);
    printf("FD: %p\n", c->fd);
    printf("BK: %p\n", c->bk);

    // Free the chunk
    free(c);

    return 0;
}