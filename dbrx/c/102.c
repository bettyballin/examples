#include <stdio.h>
#include <string.h>

#define MSG_LEN 25

int main(){
    char msg[MSG_LEN];
    int i;

    while(1) {
        putchar(':');
        if (fgets(msg, sizeof(msg), stdin) == NULL)
            break;
        
        for(i = 0; i < strlen(msg); i++){
            putchar(msg[i]);
        }
        
        if(strlen(msg) == MSG_LEN - 2){
            printf("\n");
            while(fgets(msg, sizeof(msg), stdin) != NULL && msg[strlen(msg)-1] != '\n');
        } else {
            for(i = strlen(msg); i < MSG_LEN; i++){
                putchar(' ');
            }
        }

    }
    
    return 0;
}