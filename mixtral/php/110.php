<?php
$stored_hash = '$2y$10$randomsaltvaluehere'; // retrieve from database
$user_input = 'user_input_password';

if(crypt($user_input, $stored_hash) == $stored_hash){
    echo "Password verified!";
}
else{
   echo "Invalid password.";
}
?>