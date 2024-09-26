#include <stdio.h>
#include <string.h>

typedef int (*fn_ptr)(char *);

int truncate_and_call(fn_ptr *fns, int index, char *user_string)
{
  char buf[64];
  // Truncate supplied string
  strncpy(buf, user_string, sizeof(buf) - 1);
  buf[sizeof(buf) - 1] = '\0';
  return fns[index](buf);
}

int main(int argc, char **argv)
{
  if (argc != 3)
  {
    printf("Usage: %s <index> <string>\n", argv[0]);
    return 1;
  }

  int index = atoi(argv[1]);
  char *user_string = argv[2];

  // Define function pointers
  int fn1(char *str) { printf("Function 1 called with: %s\n", str); return 0; }
  int fn2(char *str) { printf("Function 2 called with: %s\n", str); return 0; }

  fn_ptr fns[] = {fn1, fn2};

  // Check if index is within bounds
  if (index < 0 || index >= sizeof(fns) / sizeof(fns[0]))
  {
    printf("Index out of bounds\n");
    return 1;
  }

  return truncate_and_call(fns, index, user_string);
}