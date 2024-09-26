<?php
$hashed_password = '$2y$10$randomsaltvaluehere'; // replace with your hashed password
$user_input = 'password123'; // replace with your user input

if (hash_equals($hashed_password, crypt($user_input, $hashed_password))) {
   echo "Password verified!";
} else {
   echo "Password not verified!";
}
?>