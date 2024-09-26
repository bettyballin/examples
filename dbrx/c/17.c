#include <fcntl.h>
#include <sys/mman.h>
#include <unistd.h>
#include <stdio.h>

int main() {
    int fd = open("/dev/mem", O_RDONLY);
    if (fd == -1) {
        perror("open");
        return 1;
    }

    void *map_base, *virt_addr;
    off64_t target_phys_addr = 0x60000000;

    /* Map one page */
    map_base = mmap(NULL, sysconf(_SC_PAGE_SIZE), PROT_READ | PROT_WRITE, MAP_SHARED, fd, target_phys_addr & ~(sysconf(_SC_PAGE_SIZE) - 1));

    if (map_base == MAP_FAILED) {
        perror("mmap");
        return 1;
    }

    /* Calculate the virtual address that maps to our physical address */
    virt_addr = map_base + (target_phys_addr % sysconf(_SC_PAGE_SIZE));
    
    // Now you can read from `virt_addr`
    printf("Virtual address: %p\n", virt_addr);

    munmap(map_base, sysconf(_SC_PAGE_SIZE));

    close(fd);
    return 0;
}