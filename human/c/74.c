#include <stdio.h>

int main() {
  char buf[1024];
  char *s;
  if ((s = fgets(buf, sizeof buf, stdin)) != NULL) {
      puts(s);
  }
  return 0;
}