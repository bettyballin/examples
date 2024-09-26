#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define alphabetsize 26

char alphabet[alphabetsize] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
char lookup[alphabetsize] = {'0'};

int search(char ch){
  int i;
  for(i=0; i< alphabetsize; i++){
    if(alphabet[i] == ch) return i;
   }
  return -1; // return -1 if character not found
}

void rotate(const char string[], size_t len, int rotn){
  char rotated[len + 1];
  for(size_t i = 0; i < len; i++){
    int index = search(string[i]);
    if(index != -1){
      rotated[i] = alphabet[(index + rotn) % alphabetsize];
    } else {
      rotated[i] = string[i];
    }
  }
  rotated[len] = '\0';
  printf("Rotated string: %s\n", rotated);
}

int main(){
  char string[] = "hello";
  size_t len = strlen(string);
  int rotn = 3;
  rotate(string, len, rotn);
  return 0;
}