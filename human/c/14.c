#include <pwd.h>
#include <shadow.h>
#include <unistd.h>
#include <string.h>
#include <stdio.h>

int sys_auth_user (const char* username, const char* password)
{
  struct passwd *pw;
  struct spwd *sp;
  char *encrypted, *correct;

  pw = getpwnam(username);
  endpwent();

  if (!pw) return 1; // user doesn't really exist

  sp = getspnam(pw->pw_name);
  endspent();
  if (sp)
     correct = sp->sp_pwdp;
  else
     correct = pw->pw_passwd;

  encrypted = crypt(password, correct);
  return strcmp(encrypted, correct) ? 2 : 0;  // bad pw=2, success=0
}

int main() {
    const char* username = "your_username";
    const char* password = "your_password";
    int result = sys_auth_user(username, password);
    printf("Result: %d\n", result);
    return 0;
}