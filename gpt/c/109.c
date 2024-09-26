
   #include <termios.h>
   #include <stdio.h>

   void prompt_password(char *password, size_t max_len) {
       struct termios old_term, new_term;

       // Turn echoing off
       tcgetattr(STDIN_FILENO, &old_term);
       new_term = old_term;
       new_term.c_lflag &= ~ECHO;
       tcsetattr(STDIN_FILENO, TCSANOW, &new_term);

       // Prompt for the password
       printf("Enter your password: ");
       fgets(password, max_len, stdin);

       // Restore terminal
       tcsetattr(STDIN_FILENO, TCSANOW
