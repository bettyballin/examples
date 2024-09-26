<?php

function generateSalt($length = 10) {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';

    // Generate a pseudo-random string
    $string = '';

    for ($i = 0; $i < $length; ++$i) {
        $index = rand(0, strlen($characters) - 1);

        if (isset($characters[$index]))
            $string .= $characters[$index];

        else
           --$i;
    }

   // Generate a truly random number
   $int = random_int(-2123, 2123);

  return hash('sha256', $string . $int);
}

// Test the function
$salt = generateSalt();
echo $salt;

?>