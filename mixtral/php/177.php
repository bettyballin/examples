<?php
$password = 'user password';

// Hash the user's input
$hashed_input = '$2y$10$.vGA1O9wmRjrwAVXD98HNOgsNpDczlqm3Jq7KnEd1rVAGv3Fykk1a';

// Check if the hash of the user's input matches with stored password
if (crypt($password, $hashed_input) === $hashed_input){
    echo "Password verified!";
} else {
    echo 'Invalid Password.';
}
?>