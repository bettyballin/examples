#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        exit(1);
    }

    struct sockaddr_in serv_addr;
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(8080);
    inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr);

    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("connection failed");
        exit(1);
    }

    struct sockaddr addr;
    socklen_t addrlen = sizeof(addr);
    if (getpeername(sockfd, &addr, &addrlen) < 0) {
        perror("getpeername failed");
        exit(1);
    }

    char ip[INET_ADDRSTRLEN];
    inet_ntop(AF_INET, &((struct sockaddr_in*)&addr)->sin_addr, ip, INET_ADDRSTRLEN);
    printf("Peer IP address: %s\n", ip);
    printf("Peer port: %d\n", ntohs(((struct sockaddr_in*)&addr)->sin_port));

    close(sockfd);
    return 0;
}