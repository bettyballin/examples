<?php

function pbkdf2($secret, $salt){
  // Generate a PBKDF2 hash

  return crypt(
    $secret,
    '$6$rounds=5000$' . base64_encode($salt)
   );
}

// Usage
echo pbkdf2('password', 'salt');

?>