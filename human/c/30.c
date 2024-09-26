#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    struct Node* bk;
    struct Node* fd;
} Node;

#define unlink(P, BK, FD) {            
    BK = P->bk;                          
    FD = P->fd;                          
    FD->bk = BK;                         
    BK->fd = FD;                         
}

int main() {
    Node* head = (Node*)malloc(sizeof(Node));
    head->bk = head;
    head->fd = head;

    Node* node1 = (Node*)malloc(sizeof(Node));
    node1->bk = head;
    node1->fd = head;
    head->bk = node1;
    head->fd = node1;

    Node* node2 = (Node*)malloc(sizeof(Node));
    node2->bk = node1;
    node2->fd = head;
    node1->fd = node2;
    head->bk = node2;

    Node* BK;
    Node* FD;

    unlink(node1, BK, FD);

    printf("%p %p\n", BK, FD);

    free(head);
    free(node1);
    free(node2);

    return 0;
}