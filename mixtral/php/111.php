<?php

// User input
$userInput = 'mysecretpassword';

// Hashing the password
$hashedPassword = password_hash($userInput, PASSWORD_DEFAULT);

// Storing the hashed password in the database (simulated)
$storedHashedPassword = $hashedPassword;

// Later when verifying login
$inputFromUser = 'mysecretpassword'; // Input from user

if(password_verify($inputFromUser, $storedHashedPassword)){
    echo "Logged In!";
}
else{
   echo "Invalid password.";
}

?>