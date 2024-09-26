
   // Hashing a password
   $password = "user_password";
   $hash = password_hash($password, PASSWORD_DEFAULT);

   // Verifying a password
   if (password_verify($password, $hash)) {
       // Password is correct
   } else {
       // Password is incorrect
   }
   
