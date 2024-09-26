#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    int sock_fd;
    struct sockaddr_in addr;
    socklen_t addr_len;

    // assuming sock_fd is a valid socket file descriptor
    addr_len = sizeof(addr);
    getpeername(sock_fd, (struct sockaddr *)&addr, &addr_len);

    return 0;
}