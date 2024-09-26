#include <sys/socket.h>
#include <linux/alg.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>

int main() {
    int sockfd = socket(AF_ALG, SOCK_SEQPACKET, 0);
    if (sockfd < 0) {
        perror("socket failed");
        return 1;
    }

    struct sockaddr_alg sa = {
        .salg_family = AF_ALG,
        .salg_type = "akcipher",
        .salg_name = "rsa"
    };

    if (bind(sockfd, (struct sockaddr *)&sa, sizeof(sa)) < 0) {
        perror("bind failed");
        close(sockfd);
        return 1;
    }

    // Now you can use the socket to call the crypto API
    // ...

    close(sockfd);
    return 0;
}