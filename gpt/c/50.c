
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <unistd.h>

int main() {
    off_t phys_addr = 0x60000000; // The physical address you want to access
    size_t page_size = getpagesize(); // Get the system page size
    size_t map_size = page_size;
    off_t page_base = (phys_addr / page_size) * page_size;
    off
