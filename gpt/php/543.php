
   // Hashing a password before storing it
   $hashed_password = password_hash($passwordGiven, PASSWORD_DEFAULT);

   // Verifying a password during login
   if (password_verify($passwordGiven
