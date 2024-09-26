#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    int connfd = 0; // replace with your actual socket file descriptor
    struct ucred creds;
    socklen_t credslen = sizeof(creds);

    int rc = getsockopt(connfd, SOL_SOCKET, SO_PEERCRED, &creds, &credslen);

    return 0;
}