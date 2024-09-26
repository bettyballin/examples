#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <linux/if_alg.h>

int main() {
    int sockfd = socket(AF_ALG, SOCK_SEQPACKET, 0);
    if (sockfd < 0) {
        perror("socket");
        exit(1);
    }

    struct sockaddr_alg sa = {
        .salg_family = AF_ALG,
        .salg_type   = "akcipher",
        .salg_name   = "rsa-generic"
    };

    if (bind(sockfd, (struct sockaddr *)&sa, sizeof(sa)) < 0) {
        perror("bind");
        exit(1);
    }

    return 0;
}