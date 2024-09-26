#include <stdio.h>
#include <string.h>

#define MSG_LEN 25

int main(){

  char msg[MSG_LEN];
  while(1) {
    puts(":");
    fgets(msg, MSG_LEN, stdin);
    printf("%s", msg);
    if (strlen(msg) == MSG_LEN - 1) printf("\n");
    while (strlen(msg) == MSG_LEN - 1) fgets(msg, MSG_LEN, stdin);
  }
  return 0;
}