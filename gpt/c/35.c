
// get peer address
int sock_fd;
if (BIO_get_fd(new_client, &sock_fd) <= 0) { // Make sure to use new_client BIO, not the listening socket BIO
    fprintf(stderr, "Uninitialized socket passed to worker");
    goto listen_cleanup;
}
printf("socket fd: %i\n", sock_fd);

struct sockaddr_storage addr; // Use sockaddr_storage to have enough space for IPv4/IPv6
socklen_t addr_len = sizeof(addr); // Initialize addr_len with the size of addr

// Get the peer address
if (getpeername(sock_fd, (struct sockaddr*)&addr, &addr_len) != 0) {
    perror("getpeername failed");
    goto
