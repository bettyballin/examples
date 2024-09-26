function verify_password($plainTextPassword, $hashedOldPassword)
{
   if (substr($hashedOldPassword, 0, 3) == '$2a') {
      return crypt($plainTextPassword, substr($hashedOldPassword, 4)) === $hashedOldPassword;

    } else if(substr($hashedOldPassword, 0, 3) == '$2y' || substr($hashedOldPassword, 0, 6) == '$argon') {
      return password_verify($plainTextPassword, $hashedOldPassword);

    } else {
       throw new Exception("Invalid hash format");

   }
}